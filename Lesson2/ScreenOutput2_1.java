import java.text.DecimalFormat;

public class ScreenOutput2_1 {

    public static void main(String[] args) {
        String aString = "abc";
        System.out.printf("String output: ");
        System.out.printf("START%2sEND %n", aString);
        System.out.printf("START%6sEND %n", aString);

        double d = 1234.123456789;
        System.out.printf("Floating-point output: %n");
        System.out.printf("START%eEND %n", d);
        System.out.printf("START%gEND %n", d);
        System.out.printf("START%6fEND %n", d); // output is rounded, not truncated

        DecimalFormat formattingObject = new DecimalFormat("000.0000");
        String numeral = formattingObject.format(12.3456789);
        System.out.println(numeral);
    }
}
