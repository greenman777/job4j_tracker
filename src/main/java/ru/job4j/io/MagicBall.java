package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        String question = input.nextLine();
        while (!"Выход".equals(question)) {
            int answer = new Random().nextInt(3);
            String answerText = switch (answer) {
                case 0 -> "Да";
                case 1 -> "Нет";
                default -> "Может быть";
            };
            System.out.println(answerText);
            System.out.print("Задай ещё вопрос или введи \"Выход\" ");
            question = input.nextLine();
        }
    }
}
