package ru.job4j.pojo;

import java.time.LocalDate;
import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Дмитрий Борисович Ходырев");
        student.setGroup("Информационные технологии");
        student.setReceiptDate(LocalDate.now());
        System.out.println(student.getFullName() + " зачислен в группу: " + student.getGroup() + ". Дата зачисления: " + student.getReceiptDate());
    }
}
