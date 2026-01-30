const backendUrl = "http://localhost:8080/api/courses";

// Submit course form
document.getElementById("courseForm").addEventListener("submit", (e) => {
  e.preventDefault();

  const course = {
    title: title.value,
    description: description.value,
    instructor: instructor.value,
    duration: duration.value,
    price: +price.value,
    videoUrl: videoUrl.value,
    imageUrl: imageUrl.value
  };

  fetch(backendUrl, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(course)
  })
    .then((res) => res.json())
    .then(() => {
      alert("Course added!");
      courseForm.reset();
      loadCourses();
    })
    .catch(() => alert("Failed to add course."));
});

// Load courses
function loadCourses() {
  fetch(backendUrl)
    .then(res => res.json())
    .then(data => {
      const box = document.getElementById("course-container");
      box.innerHTML = ""; // clear old content

      data.forEach(c => {
        box.innerHTML += `
          <div class="course-card">
            <img src="images/${c.imageUrl}" alt="${c.title}" />
            <h3>${c.title}</h3>
            <p><b>Instructor:</b> ${c.instructor}</p>
            <p><b>Duration:</b> ${c.duration}</p>
            <p><b>Price:</b> ₹${c.price}</p>
            <p>${c.description}</p>
            <button onclick="window.open('${c.videoUrl}', '_blank')">Watch</button>
            <button onclick="del(${c.id})" style="background:#e74c3c;color:#fff;margin-top:8px">Delete</button>
          </div>`;
      });
    });
}


function del(id) {
  if (confirm("Delete this course?")) {
    fetch(`${backendUrl}/${id}`, { method: "DELETE" })
      .then(loadCourses)
      .catch(() => alert("Delete failed"));
  }
}


window.onload = loadCourses;
