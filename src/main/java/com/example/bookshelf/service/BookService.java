package com.example.bookshelf.service;

import com.example.bookshelf.entity.Book;
import com.example.bookshelf.repository.BookRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {

    private final BookRepository repository;

    public List<Book> getAllBooks() {
        log.info("get All Books");
        return repository.findAll();
    }

    public Book getBookById(Long id) {
        log.info("get Book by id: {}", id);
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public Book saveBook(Book book) {
        log.info("save Book: {}", book);
        return repository.save(book);
    }

    public Book updateBook(Long id, Book newBook) {
        log.info("update Book: {}", newBook);

        Book book = getBookById(id);
        book.setTitle(newBook.getTitle());
        book.setAuthor(newBook.getAuthor());
        book.setYear(newBook.getYear());
        return repository.save(book);
    }

    public void deleteBook(Long id) {
        log.info("delete Book: {}", id);
        repository.deleteById(id);
    }
}