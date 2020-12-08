package com.dotmiranda.booklist.models

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "book")
class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id")
    private Long id

    @Column(name = "title")
    private String title

    @Column(name = "author")
    private String author

    Book() {}

    Book(long id, String title, String author) {
        this.id = id
        this.title = title
        this.author = author
    }

    Long getId() { return this.id }

    String getTitle() { return this.title }

    String getAuthor() { return this.author }

    void setId(Long id) { this.id = id }

    void setTitle(String title) { this.title = title }

    void setAuthor(String author) { this.author = author }

    @Override
    String toString() {
        return "Book{" + "id=" + this.id
    }
}
