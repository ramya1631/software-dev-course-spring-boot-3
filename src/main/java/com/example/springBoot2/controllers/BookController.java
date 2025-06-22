package com.example.springBoot2.controllers;

import com.example.springBoot2.models.Book;
import com.example.springBoot2.Repositories.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {
        private final BookRepository bookRepository;

        public BookController(BookRepository bookRepository) {
            this.bookRepository = bookRepository;
        }
        //get all the items
        @GetMapping
    public List<Book> getBooks() {
            return bookRepository.findAll();
    }
    //get item by id
    @GetMapping("/{id}")
    public Optional<Book> getItem(@PathVariable int id) {
        return bookRepository.findById(id);
    }
    // post (create) item
    @PostMapping
    public Book addItem(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    // put (update) item
    @PutMapping("/{id}")
    public Book updateItem(@PathVariable int id, @RequestBody Book updatedBook) {
        updatedBook.setId(id);
        return bookRepository.save(updatedBook);
    }

    // delete item
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable int id) {
        bookRepository.deleteById(id);
    }

}
