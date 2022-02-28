package com.magd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.print("Enter number of new Students to enroll: ");
        Scanner scanner = new Scanner(System.in);
        int numOfStudents = scanner.nextInt();
        List<Student> students = new ArrayList<>(numOfStudents);

        for (int i = 0; i < numOfStudents; i++) {
            Student student = new Student();
            student.enroll();
            student.payTuition();
            students.add(student);
        }
        students.forEach(Student::showInfo);
    }
}
