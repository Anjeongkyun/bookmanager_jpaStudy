package com.jkan.jpa.bookmanager.repository;

import com.jkan.jpa.bookmanager.domain.Users;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void crud() {
        Users user1 = new Users("jack", "jkck@naver.com");
        Users user2 = new Users("jack2", "jkck2@naver.com");

        userRepository.saveAll(Lists.newArrayList(user1, user2));

        List<Users> users = userRepository.findAll();

        users.forEach(System.out::println);


    }
}