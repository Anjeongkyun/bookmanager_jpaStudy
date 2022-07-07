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
//        BookReviewInfo bookReviewInfo = new BookReviewInfo();
//        bookReviewInfo.setBookId(1L);
//        bookReviewInfo.setAverageReviewScore(4.5f);
//        bookReviewInfo.setReviewCount(2);
//
//        bookReviewRepository.save(bookReviewInfo);
//
//        System.out.println(">>>>>" + bookReviewRepository.findAll());

    }

    @Test
    void crudTest2() {
        givenBookReviewInfo();

        Book result =
                bookReviewRepository
                        .findById(1L)
                        .orElseThrow(RuntimeException::new)
                        .getBook();

        System.out.println("result : " + result);

        BookReviewInfo result2 = bookRepository
                .findById(1L)
                .orElseThrow(RuntimeException::new)
                .getBookReviewInfo();

        System.out.println("result2 : " + result2);

    }

    private Book givenBook() {
        Book book = new Book();

        book.setName("jpaStudy");
        book.setAuthorId(1L);
        book.setPublisherId(1L);

        return bookRepository.save(book);
    }

    private void givenBookReviewInfo() {
        BookReviewInfo bookReviewInfo = new BookReviewInfo();
        bookReviewInfo.setBook(givenBook());
        bookReviewInfo.setAverageReviewScore(4.5f);
        bookReviewInfo.setReviewCount(2);

        bookReviewRepository.save(bookReviewInfo);

        System.out.println(">>>" + bookReviewRepository.findAll());
    }
}