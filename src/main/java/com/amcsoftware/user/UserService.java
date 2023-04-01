package com.amcsoftware.user;

import java.util.UUID;

public class UserService {

    private UserArrayDataAccessService userArrayDataAccessService;

    public UserService() {
        this.userArrayDataAccessService = new UserArrayDataAccessService();
    }

    public User[] getUsers() {
        return userArrayDataAccessService.getUsers();
    }

    public User locateUser(String id) {
        User locatedUser = null;
        User[] userArr = userArrayDataAccessService.getUsers();
        UUID userId = UUID.fromString(id);
        for (User user : userArr) {
            if (user != null && user.getId().equals(userId)) {
                locatedUser = user;
            }
        }
        return locatedUser;
    }

}
