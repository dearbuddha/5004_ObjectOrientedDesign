package Lesson12;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

public class DateTest {
    public static void main(String[] args) {

        HashSet<Date> dateSet = new HashSet<Date>();
        Date a = new Date(2000, 12, 12);
        Date b = new Date(2000, 12, 12);
        Date c = new Date(2020, 12, 12);
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
        dateSet.add(a);
        dateSet.add(b);
        dateSet.add(c);

        Iterator<Date> it = dateSet.iterator();
        while(it.hasNext()) {
            System.out.println(it.next() + "    iterator");
        }

        for(Date d : dateSet) {
            System.out.println(d + "     Enhanced for");
        }

        //            ----------
        //            |        |    hashCode() % 4
        //            |  a,c   |    hashCode() % 4
        //            |        |    hashCode(a) = 5  =>  hashCode(a) % 4 = 1 and a.equals(b) is true
        //            |        |    hashCode(c) = 9  =>  hashCode(b) % 4 = 1 but a.equals(c) is false
        //            ----------
        //
        //            instructions for HashSet.add(x):
        //            1) compute location h based on F(x.hashCode())
        //            2) is h already occupied?
        //            3) if not, then insert it
        //            4) otherwise, for each guy y there (at location h) test x.equals(y) is true
        //            5) if none are true, insert it.
        //

        HashSet<Integer> s = new HashSet<>();
        HashSet<Integer> t = new HashSet<>();
        s.add(1); s.add(2); s.add(3); // s = {1,2,3}
        t.add(2); t.add(3); t.add(4); // t = {2,3,4}

        HashSet<Integer> union = new HashSet<>(s); // union = s
        union.addAll(t);
        HashSet<Integer> intersection = new HashSet<>(s); // intersection = s
        intersection.retainAll(t);
        HashSet<Integer> diff = new HashSet<>(s); // diff = s
        diff.removeAll(t);

        System.out.print("\ns contains ");
        for(Integer x : s) {
            System.out.print(x + " ");
        }
        System.out.print("\nt contains ");
        for(Integer x : t) {
            System.out.print(x + " ");
        }
        System.out.print("\nunion contains ");
        for(Integer x : union) {
            System.out.print(x + " ");
        }
        System.out.print("\nintersection contains ");
        for(Integer x : intersection) {
            System.out.print(x + " ");
        }
        System.out.print("\ndifference contains ");
        for(Integer x : diff) {
            System.out.print(x + " ");
        }

        LinkedList<Date> dlist = new LinkedList<>();
        dlist.add(new Date(1990, 12, 10));
        dlist.add(new Date(1991, 12, 10));
        dlist.add(new Date(1992, 12, 10));

        System.out.println("\n");

        Iterator<Date> it2 = dlist.iterator();
        while (it2.hasNext()) {
            Date d = it2.next();
            d.setYear(d.getYear()+10);
            System.out.println(d);
        }

        System.out.println("\n");

        for (Date d : dlist) {
            d.setYear(d.getYear() + 10);
            System.out.println(d);
        }

        //               R
        //              /\
        //
        //

        LinkedList<String> ls = new LinkedList<>();
        ls.add("Canada");
        ls.add("Canada");
        ls.add("USA");
        ls.add("UK");
        ls.add("Iceland");

        System.out.println("\noutput from LinkedList");
        for(String ss : ls) {
            System.out.println(ss);
        }

        TreeSet<String> ts = new TreeSet<>(ls);
        System.out.println("\noutput from TreeSet");
        for(String ss : ts) {
            System.out.println(ss);
        }

        HashSet<String> hs = new HashSet<>(ls);
        System.out.println("\noutput from HashSet");
        for(String ss : hs) {
            System.out.println(ss);
        }
    }
}

class Date {
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

    public int hashCode() {
        return toString().hashCode();
    }

    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }

        Date otherDate = (Date) other;
        return (this.getYear() == otherDate.getYear() && this.getMonth() == otherDate.getMonth() && this.getDay() == otherDate.getDay());
    }
}