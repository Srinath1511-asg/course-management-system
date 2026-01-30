package com.onlinecourse.course_portal.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinecourse.course_portal.model.Course;
public interface CourseRepository extends JpaRepository<Course, Long> {

}
