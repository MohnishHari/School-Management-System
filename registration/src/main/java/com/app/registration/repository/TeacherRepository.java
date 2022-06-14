package com.app.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.registration.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}