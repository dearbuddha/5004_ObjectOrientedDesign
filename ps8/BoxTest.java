package ps8;

public class BoxTest {
    public static void main(String[] args) {
        Box<String> box = new Box<>();
        box.add("1. A bad workman always blames his tools");
        box.add("2. A bird in hand is worth two in the bush");
        box.add("3. Absence makes the heart grow fonder");
        box.add("4. A cat has nine lives");
        box.add("5. Actions speak louder than words");
        box.add("6. Adversity and loss make a man wise");
        box.add("7. A drowning man will clutch at a straw");
        box.add("8. Premature optimization is the root of all evil");
        box.add("9. Justice delayed is justice denied");
        box.add("0. Correlation doesn't imply causation");
        while(box.size()>0){
            System.out.println(box.drawItem());
        }

        System.out.println("------------------------------");

        Box<Date> box2 = new Box<>();
        box2.add(new Date(9,4,1992));
        box2.add(new Date(12,25,1971));
        box2.add(new Date(10,1,1949));
        box2.add(new Date(6,19,1970));
        box2.add(new Date(2,29,2020));
        while (box2.size()>0){
            System.out.println(box2.drawItem());
        }

    }
}

class Date {

    public Date(int month, int day, int year) {
        setYear(year);
        setMonth(month);
        setDay(day);
    }

    public Date() {
        new Date(1, 1, 1900);
    }

    public Date(Date other) {
        this(other.month, other.day, other.year);
    }

    private int year;
    private int month;
    private int day;

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return this.month;
    }

    public void setMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Invalid month");
        }
        this.month = month;
    }

    public int getDay() {
        return this.day;
    }

    public void setDay(int day) {
        if (day < 1 || day > 31) {
            throw new IllegalArgumentException("Invalid day");
        }
        this.day = day;
    }

    public boolean isEqual(Date other) {
        return this.year == other.year && this.month == other.month && this.day == other.day;
    }

    public String toString(){
        return getMonth() + ", " + getDay() + ", " + getYear();
    }
}
