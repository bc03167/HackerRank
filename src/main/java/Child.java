import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Stream;

class Parent {
    protected static int count = 0;
    public Parent() {
        count++;
    }
    static int getCount() {
        return count;
    }
}

class Child extends Parent {
    void display() {
        System.out.println("data ="+data);
    }
    int data;
    public Child() {
        count++;
    }
    public static void main(String args[]) {
        Set<String> s = new LinkedHashSet<>();
        s.add("3");
        s.add("1");
        s.add("3");
        s.add("2");
        s.add("3");
        s.add("1");

        s.forEach(st->System.out.print(st+"-"));
        //Character c = new Character("C");
        Double dd = new Double("2.2d");
        Boolean b = new Boolean(false);
        Float f = new Float(23.43);
        int x = 0;
        Child c = new Child();
        c.display();
        //boolean b = false;
        //System.out.println((b = true) ? "true" : "false///");
        Double d = null;
        System.out.println((d instanceof Double) ? "true" : "false");
        System.out.println(getCount());
        System.out.println(Stream.of("green","yellow","blue")
            .max((s1,s2)->s1.compareTo(s2))
                .filter(ss->ss.endsWith("n"))
                .orElse("yellow")
        );

        Child o = new Child();
        System.out.println(getCount());
    }
}