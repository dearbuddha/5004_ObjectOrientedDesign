package ps9;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        System.out.println("Calculator is on.");
        boolean flag = true;

        while(flag){
            double result = 0.0;
            System.out.println("result = " + result);
            String operator = null;
            double operand = 0.0;
            Scanner scanner = new Scanner(System.in);

            while(scanner.hasNext()){

                try{
                    operator = scanner.next();
                    if(!operator.equals("+") && !operator.equals("-") && !operator.equals("*") && !operator.equals("/")
                            && !operator.equals("r") && !operator.equals("R")){
                        throw new UnknownOperatorException();
                    }
                } catch (UnknownOperatorException e){
                    System.err.println(operator + " is an unknown operator\nPlease reenter your last line");
                }
                if(operator.equals("r") || operator.equals("R")) break;

                try {
                    operand = scanner.nextDouble();
                } catch (InputMismatchException e){
                    System.err.println("Invalid number\nPlease reenter your last line");
                    operand = 0;
                }


                if(operator.equals("+")){
                    result += operand;
                    System.out.println("result + " + operand + " = " + result);
                    System.out.println("new result = " + result);
                } else if(operator.equals("-")){
                    result -= operand;
                    System.out.println("result - " + operand + " = " + result);
                    System.out.println("new result = " + result);
                } else if(operator.equals("*")){
                    result *= operand;
                    System.out.println("result * " + operand + " = " + result);
                    System.out.println("new result = " + result);
                } else if(operator.equals("/")){
                    result /= operand;
                    System.out.println("result / " + operand + " = " + result);
                    System.out.println("new result = " + result);
                }
            }
            System.out.println("Final result = " + result);
            System.out.println("Again? (yes/no)");
            scanner.nextLine();
            try {
                String input = scanner.nextLine();
                if(input.equals("no")){
                    break;
                } else if (!input.equals("yes")) throw new InvalidInputException("Please enter yes or no");

            } catch (InvalidInputException e){
                System.err.println("Please enter yes or no");
            }


        }
        System.out.println("End of Program");

    }

}

class UnknownOperatorException extends Exception {
    public UnknownOperatorException(String message) {
        super(message);
    }
    public UnknownOperatorException() {
        super("Unknown Operator");
    }
    public UnknownOperatorException(String message, int code) {
        super(message);
        this.code = code;
    }
    public String getMessage() {
        return super.getMessage() + " -- the code is " + code;
    }
    private int code;
}

class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
    public InvalidInputException() {
        super("Unknown Operator");
    }
    public InvalidInputException(String message, int code) {
        super(message);
        this.code = code;
    }
    public String getMessage() {
        return super.getMessage() + " -- the code is " + code;
    }
    private int code;
}