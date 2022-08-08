package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Adventures");
        Book book2 = new Book("Fantasy");
        Book book3 = new Book("Clean code");
        Book book4 = new Book("Horror");
        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        System.out.println("Список книг:");
        for (int i = 0; i < books.length; i++) {
            System.out.println("Книга: " + books[i].getName());
        }
        Book temp = books[3];
        books[3] = books[0];
        books[0] = temp;
        System.out.println("Список книг после замены:");
        for (Book book : books) {
            System.out.println("Книга: " + book.getName());
        }
        System.out.println("Список найденных книг:");
        for (Book book : books) {
            if ("Clean code".equals(book.getName())) {
                System.out.println("Книга: " + book.getName());
            }
        }
    }
}
