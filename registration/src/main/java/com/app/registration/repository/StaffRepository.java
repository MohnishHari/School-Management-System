package com.app.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.registration.model.Staff;


public interface StaffRepository extends JpaRepository<Staff, Long> {
}