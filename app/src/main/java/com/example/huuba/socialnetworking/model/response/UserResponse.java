package com.example.huuba.socialnetworking.model.response;

import java.sql.Date;

public class UserResponse {
    private int statusCode;
    private String msg;
    private DataUser data;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataUser getData() {
        return data;
    }

    public void setData(DataUser data) {
        this.data = data;
    }

    public static final class DataUser{
        private Integer id;
        private String  username;
        private String  password;
        private String  email;
        private String  avatar;
        private Date birthday;
        private String  token;
        private String  city;
        private String  job;
        private Boolean sex;

        public DataUser(Integer id, String username, String password, String email, String avatar, Date birthday, String token, String city, String job, Boolean sex) {
            this.id = id;
            this.username = username;
            this.password = password;
            this.email = email;
            this.avatar = avatar;
            this.birthday = birthday;
            this.token = token;
            this.city = city;
            this.job = job;
            this.sex = sex;
        }

        public DataUser() {
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public Date getBirthday() {
            return birthday;
        }

        public void setBirthday(Date birthday) {
            this.birthday = birthday;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getJob() {
            return job;
        }

        public void setJob(String job) {
            this.job = job;
        }

        public Boolean getSex() {
            return sex;
        }

        public void setSex(Boolean sex) {
            this.sex = sex;
        }

 }





}
