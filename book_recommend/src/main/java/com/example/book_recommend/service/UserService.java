package com.example.book_recommend.service;

import com.example.book_recommend.dao.UserDAO;
import com.example.book_recommend.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDAO userDAO;

    public boolean isExist(String user_name) {
        User user = getByName(user_name);
        return user != null;
    }

    public User getByName(String userName) {
        return userDAO.findByUserName(userName);
    }

    public User get(String userName, String userPassword) {
        return userDAO.getByUserNameAndUserPassword(userName, userPassword);
    }

    public void add(User user) {
        userDAO.save(user);
    }
}
