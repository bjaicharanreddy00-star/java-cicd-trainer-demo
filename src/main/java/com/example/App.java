package com.example;

/** A tiny application used to demonstrate a Java CI pipeline. */
public class App {
    public String message() {
        return "Hello, CI/CD!";
    }

    public static void main(String[] args) {
        System.out.println(new App().message());
    }
}
