package ru.job4j.pojo;

import java.util.Date;

public class College {

    public static void main(String[] args) {

        Student student = new Student();
        student.setLastName("Oleg");
        student.setFirstName("Korotkiy");
        student.setPatronymic("Urevich");
        student.setGroup("11");
        student.setDateOfReceipt(new Date());
        System.out.println("ФИО:" + student.getLastName() +" " + student.getFirstName() +" " + student.getPatronymic());
        System.out.println("Группа-" + student.getGroup());
        System.out.println("Дата поступления" + student.getDateOfReceipt());
    }
}
