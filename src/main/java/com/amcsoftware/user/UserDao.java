package com.amcsoftware.user;

import java.util.UUID;

public class UserDao {
    private static final User[] users;

    static {
        users = new User[] {
                new User(UUID.fromString("b47f7fd7-f0a8-4ff5-b67d-b767189fa6ff"), "Kenny"),
                new User(UUID.fromString("5cd6efbc-38b7-4696-bc5d-f1674c9ba8eb"), "Kattie"),
                new User(UUID.fromString("69afb058-952e-4777-b85f-9937bd179c10"), "Marcy"),
                new User(UUID.fromString("17ffe8d2-870a-4e57-9070-90bf3260dce9"), "Patrick"),
                new User(UUID.fromString("adfa2477-74cc-49f2-a6fa-34c164f881b8"), "David")
        };
    }

    public static User[] getUsers() {
        return users;
    }

}
