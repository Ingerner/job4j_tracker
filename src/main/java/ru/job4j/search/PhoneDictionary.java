package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> combineName = s -> s.getName().contains(key);
        Predicate<Person> combineSurname = s -> s.getSurname().contains(key);
        Predicate<Person> combinePhone = s -> s.getPhone().contains(key);
        Predicate<Person> combineAdress = s -> s.getAdress().contains(key);
        Predicate<Person> combine = combineName
                                    .or(combineSurname)
                                    .or(combinePhone)
                                    .or(combineAdress);
        ArrayList<Person> result = new ArrayList<>();
        for (Person value : persons) {
            if (combine.test(value)) {
                result.add(value);
            }
        }
        return result;
    }
}
