package com.virtualcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtualcare.entity.BranchEntity;

public interface BranchRepository extends JpaRepository<BranchEntity, String>{

}
