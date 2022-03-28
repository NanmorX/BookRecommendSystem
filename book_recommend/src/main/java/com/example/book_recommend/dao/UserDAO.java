package com.example.book_recommend.dao;

import com.example.book_recommend.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;

//@Mapper
public interface UserDAO extends JpaRepository<User, Integer> {
    User findByUserName(String userName);

    User getByUserNameAndUserPassword(String userName, String userPassword);
}
