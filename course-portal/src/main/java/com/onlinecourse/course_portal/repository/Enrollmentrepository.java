package com.onlinecourse.course_portal.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinecourse.course_portal.model.Enrollment;
public interface Enrollmentrepository extends JpaRepository<Enrollment, Long> {
	 boolean existsByStudentEmailAndCourseTitle(String studentEmail, String courseTitle);
}
