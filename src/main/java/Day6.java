
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Day6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < T; i++) {
            String s = sc.nextLine();
            String odd = "";
            String even = "";
            for (int ii = 0; ii < s.length(); ii++)
                if (ii % 2 == 0)
                    even += s.substring(ii,ii+1);
                else
                    odd += s.substring(ii,ii+1);
            System.out.println(even +" "+odd);
        }
        sc.close();
    }


}
