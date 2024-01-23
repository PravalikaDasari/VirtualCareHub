package com.virtualcare_registartionAndLogin.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.virtualcare_registartionAndLogin.entity.DoctorEntity;

public interface DoctorRepository extends JpaRepository<DoctorEntity, Long>{

}
