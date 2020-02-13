package Lesson5;

class Date {

    public Date(int month, int day, int year){
        setYear(year);
        setMonth(month);
        setDay(day);
        count ++;
    }

    public Date(){
        new Date(1,1,1900);
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

public class Test {
    public static void main(String[] args) {
        Date a = new Date();
        Date b = new Date(12, 23, 2020);
        System.out.println(a);
        System.out.println(b);

        System.out.println(Date.isHalfBirthday(a));
        System.out.println(Date.isBabyBoomer(a.getYear()));
        System.out.println(Date.count);

        Person p = new Person("John", new Date(12, 12, 2012), 150);
        System.out.println(p);
        int w = p.getWeight();
        Date birthday = p.getBirthday();
        System.out.println(birthday);
        birthday.setYear(1985);
        p.getBirthday().setYear(1000);
        System.out.println(p);
    }
}
