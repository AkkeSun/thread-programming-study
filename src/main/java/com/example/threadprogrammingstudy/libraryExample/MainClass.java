package com.example.threadprogrammingstudy.libraryExample;

public class MainClass {

    public static void main(String[] args) {
        System.out.println("====== 도서관 오픈 =====");

        Library library = new Library();
        try {
            Student student1 = new Student(library);
            Student student2 = new Student(library);
            Student student3 = new Student(library);
            Student student4 = new Student(library);
            Student student5 = new Student(library);
            Student student6 = new Student(library);
            Student student7 = new Student(library);
            Student student8 = new Student(library);
            Student student9 = new Student(library);

            student1.start();
            student2.start();
            student3.start();
            student4.start();
            student5.start();
            student6.start();
            student7.start();
            student8.start();
            student9.start();

            student1.join();
            student2.join();
            student3.join();
            student4.join();
            student5.join();
            student6.join();
            student7.join();
            student8.join();
            student9.join();

        } catch (Exception ignored) {
        }

        System.out.println("====== 도서관 종료 =====");


    }

}
