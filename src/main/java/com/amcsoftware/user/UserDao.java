package com.amcsoftware.user;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public interface UserDao {
    List<User> getUsers(File file) throws FileNotFoundException;
}
