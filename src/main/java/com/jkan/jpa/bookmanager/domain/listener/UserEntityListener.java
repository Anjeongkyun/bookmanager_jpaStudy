package com.jkan.jpa.bookmanager.domain.listener;

import com.jkan.jpa.bookmanager.domain.UserHistory;
import com.jkan.jpa.bookmanager.domain.Users;
import com.jkan.jpa.bookmanager.repository.UserHistoryRepository;
import com.jkan.jpa.bookmanager.support.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class UserEntityListener {

    @PostPersist
    @PostUpdate
    public void prePersistAndPreUpdate(Object o){

        UserHistoryRepository userHistoryRepository = BeanUtils.getBean(UserHistoryRepository.class);
        Users user = (Users) o;

        UserHistory userHistory = new UserHistory();
//        userHistory.setUserId(user.getId());
        userHistory.setName(user.getName());
        userHistory.setEmail(user.getEmail());
        userHistory.setUser(user);

        userHistoryRepository.save(userHistory);
    }
}
