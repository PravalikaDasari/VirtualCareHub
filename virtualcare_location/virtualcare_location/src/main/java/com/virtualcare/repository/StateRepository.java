package com.virtualcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtualcare.entity.StateEntity;

public interface StateRepository extends JpaRepository<StateEntity, String> {

}
