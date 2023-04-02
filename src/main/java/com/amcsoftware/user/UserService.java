package com.amcsoftware.user;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.UUID;

public class UserService {
    private final UserArrayDataAccessService userArrayDataAccessService;

    private static User[] users;

    public UserService(String path) {
        this.userArrayDataAccessService = new UserArrayDataAccessService();
        users = new User[5];

        try {
            users = userArrayDataAccessService.getUsers(new File(path));
        } catch (FileNotFoundException e) {
            System.out.println("file doesn't exist");
        }
    }

    public UserService() {
        this.userArrayDataAccessService = new UserArrayDataAccessService();
    }

    public User[] getUsers() {
       return users;
    }

    public User locateUser(String id) {
        User locatedUser = null;
        UUID userId = UUID.fromString(id);
        for (User user : getUsers()) {
            if (user != null && user.getId().equals(userId)) {
                locatedUser = user;
            }
        }
        return locatedUser;
    }

}
