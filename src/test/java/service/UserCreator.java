package service;

import model.User;

public class UserCreator {
    public static final String USER_NAME = "test.data.username";
    public static final String USER_PASSWORD = "test.data.userpassword";

    public static User userWithCredentials(){
            return new User(TestDataReader.getTestData(USER_NAME),TestDataReader.getTestData(USER_PASSWORD));
    }
}
