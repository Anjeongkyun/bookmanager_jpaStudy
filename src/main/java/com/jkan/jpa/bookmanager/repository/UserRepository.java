package com.jkan.jpa.bookmanager.repository;


import com.jkan.jpa.bookmanager.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<Users, Long> {

    List<Users> findByName(String name);

    Users findByEmail(String email);

    Users getByEmail(String email);

    Users readByEmail(String email);

    Users queryByEmail(String email);

    Users searchByEmail(String email);

    Users streamByEmail(String email);

    Users findUserByEmail(String email);

    List<Users> findTop1ByName(String name);
    List<Users> findFirst1ByName(String name);

    List<Users> findByEmailAndName(String email, String name);
}
