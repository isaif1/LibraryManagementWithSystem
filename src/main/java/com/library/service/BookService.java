package com.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.dao.BookRepository;
import com.library.entities.Books;
import com.library.entities.paraQuery;

@Service   //We can Also put @Component to allow it to make object
public class BookService {
	@Autowired
	private BookRepository bookRepository;

//Find Book By Author and Title
public Books getBookByNameAndAuthor(paraQuery para) {
Books b=bookRepository.findThisBook(para.getTitle(),para.getFirstName(),para.getSecondName());   
return b;
}	
	
//Get Book By Id	
public Books getBookById(int id) {
	Books book=null;
	try {
	 book=this.bookRepository.findById(id);
	}catch(Exception e) {
		e.printStackTrace();
	}
	return book;
}

//Create a Book with Instance
public Books addBook(Books book) {
	Books b=bookRepository.findThisBook(book.getTitle(),book.getAuthor().getFirstName(),book.getAuthor().getSecondName());
	if(b!=null) {
		System.out.println("Data is present in database");	
		bookRepository.Update(b.getId(),book.getAvailableCopy());
		b=bookRepository.findThisBook(book.getTitle(),book.getAuthor().getFirstName(),book.getAuthor().getSecondName());
		return b;
	}
	else {
		this.bookRepository.save(book);
		return book;
	}
}

//Delete a Book By Id
public void deleteBook(int bid) {
	this.bookRepository.deleteById(bid);
}


//Borrow a Book with title and author
public Books borrow(paraQuery para) {
Books b=bookRepository.findThisBook(para.getTitle(),para.getFirstName(),para.getSecondName());
if(b!=null) {
	if(b.getAvailableCopy()>0)
	bookRepository.Borrow(b.getId());
	else
		return null;
}
return bookRepository.findThisBook(para.getTitle(),para.getFirstName(),para.getSecondName());
}

//Borrow a Book with title and author
public Books returnBook(paraQuery para) {
Books b=bookRepository.findThisBook(para.getTitle(),para.getFirstName(),para.getSecondName());
if(b!=null) {
	bookRepository.Return(b.getId());
}
return bookRepository.findThisBook(para.getTitle(),para.getFirstName(),para.getSecondName());
}

}
