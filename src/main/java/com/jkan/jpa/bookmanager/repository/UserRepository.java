package com.jkan.jpa.bookmanager.repository;


import com.jkan.jpa.bookmanager.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
