package com.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.entity.BookAppointment;
import com.book.services.BookServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/bookappointment")
public class BookController
{
	@Autowired
	private BookServiceImpl bookServiceImpl;
	@PostMapping(path="/booknow")
    public ResponseEntity<BookAppointment> bookPatient(@RequestBody BookAppointment bookAppointment) {
	   System.out.println("post mapping");

	   bookServiceImpl.booknow(bookAppointment);

		ResponseEntity<BookAppointment> responseEntity = new ResponseEntity<>(bookAppointment, HttpStatus.CREATED);
		return responseEntity;
    }
}
