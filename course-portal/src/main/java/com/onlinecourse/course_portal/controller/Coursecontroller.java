package com.onlinecourse.course_portal.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.onlinecourse.course_portal.model.*;
import com.onlinecourse.course_portal.repository.CourseRepository;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin("*")
public class Coursecontroller {
	
	@Autowired
	private CourseRepository courseRepository;
	@GetMapping
	public List<Course> getallCourses(){
		return courseRepository.findAll();
	}
	
	@PostMapping
	public Course addCourse(@RequestBody Course course) {
		return courseRepository.save(course);
		
	}
	@GetMapping("/test")
    public String testApi() {
        return "Working ✅";
    }
	@PutMapping("/{id}")
	public Course updateCourse(@PathVariable Long id, @RequestBody Course updatedCourse) {
	    Course existingCourse = courseRepository.findById(id)
	        .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));

	    existingCourse.setTitle(updatedCourse.getTitle());
	    existingCourse.setDescription(updatedCourse.getDescription());
	    existingCourse.setVideoUrl(updatedCourse.getVideoUrl());

	    return courseRepository.save(existingCourse);
	}
	@DeleteMapping("/{id}")
	public void deleteCourse(@PathVariable Long id) {
	    courseRepository.deleteById(id);
	}

	
	

}
