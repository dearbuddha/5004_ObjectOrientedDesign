package Lesson2;

public class LectureNotes {

    public static void main(String[] args) {
        String name = "Jacky";
        int x = 1;
        System.out.println(name + x);
//        String s = null;
//        System.out.println(s);
        System.out.println("The length of the string is: " + name.length());
        System.out.println("First character is: " + name.charAt(0));
//        System.out.println("First character is: " + name.charAt(10)); // Out of Bounce Exception

        System.out.println((name.substring(2)));

        String y = "jacky";
        System.out.println(name.equals(y));

        String z = "123123123";
        System.out.println("First occurrence of 123 is: " + z.indexOf("123"));
        System.out.println("Second occurrence of 123 is: " + z.indexOf("123", z.indexOf("123")+1));

        String a = "acat";
        String b = "cap";
        System.out.println(a.compareTo(b));

        String greeting = "he said \\ \"Hi\"";
        System.out.println(greeting);

        double price = 19.9;
        System.out.print("$");
        System.out.printf("%15.2f", price);
        System.out.printf("%6.1f", price);
        System.out.printf(" each");
    }
}
