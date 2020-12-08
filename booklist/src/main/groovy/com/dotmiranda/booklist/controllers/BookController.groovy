package com.dotmiranda.booklist.controllers

import com.dotmiranda.booklist.models.Book
import com.dotmiranda.booklist.repositories.BookRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class BookController {
    @Autowired
    BookRepository bookRepository;

    @GetMapping("/api/getAllBooks")
    List<Book> getAllBooks() {
        return bookRepository.findAll()
    }

    @GetMapping("/api/getBook/{id}")
    Book getBookById(@PathVariable(value="id") long id) {
        return bookRepository.findById(id)
    }

    @PostMapping("/api/addBook")
    Book addBook(@RequestBody Book book) {
        return bookRepository.save(book)
    }

    @DeleteMapping("/api/removeBook/{id}")
    void removeBook(@PathVariable(value="id") long id) {
        Book book = bookRepository.findById(id)
        bookRepository.delete(book)
    }
}
