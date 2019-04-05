import java.io.IOException;
public class Arcane1 {
public static void main(String[] args) {
try {
System.out.println("Hello world");
throw new IOException();
} catch (IOException e) {
System.out.println("I’ve never seen println fail!");
}
}
}
