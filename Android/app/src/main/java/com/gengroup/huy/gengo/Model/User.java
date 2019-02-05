package com.gengroup.huy.gengo.Model;

/**
 * Created by
 * Huy on 2/4/2019.
 */

public class User {
    private String account;
    private String avatar;
    private String password;
    private int point;
    private int pointPerWeek;

    public String getAccount(){
        return this.account;
    }

    public String getPassword() {
        return this.password;
    }

    public String getAvatar() {
        return avatar;
    }

    public int getPoint() {
        return point;
    }

    public int getPointPerWeek() {
        return pointPerWeek;
    }

    public User(String account, String avatar, String password, int point, int pointPerWeek) {
        this.account = account;
        this.avatar = avatar;
        this.password = password;
        this.point = point;
        this.pointPerWeek = pointPerWeek;
    }

    public static class UserBuilder{
        private String account = "";
        private String avatar = "";
        private String password = "";
        private int point = 0;
        private int pointPerWeek = 0;

        public UserBuilder(String account , String password){
            this.account = account;
            this.password = password;
        }

        public UserBuilder setAvatar(String avatar){
            this.avatar = avatar;
            return this;
        }

        public UserBuilder setPoint(int point){
            this.point = point;
            return this;
        }

        public UserBuilder setPointPerWeek(int pointPerWeek){
            this.pointPerWeek = pointPerWeek;
            return this;
        }

        public  User build(){
            return new User(account,avatar,password,point,pointPerWeek);
        }
    }
}
