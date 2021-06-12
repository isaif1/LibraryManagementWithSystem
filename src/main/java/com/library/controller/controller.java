package com.library.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.library.entities.Books;
import com.library.entities.paraQuery;
import com.library.service.BookService;

@RestController
public class controller {
	@Autowired
	private BookService bookService;

	//Finding Book By Title and Author(Search)
	@GetMapping("/books/findbook")
	public ResponseEntity<Books> getBookByNameAndAuthor(@RequestBody paraQuery para) {
		Books book= bookService.getBookByNameAndAuthor(para);
		if(book==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
	}
	
	//Get Book By Id(Search)
	@GetMapping("/books/{id}")
	public ResponseEntity<Books> getBook(@PathVariable("id") int id) {
		Books book= bookService.getBookById(id);
		if(book==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
	}
	
	//Create a Book(Add)
	@PostMapping("/books")
	public ResponseEntity<Books> addBook(@RequestBody Books book) {  //using requestbody whatever will be in json will be assign to book object
		Books b=null;
		try {
		b=bookService.addBook(book);
		return ResponseEntity.of(Optional.of(b));
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	//Delete Book By Id, first find using find API then get id and delete it(Delete)
	@DeleteMapping("/books/{bookId}")
	public ResponseEntity<Void> deleteBook(@PathVariable("bookId") int bookId) {
		try {
			this.bookService.deleteBook(bookId);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}		
	}

	//For Borrowing a book(Borrow)
	@PutMapping("/books/borrow")
	public ResponseEntity<Books> updateBook(@RequestBody paraQuery para) {  //using requestbody whatever will be in json will be assign to book object
		try {
			Books book=this.bookService.borrow(para);
			if(book==null)
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			return ResponseEntity.ok().body(book);			
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}	
	}	

	//When returning a book(Return)
	@PutMapping("/books/returnBook")
	public ResponseEntity<Books> updateBooks(@RequestBody paraQuery para) {  //using requestBody whatever will be in Json will be assign to book object
		try {
			Books book=this.bookService.returnBook(para);
			return ResponseEntity.ok().body(book);			
		}catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}	
	}
		
}
