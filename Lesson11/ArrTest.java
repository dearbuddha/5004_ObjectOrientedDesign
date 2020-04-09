package Lesson11;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;
        ArrayList<String> names = new ArrayList<>(200);
        while(!flag){
            System.out.println("Please enter a name (to end enter End): ");
            try{
                String name = scanner.nextLine();
                if(name.equals("END")){
                    flag =true;
                }else{
                    names.add(name);
                }
            } catch (Exception e){
                System.err.println("Error in input --" + e.getMessage());
                System.exit(1);
            }
        }
        System.out.println(names.get(2));
        names.add(20,"test");
        System.out.println(names.size());

        for(String s : names){
            System.out.println(s);
        }

        ArrayList<String> copy = new ArrayList<>(1);
        copy.addAll(names);

    }
}
