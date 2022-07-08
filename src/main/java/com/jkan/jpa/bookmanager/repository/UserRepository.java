package com.jkan.jpa.bookmanager.repository;


import com.jkan.jpa.bookmanager.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

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

    List<Users> findByCreatedAtAfter(LocalDateTime yesterday);

    List<Users> findByIdAfter(Long id);

    List<Users> findByCreatedAtGreaterThan(LocalDateTime yesterday);

    List<Users> findByCreatedAtGreaterThanEqual(LocalDateTime yesterday);

    List<Users> findByIdIsNotNull();

//    List<Users> findByAddressIsNotEmpty();

    @Query(value = "select * from users limit 1;", nativeQuery = true)
    Map<String, Object> findRowRecord();
}
