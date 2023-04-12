package com.amcsoftware.user;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract public class UserArrayData {

    public abstract Pattern getIdPattern();
    public abstract Pattern getNamePattern();
    public abstract Pattern getAgePattern();

    private List<User> parse(File file) throws FileNotFoundException {
       List<User> users = new ArrayList<>();

        Scanner scanner = new Scanner(file);

        User addUser;

        while(scanner.hasNext()) {
            String[] user = scanner.nextLine().split(",");

            Matcher id = getIdPattern().matcher(user[0].trim());
            Matcher name = getNamePattern().matcher(user[1].trim());
            Matcher age = getAgePattern().matcher(user[2].trim());

            if(id.matches() && name.matches() && age.matches()) {
                addUser = new User(UUID.fromString(user[0].trim()),user[1].trim(), Integer.parseInt(user[2].trim()));
                users.add(addUser);
            }
        }

        scanner.close();

        return users;
    }

    public List<User> usersExtracted(File file ) throws FileNotFoundException {
        return parse(file);
    }

}
