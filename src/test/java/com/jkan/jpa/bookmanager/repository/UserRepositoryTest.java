package com.jkan.jpa.bookmanager.repository;

import com.jkan.jpa.bookmanager.domain.Gender;
import com.jkan.jpa.bookmanager.domain.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

    @SpringBootTest
    class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserHistoryRepository userHistoryRepository;
    @Test
    void crud() {
        userRepository.save(new Users("jeongkyun", "dkswjdrbs12@naver.com"));

        Users user = userRepository.findById(1L).orElseThrow(RuntimeException::new);

        user.setEmail("anwjdrbs123@gmail.com");

        userRepository.save(user);
    }

    @Test
    void select() {
        System.out.println("findByIdIsNotNull" + userRepository.findByIdIsNotNull());
        System.out.println("findByAddressIsNotEmpty" + userRepository.findByAddressIsNotEmpty());

    }
    @Test
    void enumTest(){
        Users user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setGender(Gender.MALE);

        userRepository.save(user);

        userRepository.findAll().forEach(System.out::println);

        System.out.println(userRepository.findRowRecord().get("gender"));

    }
    @Test
    void userHistoryTest() {
        Users user = new Users();
        user.setEmail("jkan@naver.com");
        user.setName("jkan");

        userRepository.save(user);

        user.setName("jkan-new");

        userRepository.save(user);
        userHistoryRepository.findAll().forEach(System.out::println);

    }
}