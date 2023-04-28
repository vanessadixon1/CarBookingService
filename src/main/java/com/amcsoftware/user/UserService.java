package com.amcsoftware.user;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserService {
    private UserArrayDataAccessService userArrayDataAccessService;

    private static final List<User> users = new ArrayList<>();

    public UserService(UserArrayDataAccessService userArrayDataAccessService) {
        this.userArrayDataAccessService = userArrayDataAccessService;

        users.addAll(UserArrayDataAccessService.users);
    }

    public List<User> getUsers() {
       return users;
    }

    public User locateUser(String id) {
        User user = null;

        for (User currentUser : getUsers()) {
            if (currentUser.getId().equals(UUID.fromString(id))) {
                user = currentUser;
            }
        }

        return user;
    }
}
