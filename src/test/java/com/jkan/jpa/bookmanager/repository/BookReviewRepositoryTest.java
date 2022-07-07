package com.jkan.jpa.bookmanager.repository;

import com.jkan.jpa.bookmanager.domain.Book;
import com.jkan.jpa.bookmanager.domain.BookReviewInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookReviewRepositoryTest {

    @Autowired
    private BookReviewRepository bookReviewRepository;

    @Autowired
    private BookRepository bookRepository;

    @Test
    void crudTest() {
        BookReviewInfo bookReviewInfo = new BookReviewInfo();
        bookReviewInfo.setBookId(1L);
        bookReviewInfo.setAverageReviewScore(4.5f);
        bookReviewInfo.setReviewCount(2);

        bookReviewRepository.save(bookReviewInfo);

        System.out.println(">>>>>" + bookReviewRepository.findAll());

    }

    @Test
    void crudTest2() {
        Book book = new Book();

        book.setName("jpaStudy");
        book.setAuthorId(1L);
        book.setPublisherId(1L);

        bookRepository.save(book);

        BookReviewInfo bookReviewInfo = new BookReviewInfo();
        bookReviewInfo.setBookId(1L);
        bookReviewInfo.setAverageReviewScore(4.5f);
        bookReviewInfo.setReviewCount(2);

        bookReviewRepository.save(bookReviewInfo);

        System.out.println(">>>" + bookReviewRepository.findAll());

        Book result = bookRepository.findById(
                bookReviewRepository
                        .findById(1L)
                        .orElseThrow(RuntimeException::new)
                        .getBookId()
        ).orElseThrow(RuntimeException::new);

        System.out.println("result : " + result);

    }
}