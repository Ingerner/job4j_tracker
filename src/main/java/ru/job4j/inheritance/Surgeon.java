package ru.job4j.inheritance;

public class Surgeon extends Doctor {
    private String operation;

    public Surgeon(String name, String surname, String education,
                   String birthday, String diagnoz, String operation) {
        super(name, surname, education, birthday, diagnoz);
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }
}
