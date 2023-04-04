package com.amcsoftware.user;

import java.util.UUID;

public class UserService {
    private UserArrayDataAccessService userArrayDataAccessService;

    private static final User[] users = new User[5];

    public UserService(UserArrayDataAccessService userArrayDataAccessService) {
        this.userArrayDataAccessService = userArrayDataAccessService;

        for(int i = 0; i < users.length; i++) {
            users[i] = UserArrayDataAccessService.users[i];
        }
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
