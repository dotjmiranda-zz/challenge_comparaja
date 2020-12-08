package com.dotmiranda.booklist.controllers

class BookNotFoundException extends RuntimeException {
    BookNotFoundException(long id) {
        super("Could not find the book with the id " + id)
    }
}
