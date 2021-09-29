package ru.job4j.ex;

public class UserInvalidException extends ElementNotFoundException {
    public UserInvalidException(String mesange) {
        super(mesange);
    }
}
