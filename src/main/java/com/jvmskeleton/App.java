package com.jvmskeleton;

import com.service.java.JavaServiceApp;
import com.service.kotlin.KotlinServiceApp;
import com.service.scala.ScalaServiceApp;

public class App {
    public static void main(String[] args) {
        System.out.println("Testing cross-language services:");
        System.out.println(JavaServiceApp.greet());
        System.out.println(KotlinServiceApp.INSTANCE.greet());
        System.out.println(ScalaServiceApp.greet());
    }
}