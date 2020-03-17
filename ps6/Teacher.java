package ps6;

/**
 *  Wenhan Cai
 *  CS 5004 homework 6
 */
public class Teacher extends Person{

    public Teacher(String firstName, String lastName, String subject, int salary){
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setSubject(subject);
        this.setSalary(salary);
    }

    public Teacher(){
        this.setFirstName(null);
        this.setLastName(null);
        this.setSubject(null);
        this.setSalary(0);
    }

    /**
     * Copy constructor
     * @param other
     */
    public Teacher(Teacher other){
        this(other.getFirstName(), other.getLastName(), other.getSubject(), other.getSalary());
    }

    private String subject;
    private int salary;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        if(salary < 0){
            throw new IllegalArgumentException("Please enter a valid salary");
        }
        this.salary = salary;
    }

    public boolean equals(Teacher other){
        return super.equals(other) && this.getSubject() == other.getSubject() && this.getSalary() == other.getSalary();
    }

    public String toString(){
        return super.toString() + ", Subject: " + getSubject() + ", Salary: " + getSalary();
    }
}
