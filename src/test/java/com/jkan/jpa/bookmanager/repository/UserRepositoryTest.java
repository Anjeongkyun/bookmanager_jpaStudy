package com.jkan.jpa.bookmanager.repository;

import com.jkan.jpa.bookmanager.domain.Users;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;


    @SpringBootTest
    class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void crud() {
        userRepository.save(new Users("jeongkyun", "dkswjdrbs12@naver.com"));

        Users user = userRepository.findById(1L).orElseThrow(RuntimeException::new);

        user.setEmail("anwjdrbs123@gmail.com");

        userRepository.save(user);
    }

    @Test
    void select() {
//        System.out.println(userRepository.findByName("jkan"));
//        System.out.println("findByEmail : " + userRepository.findByEmail("shkim@naver.com"));
//        System.out.println("getByEmail : " + userRepository.getByEmail("shkim@naver.com"));
//        System.out.println("readByEmail : " + userRepository.readByEmail("shkim@naver.com"));
//        System.out.println("queryByEmail : " + userRepository.queryByEmail("shkim@naver.com"));
//        System.out.println("searchByEmail : " + userRepository.searchByEmail("shkim@naver.com"));
//        System.out.println("streamByEmail : " + userRepository.streamByEmail("shkim@naver.com"));
//        System.out.println("findUserByEmail : " + userRepository.findUserByEmail("shkim@naver.com"));
//
//        System.out.println("findTop1ByName : " + userRepository.findTop1ByName("jkan"));
//        System.out.println("findFirst1ByName : " + userRepository.findFirst1ByName("jkan"));

//        System.out.println("findByEmailAndName" + userRepository.findByEmailAndName("jkan@naver.com","jkan"));

        System.out.println("findByCreatedAtAfter" + userRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1L)));

        System.out.println("findByIdAfter" + userRepository.findByIdAfter(4L));
        System.out.println("findByCreatedAtGreaterThanAnd" + userRepository.findByCreatedAtGreaterThan(LocalDateTime.now().minusDays(1L)));
        System.out.println("findByCreatedAtGreaterThanEqual" + userRepository.findByCreatedAtGreaterThanEqual(LocalDateTime.now().minusDays(1L)));

    }
}