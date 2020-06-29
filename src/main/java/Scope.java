import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


class Difference {
    private int[] elements;
    public int maximumDifference;

    public Difference(int[] a) {
        this.elements= a;
        this.maximumDifference = 0;
    }

    public void computeDifference() {
        for (int i=0; i < this.elements.length; i++) {
            for (int j = i+1; j <this.elements.length;j++) {
                int curDiff = Math.abs(elements[i]-elements[j]);
                if (curDiff > this.maximumDifference)
                    this.maximumDifference = curDiff;
            }
        }
    }

    // Add your code here

} // End of Difference class

public class Scope {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        Difference difference = new Difference(a);

        difference.computeDifference();

        System.out.print(difference.maximumDifference);
    }
}