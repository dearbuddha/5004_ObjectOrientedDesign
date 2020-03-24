package hw4;

/**
 *  Wenhan Cai
 *  CS 5004 homework 4-3
 */
class Rational {
    int numerator;
    int denominator;

    public Rational(int numerator, int denominator){
        if(denominator == 0){
            throw new IllegalArgumentException("Error: denominator is zero");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Rational(int whole){
        setNumerator(whole);
        setDenominator(1);
    }

    public Rational(){
        this.setNumerator(0);
        this.setDenominator(0);
    }

    public void setNumerator(int numerator){
        this.numerator = numerator;
    }

    public int getNumerator(){
        return  this.numerator;
    }

    public void setDenominator(int denominator){
        this.denominator = denominator;
    }

    public int getDenominator() {
        return denominator;
    }

    public Rational addition(Rational other){
        Rational result = new Rational();
        result.setNumerator(this.numerator*other.denominator + other.numerator * this.denominator);
        result.setDenominator(this.denominator * other.denominator);
        return result;
    }

    public Rational subtraction(Rational other){
        Rational result = new Rational();
        Rational newOther = new Rational(-other.numerator, other.denominator);
        result = this.addition(newOther);
        return result;
    }

    public Rational multiplication(Rational other){
        Rational result = new Rational();
        result.setNumerator(this.numerator * other.numerator);
        result.setDenominator(this.denominator * other.denominator);
        return result;
    }

    public Rational division(Rational other){
        Rational result = new Rational();
        result.setNumerator(this.numerator * other.denominator);
        result.setDenominator(this.denominator * other.numerator);
        return result;
    }

    public Rational normalize(){
        if(this.denominator < 0){
            this.denominator = - this.denominator;
            this.numerator = - this.numerator;
        }
        if(this.denominator < 0 && this.numerator < 0){
            this.denominator = - this.denominator;
            this.numerator = - this.numerator;
        }
        return this;
    }

    public boolean equals(Rational other){
        return this.numerator * other.denominator == this.denominator * other.numerator;
    }

    public String toString(){
        return numerator + "/" + denominator;
    }

//    private static int gcd(int a, int b){
//        if(a < 0) a = -a;
//        if(b < 0) b = -b;
//        if( b == 0) return a;
//        else return gcd(b, a%b);
//    }
}

public class RationalTest {

    public static void main(String[] args) {
        Rational number1 = new Rational(2, 3);
        Rational number2 = new Rational(5);
        Rational number3 = new Rational();
        Rational number4 = new Rational(3, -4);
        System.out.println("number1: " + number1 + "\nnumber2: " + number2 + "\nnumber3: " + number3 + "\nnumber4: " + number4);
        System.out.println("-----Test addition: number1 + number2 = 17/3 ");
        System.out.println(number1.addition(number2));
        System.out.println("-----Test subtraction: number1 - number4 = -17/-12 ");
        System.out.println(number1.subtraction(number4));
        System.out.println("-----Test normalize() on the previous subtraction result: 17/12-----");
        System.out.println(number1.subtraction(number4).normalize());
        System.out.println("-----Test normalize() on number1 addition number4-----");
        System.out.println(number1.addition(number4));
        System.out.println(number1.addition(number4).normalize());
        System.out.println("-----Test multiplication: number1 * number4 = 6/-12, and normalize");
        System.out.println(number1.multiplication(number4));
        System.out.println(number1.multiplication(number4).normalize());
        System.out.println("-----Test division: number1 / number4 = -8/9, and normalize");
        System.out.println(number1.division(number4));
        System.out.println(number1.division(number4).normalize());
        System.out.println("-----Test denominator with 0-----");
        System.out.println(number3);

    }
}
