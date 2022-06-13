package com.jkan.jpa.bookmanager.repository;

import com.jkan.jpa.bookmanager.domain.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void crud() {
        List<Users> users = userRepository.findAll(Sort.by(Sort.Direction.DESC,"name"));
        users.forEach(System.out::println);
//
//        userRepository.save(new Users());
//
//        //findAll은 지양한다. 천만건이 있으면 천만건을 다 올려서 out of memory 발생 여지있음.
//        userRepository.findAll().forEach(System.out::println);
    }
}