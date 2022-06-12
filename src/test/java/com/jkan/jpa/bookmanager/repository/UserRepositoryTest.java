package com.jkan.jpa.bookmanager.repository;

import com.jkan.jpa.bookmanager.domain.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void crud() {
        userRepository.save(new Users());

        //findAll은 지양한다. 천만건이 있으면 천만건을 다 올려서 out of memory 발생 여지있음.
        System.out.println(userRepository.findAll());
    }
}