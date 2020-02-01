package Lesson3;

public class Array {
    public static void main(String[] args) {
        int[] grades = new int[5];

        for(int i = 0; i < grades.length; i++ ){
            grades[i] = i;
        }

        int[] scores = new int[grades.length];
        for ( int i = 0; i < scores.length; i++){
            scores[i] = grades[i];
        }

        for(int i = 0; i < grades.length; i++){
            System.out.println("Element " + i + " of the array equals " + grades[i]);
        }
    }
}
