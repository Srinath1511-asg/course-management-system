package com.onlinecourse.course_portal.service;

import com.onlinecourse.course_portal.model.Enrollment;
import com.onlinecourse.course_portal.repository.Enrollmentrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {

    @Autowired
    private Enrollmentrepository enrollmentRepository;

    // Enroll a student
    public Enrollment enrollStudent(Enrollment enrollment) {
        boolean alreadyExists = enrollmentRepository
                .existsByStudentEmailAndCourseTitle(enrollment.getStudentEmail(), enrollment.getCourseTitle());

        if (alreadyExists) {
            throw new IllegalStateException("Student already enrolled in this course.");
        }

        return enrollmentRepository.save(enrollment);
    }

    // Get all enrollments
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    // Delete enrollment by ID
    public void deleteEnrollment(Long enrollmentId) {
        enrollmentRepository.deleteById(enrollmentId);
    }
}
