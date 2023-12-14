package org.amazon.model;

import java.util.concurrent.atomic.AtomicLong;

public class User {
    private Long id;
    private String email;
    private String phoneNum;

    AtomicLong atomicLong = new AtomicLong();

    public User(String email, String phoneNum) {
        id = atomicLong.getAndIncrement();
        this.email = email;
        this.phoneNum = phoneNum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }
}
