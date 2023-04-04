package com.amcsoftware.user;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.regex.Pattern;

public class UserArrayDataAccessService extends ExtractUsers implements UserDao{
    String path = "src/main/java/com/amcsoftware/users.csv";

    public static User[] users;

    {
        System.out.println("ran first");
        try {
            users = getUsers(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User[] getUsers(File file) throws FileNotFoundException {
        return usersExtracted(file);
    }

    @Override
    public Pattern getIdPattern() {
        return Pattern.compile("^[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-4{1}[a-fA-F0-9]{3}-[89abAB]{1}[a-fA-F0-9]{3}-[a-fA-F0-9]{12}$");
    }

    @Override
    public Pattern getNamePattern() {
        return Pattern.compile("[a-zA-Z]{2,}");
    }

    @Override
    public Pattern getAgePattern() {
        return Pattern.compile("^\\d*\\.?\\d+$");
    }
}
