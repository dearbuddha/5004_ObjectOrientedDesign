package ps6;

/**
 *  Wenhan Cai
 *  CS 5004 homework 6
 */
public class Student extends Person {

    public Student(String firstName, String lastName, int id, String course, String teacher){
        super.setFirstName(firstName);
        super.setLastName(lastName);
        setStudentID(id);
        setCourse(course);
        setTeacher(teacher);
    }

    public Student(){
        setFirstName(null);
        setLastName(null);
        setStudentID(0);
        setCourse(null);
        setTeacher(null);
    }

    public Student(Student other){
        this(other.getFirstName(), other.getLastName(), other.getStudentID(), other.getCourse(), other.getTeacher());
    }

    private int studentID;
    private String course;
    private String teacher;

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        if(studentID<0){
            throw new IllegalArgumentException("Please enter valid student ID");
        }
        this.studentID = studentID;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public boolean equals(Student other){
        return getStudentID() == other.getStudentID();
    }

    public String toString(){
        return super.toString() + ", ID: " + getStudentID()  + ", Course: " + getCourse() + ", Teacher: " + getTeacher();
    }
}
