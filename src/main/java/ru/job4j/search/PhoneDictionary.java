package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private final ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     *
     * @param key Ключ поиска.
     * @return Список пользователей, которые прошли проверку.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> combineName = (p) -> p.getName().contains(key);
        Predicate<Person> combineSurname = (p) -> p.getSurname().contains(key);
        Predicate<Person> combinePhone = (p) -> p.getPhone().contains(key);
        Predicate<Person> combineAddress = (p) -> p.getAddress().contains(key);
        var combine = combineName.or(combineSurname).or(combinePhone).or(combineAddress);
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}