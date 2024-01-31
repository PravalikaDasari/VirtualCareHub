package com.virtualcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.virtualcare.entity.AdminEntity;
import com.virtualcare.entity.PatientTrackingEntity;

import jakarta.transaction.Transactional;
@Transactional
public interface AdminRepository extends JpaRepository<AdminEntity, Long>
{

	@Modifying
	@Query(value = "update admin set status=:status where admin_id=:admin_id",nativeQuery = true)
	void updateById(Long admin_id, String status);

	@Modifying
	@Query(value = "update patient_tracking set test_status =:test_status,"
			+ "discharge_status=:discharge_status, test_report=:file where track_id=:id",nativeQuery = true)
	void updateTestStatus(Long id, String test_status, byte[] file, String discharge_status);

	@Query(value="select * from patient_tracking where track_id=:id ",nativeQuery = true)
	PatientTrackingEntity findByTrackId(Long id);

}
