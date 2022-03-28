package com.example.book_recommend.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

@Entity
@Table(name = "user")
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    int userId;
    String userName;
    String userPassword;

    public int getId() {
        return userId;
    }

    public void setId(int user_id) {
        this.userId = user_id;
    }

    public String getUsername() {
        return userName;
    }

    public void setUsername(String user_name) {
        this.userName = user_name;
    }

    public String getPassword() {
        return userPassword;
    }

    public void setPassword(String user_password) {
        this.userPassword = user_password;
    }
}
