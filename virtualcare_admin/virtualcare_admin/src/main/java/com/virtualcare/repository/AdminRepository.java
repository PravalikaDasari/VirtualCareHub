package com.virtualcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.virtualcare.entity.AdminEntity;

import jakarta.transaction.Transactional;
@Transactional
public interface AdminRepository extends JpaRepository<AdminEntity, Long>
{

	@Modifying
	@Query(value = "update admin set status=:status where admin_id=:admin_id",nativeQuery = true)
	void updateById(Long admin_id, String status);

}
