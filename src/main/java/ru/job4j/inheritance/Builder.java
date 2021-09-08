package ru.job4j.inheritance;

public class Builder extends Engineer {

    private String post;

    public Builder(String name, String surname, String education, String birthday, String workPerformed, String post) {
        super(name, surname, education, birthday, workPerformed);
        this.post = post;
    }

    public String getPost() {
        return post;
    }

}
