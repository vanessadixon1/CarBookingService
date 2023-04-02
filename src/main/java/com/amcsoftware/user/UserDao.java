package com.amcsoftware.user;

import java.io.File;
import java.io.FileNotFoundException;

public interface UserDao {
    User[] getUsers(File file) throws FileNotFoundException;
}
