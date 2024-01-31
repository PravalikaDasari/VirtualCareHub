package com.virtualcaredoctor.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.virtualcaredoctor.bean.BookingAppointmentBean;
import com.virtualcaredoctor.bean.PatientTrackingBean;
import com.virtualcaredoctor.entity.BookingAppointmentEntity;
import com.virtualcaredoctor.entity.PatientTrackingEntity;
import com.virtualcaredoctor.repository.BookingAppointmentRepository;
import com.virtualcaredoctor.service.BookingAppointmentService;
import com.virtualcaredoctor.service.PatientTrackingService;
import com.virtualcaredoctor.serviceImplimentation.PatientTrackingServiceImplimentation;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/doctor")
@Slf4j
//port id is 8081
public class DoctorController {

	@Autowired
	BookingAppointmentService bookingAppointmentService;
	
	@Autowired
	PatientTrackingService patientTrackingService;
	
	
	
	
	@GetMapping("/check")
	public String check() {
		log.info("welcome to project");
		return "welcome to project";
	}
	
	//---------saving appointment details------------
	@PostMapping("/saveAppointedPatient")
	public String saveAppointedPatient(@RequestBody BookingAppointmentBean bean)
	{
		
		bookingAppointmentService.saveAppointedPatient(bean);
		return "inserted patient record";
	}
	
	@GetMapping(path="/updateAdmitStatus/{appointmentId}/{admitStatus}")
	public String updateAppointmentStatus(@PathVariable long appointmentId,@PathVariable String admitStatus) {
		bookingAppointmentService.updateAdmitStatus(appointmentId, admitStatus);
		return " admit status updated";
	}
	
	//-------------printing appointment details by date---------------
	@GetMapping(path="/getByDate/{appointmentDate}")
    public List<BookingAppointmentBean> getByAppointmentDate(@PathVariable String appointmentDate){
		  List<BookingAppointmentBean> byAppointmentDate = bookingAppointmentService.getByAppointmentDate(appointmentDate);
		  return byAppointmentDate;
	}


	
	
	
	
	
	
	
	
	
	
	//-------------printing patient Treatment details------------
	@GetMapping("/getPatientTrackDetails/{trackId}")
	public PatientTrackingBean getPatientTrackDetails(@PathVariable long trackId) {
		PatientTrackingBean bean = patientTrackingService.getPatientTreatmentDetails(trackId);
		return bean;
	}
	
   //	-----------updating patient Treatment details---------------
	@GetMapping("/updatePatientTrackDetails/{doctorId}/{patientId}/{testName}")
	public String updatePatientTestName(@PathVariable long doctorId,@PathVariable long patientId,@PathVariable String testName)
	{
		List<PatientTrackingBean> byPatientIdDoctorId = patientTrackingService.getByDoctorIdAndPatientId(doctorId, patientId);
        for (PatientTrackingBean patientTrackingBean : byPatientIdDoctorId) {
        	if(patientTrackingBean.getTest_name()==null)
        	{
        		patientTrackingService.updatePatientTestName(doctorId, patientId, testName);
        	}
        	else {
         		Date date2 = new Date(System.currentTimeMillis());
        		PatientTrackingEntity entity=new PatientTrackingEntity();
        		entity.setDate(date2);
        		entity.setDoctor_id(doctorId);
        		entity.setPatient_phone(patientId);
        		entity.setTest_name(testName);
        		patientTrackingService.savePatientTrackRecord(entity);
        		return "record inserted";
        	}
		}
        
		return "testname updated";
	}
	
	@GetMapping("/getPatientbyDoctorIdPatientId/{doctorId}/{patientId}")
	public List<PatientTrackingBean> getPatientTrackDetails(@PathVariable long doctorId,@PathVariable long patientId) {
		List<PatientTrackingBean> byPatientIdDoctorId = patientTrackingService.getByDoctorIdAndPatientId(doctorId, patientId);
		return byPatientIdDoctorId;
	}
	
	
}







