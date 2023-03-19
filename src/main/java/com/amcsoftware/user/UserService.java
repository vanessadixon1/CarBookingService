package com.amcsoftware.user;

import java.util.UUID;

public class UserService {

    private UserDao userDao;

    public UserService() {
        this.userDao = new UserDao();
    }

    public static User[] getUsers() {
        return UserDao.getUsers();
    }

    public User locateUser(String id) {
        User user = null;
        User[] userArr = UserService.getUsers();
        UUID userId = UUID.fromString(id);
        for(int i = 0; i < userArr.length ; i++) {
            if(userArr[i] != null && userArr[i].getId().equals(userId)) {
                user = userArr[i];
            }
        }
        return user;
    }

}
