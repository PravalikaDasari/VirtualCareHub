package com.virtualcare.service;

import java.util.List;

import com.virtualcare.bean.PatientTrackingBean;

public interface TrackingService
{
	void updateTest(PatientTrackingBean bean);
	List<PatientTrackingBean> fetchAll();
}
