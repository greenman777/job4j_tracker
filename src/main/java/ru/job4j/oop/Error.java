package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public Error() {
    }
    public static void main(String[] args) {
        Error defaultError = new Error();
        Error newError = new Error(true, 1000, "Error!!!");
        defaultError.printInfo();
        newError.printInfo();
    }

    public void printInfo() {
        System.out.println("Ошибка активна: " + active);
        System.out.println("Статус ошибки: " + status);
        System.out.println("Сообщение: " + message);
    }
}
