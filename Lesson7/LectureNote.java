package Lesson7;


public class LectureNote {

    public static void main(String[] args) {
//        Date d = new Date(11,22,2019);
//        System.out.println(d);
        FlatShape s;
        s = new Rectangle(12, 4);
        System.out.println(s.area());

        FlatShape[] FlatShapes = new FlatShape[4];
        FlatShapes[0] = new Rectangle(10,2);
        FlatShapes[1] = new Rectangle(3,2);
        FlatShapes[2] = new Square(8);
        FlatShapes[3] = new Circle(8);

        for(int i = 0; i < FlatShapes.length; i++){
            System.out.println("The area of FlatShape " + i + " is " + FlatShapes[i].area());
        }

        Parent p = new Parent();
        Child c = new Child();

        Parent x = c;

        x.announce();
        x.shout();
    }

    static class Date {

        public Date(int month, int day, int year) {
            setYear(year);
            setMonth(month);
            setDay(day);
            count++;
        }

        public Date() {
            this(1, 1, 1900);
        }

        /**
         * Copy constructor
         *
         * @param other
         */
        public Date(Date other) {
            this(other.month, other.day, other.year);
        }

        private int year;
        private int month;
        private int day;
        public int count;

        public int getYear() {
            return this.year;
        }

        public boolean setYear(int year) {
            if (year < 0) {
                return false;
            }
            this.year = year;
            return true;
        }

        public int getMonth() {
            return this.month;
        }

        public boolean setMonth(int month) {
            if (month < 1 || month > 12) {
                return false;
            }
            this.month = month;
            return true;
        }

        public int getDay() {
            return this.day;
        }

        public boolean setDay(int day) {
            if (day < 1 || day > 31) {
                return false;
            }
            this.day = day;
            return true;
        }

        public boolean isEqual(Date other) {
            return this.year == other.year && this.month == other.month && this.day == other.day;
        }

        public String toString() {
            return this.getMonth() + "/" + this.getDay() + "/" + this.getYear();
        }

        @Override
        public boolean equals(Object other){
            if(other == null){
                return false;
            }
            if(this.getClass() != other.getClass()){
                return false;
            }
            Date otherDate = (Date) other;
            return this.month == otherDate.month && this.day == otherDate.day && this.year == otherDate.year;
        }
    }

    static class Rectangle extends FlatShape {
        private double length;
        private double width;

        public Rectangle(double length, double width) {
            this.setLength(length);
            this.setWidth(width);
        }

        public double getLength() {
            return length;
        }

        public boolean setLength(double length) {
            if(length <= 0){
                return false;
            }
            this.length = length;
            return true;
        }

        public double getWidth() {
            return width;
        }

        public boolean setWidth(double width) {
            if(width <= 0){
                return false;
            }
            this.width = width;
            return true;
        }

        public double area(){
            return length * width;
        }
    }

    static class Square extends Rectangle {

        public Square(double side){
            super(side,side);
        }

        public boolean setLength(double len){
            return super.setLength(len) && super.setWidth(len);
        }

        public boolean setWidth(double len){
            return super.setLength(len) && super.setWidth(len);
        }
    }

    static class Circle extends FlatShape{
        private double radius;

        public Circle(double raidus) {
            this.radius = raidus;
        }

        public double getRadius(){
            return radius;
        }

        public boolean setRadius(double radius){
            if(radius<0){
                return false;
            }
            this.radius = radius;
            return true;
        }

        public double area(){
            return Math.PI * getRadius() * getRadius();
        }
    }

    abstract static class FlatShape extends Shape{
        public abstract double area();
    }

    abstract static class Shape{
        public abstract double area();
    }

    static class Parent{

        public void announce(){
            System.out.println("I am announce method of Parent");
        }

        public static void shout(){
            System.out.println("I am shout method of Parent");
        }
    }

    static class Child extends Parent{

        public void announce(){
            System.out.println("I am announce method of Child");
        }

        public static void shout(){
            System.out.println("I am shout method of Child");
        }
    }
}
