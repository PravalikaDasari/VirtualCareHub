package com.book.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.bean.BookAppointment;

public interface BookRepository  extends JpaRepository<BookAppointment, Long>  {

}
