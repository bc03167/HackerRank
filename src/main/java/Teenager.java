import java.io.*;
import java.util.*;

public class Teenager {
    private int age;

    public Teenager(int initialAge) {
        if (initialAge < 0) {
            initialAge = 0;
            System.out.println("Age is not valid, setting age to 0.");
        }
        this.age = initialAge;
    }

    public void amIOld() {
        // Write code determining if this person's age is old and print the correct statement:
        if (this.age >= 18)
            System.out.println("You are old.");
        else if (age < 13)
            System.out.println("You are young.");
        else
            System.out.println("You are a teenager.");
    }

    public void yearPasses() {
        this.age++;
        // Increment this person's age.
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int age = sc.nextInt();
            Teenager p = new Teenager(age);
            p.amIOld();
            for (int j = 0; j < 3; j++) {
                p.yearPasses();
            }
            p.amIOld();
            System.out.println();
        }
        sc.close();
    }
}