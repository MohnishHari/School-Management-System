package com.app.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.registration.model.Class;

public interface ClassRepository extends JpaRepository<Class, Long> {
}