package com.virtualcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtualcare.bean.StateBean;

public interface StateRepository extends JpaRepository<StateBean, String> {

}
