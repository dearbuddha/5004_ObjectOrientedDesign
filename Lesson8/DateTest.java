package Lesson8;

public class DateTest {
    public static void main(String[] args) {
        Date a = new Date(2000, 12, 12);
        Date b = new Date(2000, 9, 21);
        System.out.println(a.follows(b));

        Test x = new Test();
        x.test();
    }
}

interface A {
    default void test() {
        // default method/implementation
        System.out.println("Interface A");
    }
}

interface B {
    default void test() {
        // default method/implementation
        System.out.println("Interface B");
    }
}

class Test implements A, B {
    public void test() {
        A.super.test();
        B.super.test();
        System.out.println("Class Test");
    }
}

interface Ordered {
    // return true if this preceds other
    boolean precedes(Object other);
    // return true if this follows other
    boolean follows(Object other);
}

interface Printable {
    String show();
}

class Date implements Ordered, Printable, Comparable {
    private int year;
    private int month;
    private int day;

    public Date(int year, int month, int day) {
        if (!dateOk(year, month, day)) {
            System.out.println("Error!");
            System.exit(1);
        } else {
            this.year = year;
            this.month = month;
            this.day = day;
        }
    }

    public int getYear() {return this.year;}
    public int getMonth() {return this.month;}
    public int getDay() {return this.day;}

    public void setYear(int year) {
        if (year < 1900 || year > 9999) {
            System.out.println("Error!");
            System.exit(1);
        } else {
            this.year = year;
        }
    }

    public void setMonth(int month) {
        if (month < 1 || month > 12) {
            System.out.println("Error!");
            System.exit(1);
        } else {
            this.month = month;
        }
    }

    public void setDay(int day) {
        if (day < 1 || day > 31) {
            System.out.println("Error!");
            System.exit(1);
        } else {
            this.day = day;
        }
    }

    public String toString() {return this.month + "/" + this.day + "/" + this.year;}

    private boolean dateOk(int y, int m, int d) {
        return ((y >= 1900 && y <= 9999) && (m >= 1 && m <= 12) && (d >= 1 && d <= 31));
    }

    public boolean precedes(Object other) {
        if (other == null) {
            return false;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }

        Date otherDate = (Date) other;
        if (this.getYear() < otherDate.getYear()
                || (this.getYear() == otherDate.getYear() && this.getMonth() < otherDate.getMonth())
                || (this.getYear() == otherDate.getYear() && this.getMonth() == otherDate.getMonth()
                && this.getDay() < otherDate.getDay())) {
            return true;
        }
        return false;
    }

    public boolean follows(Object other) {
        if (other == null) {
            return false;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }

        Date otherDate = (Date) other;

        if (this.getYear() == otherDate.getYear() && this.getMonth() == otherDate.getMonth()
                && this.getDay() == otherDate.getDay()) {
            return false;
        }

        return !this.precedes(other);
    }

    public int compareTo(Object other) {
        if (other == null) {
            throw new NullPointerException();
        }
        if (other.getClass() != this.getClass()) {
            throw new ClassCastException();
        }
        Date otherDate = (Date) other;
        if (this.precedes(other)) {
            return -1;
        }
        if (this.follows(other)) {
            return 1;
        }
        return 0;
    }

    public String show() {
        return "sss";
    }
}