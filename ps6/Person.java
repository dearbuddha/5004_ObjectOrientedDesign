package ps6;

/**
 *  Wenhan Cai
 *  CS 5004 homework 6
 */
public class Person {

    public Person(String firstName, String lastName){
        setFirstName(firstName);
        setLastName(lastName);
    }

    public Person(){
        setFirstName(null);
        setLastName(null);
    }

    /**
     * Copy constructor
     * @param other
     */
    public Person(Person other){
        this(other.firstName, other.lastName);
    }

    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean equals(Person other){
        return this.getFirstName() == other.getFirstName() && this.getLastName() == other.getLastName();
    }

    public String toString(){
        return "FirstName: " + getFirstName() + ", LastName: " + getLastName();
    }

}
