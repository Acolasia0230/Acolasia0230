package edu.soft2.entity;

public class Singleton2 {
    private static Singleton2 INSTANCE = null;
    public static Singleton2 getInstance(){
        if (INSTANCE== null) {
            INSTANCE = new Singleton2();
        }
        return INSTANCE;
    }
}