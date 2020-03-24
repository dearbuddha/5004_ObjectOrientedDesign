package Lesson9;

import java.util.ArrayList;

class Account {
    public class Money {
        public Money(int amt) {
            this.amt = amt;
        }
        private int amt;
        public int getAmt() {
            testIt();
            Account.this.testIt();
            return this.amt;
        }

        public <T> void printIt(T x) {
            System.out.println(x);
        }

        public void testIt() {
            System.out.println("I am here!");
        }
    }

    public void testIt() {
        System.out.println("I am here! Outer class!");
    }
}

// Base class A has a method called f()
// Derived class B, C
// Pair<T extends A, S>

class Pair<T extends Comparable, S> implements Comparable {
    public Pair(T fst, S snd) {
        setFirst(fst);
        setSecond(snd);
    }
    private T first;
    private S second;
    public void setFirst(T first) {
        this.first = first;
    }
    public void setSecond(S second) {
        this.second = second;
    }
    public T getFirst() {
        return this.first;
    }
    public S getSecond() {
        return this.second;
    }
    public String toString() {
        return "(" + getFirst() + ", " + getSecond() + ")";
    }

    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }
        Pair<T,S> otherObject = (Pair<T,S>) other;
        return this.first.equals(otherObject.first) && this.second.equals(otherObject.second);
    }

    public int compareTo(Object other) {
        if (other == null) {
            throw new NullPointerException();
        }
        if (other.getClass() != this.getClass()) {
            throw new ClassCastException();
        }
        Pair<T, S> otherObject = (Pair<T,S>) other;
        int fst = this.first.compareTo(otherObject.first);
        //int snd = this.second.equals(otherObject.second);
        return fst;
    }

}

class NormalPair {
    public NormalPair(int fst, int snd) {
        setFirst(fst);
        setSecond(snd);
    }
    private int first;
    private int second;
    public void setFirst(int first) {
        this.first = first;
    }
    public void setSecond(int second) {
        this.second = second;
    }
    public int getFirst() {
        return this.first;
    }
    public int getSecond() {
        return this.second;
    }
    public String toString() {
        return "(" + getFirst() + ", " + getSecond() + ")";
    }
}

class OldPair {
    public OldPair(Integer fst, String snd) {
        setFirst(fst);
        setSecond(snd);
    }
    private Integer first;
    private String second;
    public void setFirst(Integer first) {
        this.first = first;
    }
    public void setSecond(String second) {
        this.second = second;
    }
    public Integer getFirst() {
        return this.first;
    }
    public String getSecond() {
        return this.second;
    }
    public String toString() {
        return "(" + getFirst() + ", " + getSecond() + ")";
    }
}




public class Test {
    public static void main(String[] args) {
        Account acc = new Account();
        Account.Money money = acc.new Money(12);
        System.out.println(money.getAmt());
        money.testIt();
        money.printIt("Hello there!");
        money.printIt(new Pair<Integer,Integer>(122, 0));

        NormalPair p = new NormalPair(12,13);
        System.out.println(p);

        OldPair p2 = new OldPair(12, "hey");
        System.out.println(p2);

        Pair<Integer, Double> p3 = new Pair<>(13, 3.3);
        System.out.println(p3);

        Pair<Integer, Integer> p4 = new Pair<Integer, Integer>(13, 33);
        System.out.println(p4);

        System.out.println(p3.equals(p4));

        //ArrayList<String> test = new ArrayList<String>(10);
        //ArrayList legacyTest = new ArrayList(21);

        ArrayList<Pair<Integer, Double>> pairList = new ArrayList<Pair<Integer, Double>>();
        pairList.add(new Pair<Integer, Double>(22, 3.4));

        //Pair<Account.Money, Integer> p5 = new Pair<Account.Money, Integer>(44, 22);

        //ArrayList<String>[] test2 = new ArrayList<String>[123];
    }
}

// Suppose we have class A<T>
// If class P extends class Q => P is a derived class of Q and Q is the base class
// What is the relationship between A<P> and A<Q>?
// Three possiblities
// Covariant --> A<P> extends A<Q>
// Contravariant --> A<Q> extends A<P>
// Invariant a.k.a Non-Variant (Java) --> A<Q> and A<P> are unrelated
