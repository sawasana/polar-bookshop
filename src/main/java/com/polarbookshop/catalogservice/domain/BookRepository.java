package com.polarbookshop.catalogservice.domain;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface BookRepository extends CrudRepository<Book, Long> {
    Iterable<Book> findAll();

    Optional<Book> findByIsbn(String isbn);

    boolean existsByIsbn(String isbn);

    // @SuppressWarnings("unchecked")
    // Book save(Book book);

    @Modifying
    @Transactional
    @Query("DELETE from Book WHERE isbn = :isbn")
    void deleteByIsbn(String isbn);

}
