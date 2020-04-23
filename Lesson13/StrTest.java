package Lesson13;

public class StrTest {
    public static void main(String[] args) {
        String s = "my string1"; // this is stored in the String Pool
        String t = new String("my string2"); // this is stored in the heap
        String u = "my string1";
        String v = new String("my string2");


        // interning
        // String z = w.intern();

        System.out.println("comparing s and u using == " + (s == u));
        System.out.println("comparing s and u using equals " + s.equals(u));
        System.out.println("comparing t and v using == " + (t == v));
        System.out.println("comparing t and v using equals " + t.equals(v));

        // matches(), replaceAll(),
        String test = "+123-456-8900";
        System.out.println("\\d{3}-\\d{3}-\\d{4}");
        System.out.println(test.matches("\\+?\\d{3}-\\d{3}-\\d{4}"));

        String text = "I go to school  . I think, therefor I am .";
        String text2 = text.replaceAll("(\\s+)([\\.,;])", "$2");
        System.out.println(text2);

        String list = "23434, 34343434,34343";
        String[] spt = list.split(",s*");
        for (String ss : spt) {
            System.out.println(ss);
        }
    }
}
