package ru.job4j.tracker;

public class UserStore {
    public static void main(String[] args) {
        User user = new User(1, "root", "root");
       /* System.out.println("User: "
                + user.getId() + " "
                + user.getUsername() + " "
                + user.getPassword()
        );*/
        System.out.println(user.toString());
    }
}
