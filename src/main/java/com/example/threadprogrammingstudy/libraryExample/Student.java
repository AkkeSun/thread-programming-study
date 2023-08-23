package com.example.threadprogrammingstudy.libraryExample;

public class Student extends Thread {

    private final Library library;

    public Student(Library library) {
        this.library = library;
    }

    @Override
    public void run() {
      if(library.studyStart()){
          try {
              sleep(5000);
              library.studyEnd();
          } catch (InterruptedException e) {
              throw new RuntimeException(e);
          }
      }
    }
}
