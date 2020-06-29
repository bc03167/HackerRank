import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FizzBuzz {
    Map<String, Integer> countz = new HashMap<String, Integer>();
    boolean printed;
    String key;
    int sum;

    public static void main(String args[]) {
        FizzBuzz fb = new FizzBuzz();

        System.out.println("Hello TransAmerica!");
        for (int i = 1; i <= 20; i++) {
            fb.printed = false;
            fb.key = "";
            if (fb.handleAppearanceOfDigitThree(i)) {
                ;//exercise wording suggests if-then-else re: appearance handling
            } else {
                fb.checkModulosThree(i);
                fb.checkModulosFive(i);
                fb.checkModulosFifteen(i);
                fb.checkRegularIntegerOutput(i);
            }
            fb.incrementCardinality();

            System.out.print(" ");
        }
        System.out.println("\n" + fb.countz.keySet().toString());
        System.out.println(fb.countz.values().toString());
    }

    public void incrementCardinality() {
        if (this.countz.get(this.key) == null)
            this.sum = 1;
        else
            this.sum = this.countz.get(this.key) + 1;
        this.countz.put(this.key, this.sum);
    }

    public void checkRegularIntegerOutput(int i) {
        if (!this.printed) {
            System.out.print(i);
            this.key += "integer";
        }
    }


    public void checkModulosFifteen(int i) {
        ;//moot?  {3,5} factor set present in ANY  (x % 15) expression
    }

    public void checkModulosFive(int i) {
        if (i % 5 == 0) {
            System.out.print(this.key += "buzz");
            this.printed = true;
        }
    }


    public void checkModulosThree(int i) {
        if (i % 3 == 0) {
            System.out.print(this.key += "fizz");
            this.printed = true;
        }
    }

    public boolean handleAppearanceOfDigitThree(int i) {
        if ((i + " ").indexOf("3") >= 0) {
            System.out.print(this.key += "lucky");
            this.printed = true;
        }
        return this.printed;
    }
}
