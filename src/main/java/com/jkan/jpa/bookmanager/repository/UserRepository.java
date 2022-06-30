package com.jkan.jpa.bookmanager.repository;


import com.jkan.jpa.bookmanager.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, Long> {

    List<Users> findByName(String name);
}
