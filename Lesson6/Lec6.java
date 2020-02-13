package Lesson6;

public class Lec6 {

    public static void main(String[] args) {
//        Date[] array;
//        array = new Date[10];

//        for(int x : array){
//            System.out.println(x);
//        for(int i = 0; i < array.length; i++){
//            array[i] = new Date();
//        }
//
//        for(Date d : array){
//            System.out.println(d);
//        }

        //deep copy of dates array
//        Date[] dates = new Date[array.length];
//        dates[1].setDay(31);  <-- nullPointerException
//        for(int i = 0; i < dates.length; i++){
//            dates[i] = new Date(array[i]);
//        }
        Employee a = new Employee("Mary", new Date(2010,9,1));
        System.out.println(a);

        FullTimeEmp b = new FullTimeEmp("Anit",new Date(1999, 9, 1), 1000);
        b.setName("Bill");
        System.out.println(b);

        Employee[] arr = new Employee[2];
        arr[0] = a;
        arr[1] = b;

    }

    public static boolean dateArrayEqual(Date[] left, Date[] right){
        if(left == null || right == null) return false;
        if(left.length != right.length) return false;
        for(int i = 0; i < left.length; i++){
            if(left[i].equals(right[i])) return false;
        }
        return true;
    }

}

class Employee {
    public Employee(String name, Date date){
        this.setbd(date);
        this.setName(name);
    }

    public Employee(Employee other){
        setName(other.name);
        setbd(other.bd);

    }

    public Employee(){
        this("", new Date());
    }

    private String name;
    private Date bd;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getbd() {
        return new Date(this.bd);
    }

    public void setbd(Date bd) {
        this.bd = new Date(bd);
    }

    public String toString(){
        return "Name: " + this.name + " dob: " + this.bd;
    }
}

class FullTimeEmp extends Employee {

    public FullTimeEmp(String name, Date dob, int salary){
        super(name, dob);
        setSalary(salary);
    }

    private int salary;

    public int getSalary() {
        return this.salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String toString(){
        return super.toString() + ", salary: " + this.salary;
    }
}

class Date {

    public Date(int month, int day, int year){
        setYear(year);
        setMonth(month);
        setDay(day);
        count ++;
    }

    public Date(){
        this(1,1,1900);
    }

    /**
     * Copy constructor
     * @param other
     */
    public Date(Date other){
        this(other.month, other.day, other.year);
    }

    private int year;
    private int month;
    private int day;
    public static int count;

    public int getYear(){
        return this.year;
    }

    public boolean setYear(int year){
        if(year < 0){
            return false;
        }
        this.year = year;
        return true;
    }

    public int getMonth(){
        return this.month;
    }

    public boolean setMonth(int month){
        if(month < 1 || month > 12){
            return false;
        }
        this.month = month;
        return true;
    }

    public int getDay(){
        return this.day;
    }

    public boolean setDay(int day){
        if(day < 1 || day > 31){
            return false;
        }
        this.day = day;
        return true;
    }

    public boolean isEqual(Date other){
        return this.year == other.year && this.month == other.month && this.day == other.day;
    }

    public String toString(){
        return this.getMonth() + "/" + this.getDay() + "/" + this.getYear();
    }

    public static boolean isHalfBirthday(Date bday){
        if(bday.getMonth() >= 8){
            return true;
        }
        return false;
    }

    public static boolean isBabyBoomer(int year){
        if(year >= 1945 && year <= 1955){
            return true;
        }
        return false;
    }
}

class Person {
    public Person(String name, Date birthday, int weight){
        this.name = name;
        this.birthday = birthday;
        this.weight = weight;
    }

    private String name;
    private Date birthday;
    private int weight;

    public Person(Person other){
        if(other == null){
            System.out.println("null ref passed to Person");
            System.exit(0);
        }
        //
        //
        //
    }

    public String getName(){
        return this.name;
    }

    public int getWeight(){
        return this.weight;
    }

    public Date getBirthday(){
        return new Date(birthday);
    }

    public void setBirthday(Date date){
        this.birthday = new Date(birthday);
    }

    public String toString(){
        return this.getName() + ", born: " + this.getBirthday();
    }

}
