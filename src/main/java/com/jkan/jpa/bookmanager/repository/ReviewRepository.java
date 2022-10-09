package com.jkan.jpa.bookmanager.repository;

import com.jkan.jpa.bookmanager.domain.Book;
import com.jkan.jpa.bookmanager.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
