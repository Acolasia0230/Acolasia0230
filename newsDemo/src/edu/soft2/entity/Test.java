package edu.soft2.entity;

public class Test {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {

            System.out.println("饿汉" + (i + 1) +
                    Singleton1.getInstance());
        }

        for (int i = 0; i < 5; i++) {
            System.out.println("懒汉"+(i+1)+
                    Singleton2.getInstance()
            );
        }
    }
}

