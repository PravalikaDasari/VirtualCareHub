package com.virtualcare_registartionAndLogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtualcare_registartionAndLogin.entity.PatientEntity;

public interface PatientRepository extends JpaRepository<PatientEntity, Long>{

}
