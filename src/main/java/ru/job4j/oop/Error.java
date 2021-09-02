package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {

    }

    public Error(boolean active, int status, String message) {
        this.active = active ;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Активна: " + active);
        System.out.println("Cтатус: " + status);
        System.out.println("Сообщение: " + message);
    }

    public static void main(String[] args) {
        Error comp = new Error();
        comp.printInfo();
        Error printer = new Error(true, 400, "К работе готов");
        printer.printInfo();
        Error Computer  = new Error(true, 200, "Hello");
        printer.printInfo();
    }
}
