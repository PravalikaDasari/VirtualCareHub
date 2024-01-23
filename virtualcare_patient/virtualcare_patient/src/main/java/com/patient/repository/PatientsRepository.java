package com.patient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patient.bean.Patients;

public interface PatientsRepository  extends JpaRepository<Patients, Long>  {

}
