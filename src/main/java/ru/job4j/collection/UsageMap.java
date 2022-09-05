package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        Map<String, String> users = new HashMap<>();
        users.put("chaos777@mail.ru", "Dmitriy Khodyrev");
        users.put("greenman@mail.ru", "Vladimir Alekseev");
        users.put("123@yandex.ru", "Lubov Shubina");
        for (String key : users.keySet()) {
            System.out.println(key + " = " + users.get(key));
        }
    }
}
