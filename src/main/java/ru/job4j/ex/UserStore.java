package ru.job4j.ex;

import java.util.Arrays;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User result = null;
        for (User user : users) {
            if (user.getUsername().equals(login)) {
                result = user;
                break;
            }
        }
        if (result == null) {
            throw new UserNotFoundException("User is not found");
        }
        return result;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("User is not validate");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true),
                new User("Dmitriy Khodyrev", false),
        };
        String[] searchUsers = {"Petr Arsentev", "Dmitriy Khodyrev", "Vladimir Ivanov"};
        User user;
        for (String fullName: searchUsers) {
            try {
                user = findUser(users, fullName);
                if (validate(user)) {
                    System.out.println("This user has an access");
                }
            } catch (UserInvalidException e) {
                System.out.println("User is not found");
            } catch (UserNotFoundException e) {
                System.out.println("User is not validate");
            }
        }
    }
}