import ps6.Person;
import ps6.Student;
import ps6.Teacher;

/**
 *  Wenhan Cai
 *  CS 5004 homework 6
 */
public class Test {

    public static void main(String[] args) {
        Student a = new Student("May", "Wang", 123, "Java", "Phil");
        Student b = new Student("John", "Doe", 321, "Algorithm", "Brent");
        Teacher c = new Teacher("Philip", "Gust", "Java", 1000);
        Teacher d = new Teacher("Brent", "Hailpern", "Algorithm", 1000);

        Person[] persons = new Person[4];
        persons[0] = a;
        persons[1] = b;
        persons[2] = c;
        persons[3] = d;

        for(int i = 0; i<persons.length; i++){
            System.out.println(persons[i]);
        }
    }

}