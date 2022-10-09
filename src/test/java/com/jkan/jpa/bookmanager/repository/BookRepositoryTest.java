package com.jkan.jpa.bookmanager.repository;

import com.jkan.jpa.bookmanager.domain.Book;
import com.jkan.jpa.bookmanager.domain.Publisher;
import com.jkan.jpa.bookmanager.domain.Review;
import com.jkan.jpa.bookmanager.domain.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Test
    void bookTest() {
        Book book = new Book();
        book.setName("토비의 스프링");
        book.setAuthorId(1L);
//        book.setPublisherId(1L);

        bookRepository.save(book);

        System.out.println(bookRepository.findAll());

    }

    @Test
    @Transactional
    void bookRelataionTest(){
        givenBookAndReview();

        Users user = userRepository.findByEmail("jkan@naver.com");
        System.out.println("review : " + user.getReviews());
        System.out.println("book : " + user.getReviews().get(0).getBook());
        System.out.println("Publisher : " + user.getReviews().get(0).getBook().getPublisher());


    }

    private void givenBookAndReview() {
        givenReview(givenUser(), givenBook(givenPublisher()));
    }

    private Users givenUser() {
        return userRepository.findByEmail("jkan@naver.com");
    }

    private Book givenBook(Publisher publisher) {
        Book book = new Book();
        book.setName("JPA 초격자 패키지");
        book.setPublisher(publisher);

        return bookRepository.save(book);
    }

    private Publisher givenPublisher(){
        Publisher publisher = new Publisher();
        publisher.setName("패캠");

        return publisherRepository.save(publisher);
    }

    private void givenReview(Users user, Book book) {
        Review review = new Review();
        review.setTitle("인생을 바꾼 책");
        review.setContent("너무나 재밌었어요!");
        review.setScore(5.0f);
        review.setUser(user);
        review.setBook(book);

        reviewRepository.save(review);
    }
}
