package com.utorresa.biblioteca.services;

import java.util.List;

import com.utorresa.biblioteca.models.dto.BookRequest;
import com.utorresa.biblioteca.models.dto.BookResponse;
import com.utorresa.biblioteca.models.entities.Book;

public interface BookService {
    List<BookResponse> getAllBooks();
    BookResponse getOne(Long id);
    List<BookResponse> getBooksByTitle(String title);     
    BookResponse create (BookRequest book);
    BookResponse update (Long id, BookRequest book);    
    BookResponse status(Long id, Book.Status status);
    void delete (Long id);              
    
}
