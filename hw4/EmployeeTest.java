package hw4;

/**
 *  Wenhan Cai
 *  CS 5004 homework 4-1
 */
class Employee {
    String firstName;
    String lastName;
    double monthSalary;

    public Employee(String firstName, String lastName, double salary){
        this.firstName = firstName;
        this.lastName = lastName;
        setMonthSalary(salary);
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public void setMonthSalary(double salary){
        if(salary<0) this.monthSalary = 0;
        this.monthSalary = salary;
    }

    public double getMonthSalary(){
        return this.monthSalary;
    }
}

public class EmployeeTest {

    public static void main(String[] args) {
        Employee employee1, employee2;
        employee1 = new Employee("John", "Doe", 1000);
        employee2 = new Employee("Jane", "Smith", 2000);
        double yearSalary1 = employee1.monthSalary * 12;
        double yearSalary2 = employee2.monthSalary * 12;
        System.out.println("Employee1's yearly salary is: " + yearSalary1);
        System.out.println("Employee2's yearly salary is: " + yearSalary2);
        double newYearSalary1 = yearSalary1 * 1.1;
        double newYearSalary2 = yearSalary2 * 1.1;
        System.out.printf("Employee1's yearly salary after raise is: %.1f", newYearSalary1);
        System.out.printf("\nEmployee2's yearly salary after raise is: %.1f", newYearSalary2);
    }

}
