import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        Shape[] shapes = new Shape[num];
        scanner.nextLine();
        /*
        put input shapes into the array
         */
        for(int i = 0; i < num; i++) {
            String input = scanner.next();
            if(input.equals("circle")){
                double radius = scanner.nextDouble();
                if(radius < 0) {
                    shapes[i] = new Circle();
                    if(scanner.hasNextLine()) scanner.nextLine();
                } else {
                    shapes[i] = new Circle(radius);
                    if(scanner.hasNextLine()) scanner.nextLine();
                }
            } else if(input.equals("rectangle")){
                double length = scanner.nextDouble();
                double width = scanner.nextDouble();
                if(length < 0 || width < 0){
                    shapes[i] = new Rectangle();
                    if(scanner.hasNextLine()) scanner.nextLine();

                } else {
                    shapes[i] = new Rectangle(length, width);
                    if(scanner.hasNextLine()) scanner.nextLine();
                }
            } else if(input.equals("sphere")){
                double radius = scanner.nextDouble();
                if(radius < 0){
                    shapes[i] = new Sphere();
                    if(scanner.hasNextLine()) scanner.nextLine();
                } else {
                    shapes[i] = new Sphere(radius);
                    if(scanner.hasNextLine()) scanner.nextLine();
                }
            } else if(input.equals("cube")){
                double side = scanner.nextDouble();
                if(side < 0){
                    shapes[i] = new Cube();
                    if(scanner.hasNextLine()) scanner.nextLine();
                } else {
                    shapes[i] = new Cube(side);
                    if(scanner.hasNextLine()) scanner.nextLine();
                }
            } else if(input.equals("tetrahedron")){
                double side = scanner.nextDouble();
                if(side < 0){
                    shapes[i] = new Tetrahedron();
                    if(scanner.hasNextLine()) scanner.nextLine();
                } else {
                    shapes[i] = new Tetrahedron(side);
                    if(scanner.hasNextLine()) scanner.nextLine();
                }
            }
        }

        int n = shapes.length;
        double totalArea = 0;
        double totalVolume = 0;
        // calculate the total area and total volume
        for (Shape shape : shapes) {
            totalArea += shape.getArea();
            totalVolume += shape.getVolume();
        }

        // print out the results
        for (Shape shape : shapes) {
            System.out.printf("%.2f %.2f\n", shape.getVolume(), shape.getArea());
        }
        System.out.printf("%.2f %.2f", totalVolume, totalArea);
    }
}

/**
 * base case for all shapes
 */
abstract class Shape{
    public abstract double getArea();
    public abstract double getVolume();
}

/**
 * Circle class
 */
class Circle extends Shape {

    /**
     * main constructor
     * @param rad
     */
    public Circle(double rad) {
        setRadius(rad);
    }

    /**
     * default constructor
     */
    public Circle(){
        setRadius(0);
    }

    /**
     * copy constructor
     * @param other
     */
    public Circle(Circle other){
        this(other.radius);
    }

    private double radius;
    
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if(radius < 0){
            System.out.println("Please enter a valid radius");
        } else{
            this.radius = radius;
        }
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getVolume() {
        return 0;
    }
}

class Rectangle extends Shape {

    /**
     * main constructor
     * @param length
     * @param width
     */
    public Rectangle(double length, double width){
        setLength(length);
        setWidth(width);
    }

    /**
     * default constructor
     */
    public Rectangle(){
        setLength(0);
        setWidth(0);
    }

    /**
     * copy constructor
     * @param other
     */
    public Rectangle(Rectangle other){
        this(other.length, other.width);
    }

    private double length;
    private double width;

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        if(length < 0){
            System.out.println("Invalid length");
        } else {
            this.length = length;
        }
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if(width < 0){
            System.out.println("Invalid width");
        } else {
            this.width = width;
        }
    }

    @Override
    public double getArea() {
        return length * width;
    }

    @Override
    public double getVolume() {
        return 0;
    }
}

class Sphere extends Shape {

    /**
     * main constructor
     * @param radius
     */
    public Sphere(double radius){
        setRadius(radius);
    }

    /**
     * default constructor
     */
    public Sphere(){
        setRadius(0);
    }

    /**
     * copy constructor
     * @param other
     */
    public Sphere(Sphere other){
        this(other.radius);
    }

    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if(radius < 0){
            System.out.println("Invalid radius");
        } else{
            this.radius = radius;
        }
    }

    @Override
    public double getArea() {
        return Math.PI * 4 * radius * radius;
    }

    @Override
    public double getVolume() {
        return Math.PI * Math.pow(radius, 3) * 4.0/3.0;
    }

    /**
     * compare two spheres
     * @param other
     * @return true if they have the same radius, otherwise false
     */
    public boolean equals(Object other){
        if ( other instanceof Sphere) {
            return this.radius == ((Sphere) other).radius;
        } else {return false;}
    }
}

class Cube extends Shape {

    /**
     * main constructor
     * @param side
     */
    public Cube(double side){
        setSide(side);
    }

    /**
     * default constructor
     */
    public Cube(){
        setSide(0);
    }

    /**
     * copy constructor
     * @param other
     */
    public Cube(Cube other){
        this(other.side);
    }

    private double side;

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        if(side < 0){
            System.out.println("Invalid side");
        } else{
            this.side = side;
        }
    }

    @Override
    public double getArea() {
        return 6 * side * side;
    }

    @Override
    public double getVolume() {
        return side * side * side;
    }
}

class Tetrahedron extends Shape {

    private double side;

    /**
     * main constructor
     * @param side
     */
    public Tetrahedron(double side){
        setSide(side);
    }

    /**
     * default constructor
     */
    public Tetrahedron(){
        setSide(0);
    }

    /**
     * copy constructor
     * @param other
     */
    public Tetrahedron(Tetrahedron other){
        this(other.side);
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        if(side < 0){
            System.out.println("Invalid side");
        } else{
            this.side = side;
        }
    }

    @Override
    public double getArea() {
        return Math.sqrt(3) * side * side;
    }

    @Override
    public double getVolume() {
        return Math.sqrt(2) * Math.pow(side, 3) * 1.0/12.0;
    }
}