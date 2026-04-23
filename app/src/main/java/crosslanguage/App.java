package crosslanguage;

import services.java.JavaServiceApp;
import services.kotlin.KotlinServiceApp;
import services.scala.ScalaServiceApp;

public class App {
    public static void main(String[] args) {
        System.out.println("Testing cross-language services:");
        System.out.println(JavaServiceApp.greet());
        System.out.println(KotlinServiceApp.INSTANCE.greet());
        System.out.println(ScalaServiceApp.greet());
    }
}
