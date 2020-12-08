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
    public Long id

    @Column(name = "title")
    public String title

    @Column(name = "author")
    public String author

    Book() {}

    Book(long id, String title, String author) {
        this.id = id
        this.title = title
        this.author = author
    }

    @Override
    String toString() {
        StringBuilder builder = new StringBuilder()

        builder.append(String.valueOf(id))
        builder.append(", ")
        builder.append(title)
        builder.append(", ")
        builder.append(author)

        return builder.toString()
    }
}
