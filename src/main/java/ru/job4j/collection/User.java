package ru.job4j.collection;

import java.util.Objects;

public class User implements Comparable<User> {
    private String name;
    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(User user) {
        int rez = this.name.compareTo(user.name);
            if (rez == 0) {
                rez = this.age.compareTo(user.age);
            }
        return rez;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

}
