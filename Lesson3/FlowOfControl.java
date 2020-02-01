package Lesson3;

public class FlowOfControl {
    public static void main(String[] args) {
        String s = new String("hey");
        String t = new String("hey");

        String a = "wow";
        String b = "wow";

        System.out.println(a==b); // in this case, java wants to save memory and make the two variables share the same reference
        System.out.println(s==t); // different references, and compare them. less preferred
        System.out.println(s.equals(t)); //compare value
    }
}
