package ru.job4j.inheritance;

public class Dentist extends Doctor{

    private String patient;

    public Dentist(String name, String surname, String education, String birthday, String diagnoz, String patient) {
        super(name, surname, education, birthday, diagnoz);
        this.patient = patient;
    }

    public String getPatient() {
        return patient;
    }
}
