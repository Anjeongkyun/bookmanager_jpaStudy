package com.jkan.jpa.bookmanager.repository;

import com.jkan.jpa.bookmanager.domain.Publisher;
import com.jkan.jpa.bookmanager.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
