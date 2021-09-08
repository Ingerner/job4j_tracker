package ru.job4j.inheritance;

public class Engineer extends Profession {

    private String workPerformed;

    public Engineer(String name, String surname, String education, String birthday, String workPerformed) {
        super(name, surname, education, birthday);
        this.workPerformed = workPerformed;
    }

    public String getWorkPerformed() {
        return workPerformed;
    }

}
