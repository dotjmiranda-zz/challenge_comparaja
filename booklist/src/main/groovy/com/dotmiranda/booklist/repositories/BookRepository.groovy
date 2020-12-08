package com.dotmiranda.booklist.repositories

import com.dotmiranda.booklist.models.Book
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository extends CrudRepository<Book, Long> {
}
