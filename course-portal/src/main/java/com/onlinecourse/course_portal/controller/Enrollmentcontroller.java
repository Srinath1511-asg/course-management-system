package com.onlinecourse.course_portal.controller;

import com.onlinecourse.course_portal.model.Enrollment;
import com.onlinecourse.course_portal.service.EnrollmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enrollments")
@CrossOrigin("*")
public class Enrollmentcontroller {

    private final EnrollmentService enrollmentService;

    // Constructor injection
    public Enrollmentcontroller(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    // Create enrollment
    @PostMapping
    public Enrollment createEnrollment(@RequestBody Enrollment enrollment) {
        return enrollmentService.enrollStudent(enrollment);
    }

    // Get all enrollments
    @GetMapping
    public List<Enrollment> getAllEnrollments() {
        return enrollmentService.getAllEnrollments();
    }

    // Delete enrollment
    @DeleteMapping("/{id}")
    public void deleteEnrollment(@PathVariable Long id) {
        enrollmentService.deleteEnrollment(id);
    }
}
