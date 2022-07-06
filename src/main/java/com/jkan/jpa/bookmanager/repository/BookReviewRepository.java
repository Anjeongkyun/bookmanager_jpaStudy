package com.jkan.jpa.bookmanager.repository;

import com.jkan.jpa.bookmanager.domain.BookReviewInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookReviewRepository extends JpaRepository<BookReviewInfo, Long> {
}
