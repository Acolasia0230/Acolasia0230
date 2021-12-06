package edu.soft2.entity;

public class Singleton1 {
    /**单例模式，饿汉模式*/
    private static final Singleton1 INSTANCE = new Singleton1();

    public static Singleton1 getInstance() {return INSTANCE;
}}