package ru.job4j.inheritance;

public class Programmer extends Engineer {

    private String programmingLanguage;

    public Programmer(String name, String surname, String education,
                      String birthday, String workPerformed, String programmingLanguage) {
        super(name, surname, education, birthday, workPerformed);
        this.programmingLanguage = programmingLanguage;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }
}
