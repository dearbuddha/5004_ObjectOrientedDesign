package Lesson4;

class Table {  //class is by default private
    public Table(int height, double weight, String shape){
        this.setHeight(height);
        this.weight = weight;
        this.shape = shape;
    }

    private int height;  //default value is 0
    public double weight;  // default value is 0.0
    public String shape;  // default value is a null

    public double getWeight(){
        return this.weight;
    }

    public void setWeight(double weight){
        this.weight = weight;
    }

    void increaseHeight(){  // method by default is public
        height = height + 1;
    }

    public void decreaseHeight(){
        height = height -1;
    }

    public boolean setHeight(int height){  //good practice to have a setter method to check the input
        if(height>100 || height < 5){
            return false;
        }
        this.height = height;  // in this case, "this" is mandatory, because "this" improve clarity
        return true;
    }

    public int getHeight(){
        return this.height;
    }

    public void increaseVal(int x){
        x = x + 1;
    }

    public int increaseVal2(int x) {
        return x+1;
    }
}

class Person {
    private int age;
    private String name;

    public Person(String name, int age){
        setAge(age);
        setName(name);
    }

    public Person(){  //default constructor

    }

    public void setAge(int age){
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return "Name: " + getName() + ", Age: " + getAge();
    }

    public boolean equals(Person other){
        return this.age == other.age && this.name.equals(other.name);
    }

    public void test(Person x){
        x.setAge(101);
    }
}

public class Test{
    public static void main(String[] args) {
//        Table t1 = new Table(10, 20.2, "s");
//        Table t2 = new Table(20,30.0,"t");
//        t1.setHeight(10);
//        t2.setHeight(20);
//        t1.increaseHeight();
//        t2.decreaseHeight();
//
//        int test = 10;
//        t1.increaseVal(test);
//        System.out.println("Test: " + test);
//
//        int test2 = 10;
//        test2 = t1.increaseVal2(test2);
//        System.out.println("Test2: "+ test2);
//
//        System.out.println("The current height of t1 is " + t1.getHeight());
//        System.out.println("The current height of t2 is " + t2.getHeight());

        Person A = new Person();
        System.out.println("Name: " + A.getName() + ", Age: " + A.getAge());
        Person B = new Person("Mary", 23);
        System.out.println(B);
        Person C = new Person("Jerry", 3);
        System.out.println(B == C);
        System.out.println(B.equals(C));

        A = B;
        System.out.println("A: " + A);
        System.out.println("B: " + B);

        C.test(B);
        System.out.println("B: " + B);

    }
}