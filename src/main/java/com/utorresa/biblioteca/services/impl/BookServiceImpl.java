package com.utorresa.biblioteca.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.utorresa.biblioteca.models.dto.BookRequest;
import com.utorresa.biblioteca.models.dto.BookResponse;
import com.utorresa.biblioteca.models.entities.Book;
import com.utorresa.biblioteca.repositories.BookRepository;
import com.utorresa.biblioteca.services.BookService;
import com.utorresa.exceptions.BookNotFoundExceptions;


import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    @Override
    public List<BookResponse> getAllBooks() {
        
        return bookRepository.findAll().stream()
                .map(this::toBookResponse)
                .toList();
    }

    @Override
    public BookResponse getOne(Long id) {
       return bookRepository.findById(id)
                .map(this::toBookResponse)
                .orElseThrow(() -> new BookNotFoundExceptions("Book not found with id: " + id));
    }

    @Override
    public List<BookResponse> getBooksByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title)
            .stream()
            .map(this::toBookResponse)
            .toList();
    }

    @Override
    public BookResponse create(BookRequest book) {
        var Entity = toEntity(book);
           
        var newBook= bookRepository.save(Entity);
        return toBookResponse(newBook);
        
    }

    @Override
    public BookResponse update(Long id, BookRequest book) {
    var entity = bookRepository.findById(id)
        .orElseThrow(() -> new BookNotFoundExceptions("No se encontró el libro id: " + id));
    var updatedEntity = toEntity(book);
    updatedEntity.setId(entity.getId());
    bookRepository.save(updatedEntity);
    return toBookResponse(updatedEntity);
}

   @Override
    public BookResponse status(Long id, Book.Status status) {
    var entity = bookRepository.findById(id)
        .orElseThrow(() -> new BookNotFoundExceptions("No se encontró el libro id: " + id));
    entity.setStatus(status);
    var updatedEntity = bookRepository.save(entity);
    return toBookResponse(updatedEntity);
}

    @Override
    public void delete(Long id) {
        bookRepository.deleteById(id);
        
    }
    private BookResponse toBookResponse(Book book) {
        BookResponse response = new BookResponse();
        response.setBookId(book.getId());
        response.setTitle(book.getTitle());
        response.setAuthor(book.getAuthor());
        response.setIsbn(book.getIsbn());
        response.setGenre(book.getGenre());
        response.setPublishedDate(book.getPublishedDate());
        response.setStatus(book.getStatus());
        return response;
    }
    
    private Book toEntity(BookRequest book) {
        Book entity = new Book();
        entity.setTitle(book.getTitle());
        entity.setAuthor(book.getAuthor());
        entity.setIsbn(book.getIsbn());
        entity.setGenre(book.getGenre());
        entity.setPublishedDate(book.getPublishedDate());
        entity.setStatus(Book.Status.valueOf(book.getStatus()));
        return entity;
    } 
}

