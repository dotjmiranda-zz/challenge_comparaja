package com.dotmiranda.booklist.controllers

import com.dotmiranda.booklist.models.Book
import com.dotmiranda.booklist.repositories.BookRepository
import org.apache.coyote.Request
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.util.MultiValueMap
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class BookController {
    @Autowired
    BookRepository bookRepository;

    // Multiple Books

    @GetMapping("/api/getAllBooks")
    List<Book> getAllBooks() {
        return bookRepository.findAll()
    }

    // Single Book

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
        Optional<Book> book = bookRepository.findById(id)
        bookRepository.delete(book.get())
    }
}
