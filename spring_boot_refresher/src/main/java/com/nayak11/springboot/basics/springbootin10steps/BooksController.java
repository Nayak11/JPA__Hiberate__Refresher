package com.nayak11.springboot.basics.springbootin10steps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BooksController {
	
	@GetMapping("/books")
	public List<Book> getBooks(){
		return new ArrayList<>(Arrays.asList(
				new Book(1l,"Mastering Spring Framework 5","Suhas Nayak"),
				new Book(2l,"Mastering Core Java","Suhas Nayak"),
				new Book(3l,"Mastering Hibernate","Suhas Nayak")
		));
	}

}
