//Complete this code or write your own from scratch
import java.util.*;
import java.io.*;

class Day8{
    public static void main(String []arg){
        Map<String,Integer> m = new HashMap<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            String name = in.next();
            int phone = in.nextInt();
            m.put(name, phone);
            // Write code here
        }
        while(in.hasNext()){
            String s = in.next();
            if (m.get(s) != null)
                System.out.println(s+"="+m.get(s));
            else
                System.out.println("Not found");
            // Write code here
        }
        in.close();
    }
}