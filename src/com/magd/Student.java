package com.magd;

import java.util.Objects;
import java.util.Scanner;

public class Student {

    private String studentId;
    private final String firstName;
    private final String lastName;
    private final int gradeYear;
    private String courses = "";
    private int tuitionBalance = 0;
    private static final int costOfCourse = 600;
    private static int preId = 1000;

    // Constructor: prompt user to enter student's name and year
    public Student() {

        Scanner in = new Scanner(System.in);
        System.out.print("Enter student first name: ");
        this.firstName = in.nextLine();
        System.out.print("Enter student last name: ");
        this.lastName = in.nextLine();
        System.out.print("""
                Students levels is:\s
                1 - Freshman
                2 - Sophomore
                3 - Junior
                4 - Senior
                Enter student class level (1 or 2 or 3 or 4): \040
                """);
        int level = in.nextInt();
        while (!(level < 5 && level > 0)){
            System.out.println("gradeYear is not true, enter again: ");
            level = in.nextInt();
        }
        this.gradeYear = level;

        setStudentId();
        System.out.println(firstName + " " + lastName + " " + gradeYear + " " + studentId);
    }

    private void setStudentId() {
        preId++;
        this.studentId = gradeYear + "" + preId;
    }

    public void enroll() {
        while (true) {
            System.out.print("Enter course to enroll (Q to quit): ");
            Scanner scanner = new Scanner(System.in);
            String course = scanner.nextLine();
            if (!Objects.equals(course, "Q")) {
                courses = courses + "\n" + course;
                tuitionBalance = tuitionBalance + costOfCourse;
            } else break;
            System.out.print("Enrolled in: " + courses+"\n");
            System.out.print("Tuition balance: " + tuitionBalance+"\n");
        }
    }

    // View balance
    public void viewBalance() {
        System.out.print("Now your balance is: $" + tuitionBalance+"\n");
    }

    // Pay Tuition
    public void payTuition() {
        viewBalance();
        System.out.print("Enter your payment: $");
        Scanner scanner = new Scanner(System.in);
        int payment = scanner.nextInt();
        System.out.println("Thanks for your payment of $" + payment);
        tuitionBalance = payment - tuitionBalance;
        viewBalance();
    }

    // Show status
    public void showInfo() {
        System.out.println(
                "===========================================================\n"+
                "Name: " + firstName + " " + lastName + "\n" +
                        "Courses Enrolled:" + courses + "\n" +
                        "Balance: $" + tuitionBalance
        );
    }
}
