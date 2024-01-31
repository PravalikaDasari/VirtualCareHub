package com.book.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.entity.BookAppointment;
import com.book.repository.BookRepository;


@Service
public class BookServiceImpl implements  BookService{
	@Autowired
	private BookRepository bookRepository;
	@Override
	  public BookAppointment booknow(BookAppointment bookAppointment) {
        return bookRepository.save(bookAppointment);
    }


}

	


