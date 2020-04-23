import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int count = Integer.parseInt(scan.nextLine().trim());

// You are free to choose a different data structure--whatever works for you!
// In that case, remember not to change the variable name.
// If you decide to work with the provided data structure, it is on you to
// use it correctly. We will not answer questions like "what does String represent?" etc.
        HashMap<String, TreeMap<DateTime, String>> log = new HashMap<String, TreeMap<DateTime, String>>(); // HashMap<Door, TreeMap<>>

        for (int i = 0; i < count; i++) {


            String line = scan.nextLine();
            String[] fields = line.split(" ");

            Integer month = DateTime.monthToNum(fields[0]);
            Integer day = Integer.parseInt(fields[1].substring(0, fields[1].length() - 1));
            Integer year = Integer.parseInt(fields[2]);
            String hms = fields[4];
            String name = fields[5];
            String door = fields[6];

            String[] hmsFields = hms.split(":");
            Integer hour = Integer.parseInt(hmsFields[0]);
            Integer minute = Integer.parseInt(hmsFields[1]);
            Integer second = Integer.parseInt(hmsFields[2]);

            DateTime dtEntry = new DateTime(year, month, day, hour, minute, second);

/*
TODO: code here concerns placing the record into log.
*/
            if (!log.containsKey(door)) {
                TreeMap<DateTime,String> tree = new TreeMap<>(Collections.reverseOrder());
                tree.put(dtEntry, name);
                log.put(door, tree);
            } else {
                log.get(door).put(dtEntry, name);
            }
        }


        count = Integer.parseInt(scan.nextLine().trim());
        for (int i = 0; i < count; i++) {
            String query = scan.nextLine();
/*
TODO: code here concerns querying the log and outputing the results.
Output to System.out
*/
            if(!log.containsKey(query)){
                System.out.println("Door " + query + " does not appear in the log!");
            } else {
                System.out.println(query + " was accessed:");
                for(Map.Entry<DateTime, String> treeMapEntry : log.get(query).entrySet()){
                    System.out.println(" -- " + treeMapEntry.getKey() + " by " + treeMapEntry.getValue());
                }
            }
        }

        scan.close();
    }
}

class DateTime implements Comparable<DateTime> {

    public DateTime(int year, int month, int day, int hour, int minute, int second){
        if(!dateTimeOk(year, month, day, hour, minute, second)){
            throw new IllegalArgumentException("Invalid input");
        } else {
            this.year = year;
            this.month = month;
            this.day = day;
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        }
    }

    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private int second;

    public String toString() {
/*
TODO: make sure that you follow the output specification
*/
        return String.format("%s %02d, %d at %02d:%02d:%02d", numToMonth(month), day, year, hour, minute, second);
    }

    public boolean equals(Object other) {
/*
TODO: to get the full grade, follow the recipe discussed in the class
*/
        if(other == null || this.getClass() != other.getClass()) return false;
        DateTime otherDateTime = (DateTime) other;
        return (this.year == otherDateTime.year && this.month == otherDateTime.month && this.day == otherDateTime.day
                && this.hour == otherDateTime.hour && this.minute == otherDateTime.minute && this.second == otherDateTime.second);
    }

    public int hashCode() {
/*
TODO
*/
        return toString().hashCode();
    }

    public int compareTo(DateTime other) {
/*
TODO
*/
        if (other == null) {
            throw new NullPointerException();
        }
        if (other.getClass() != this.getClass()) {
            throw new ClassCastException();
        }
        if (this.precedes(other)) {
            return 1;
        }
        if (this.follows(other)) {
            return -1;
        }
        return 0;
    }

    public static Integer monthToNum(String m) {
/*
TODO: this method converts a month to its number. Example: January -> 1, December -> 12
*/
        if (m.equals("January")) return 1;
        else if (m.equals("February")) return 2;
        else if (m.equals("March")) return 3;
        else if (m.equals("April")) return 4;
        else if (m.equals("May")) return 5;
        else if (m.equals("June")) return 6;
        else if (m.equals("July")) return 7;
        else if (m.equals("August")) return 8;
        else if (m.equals("September")) return 9;
        else if (m.equals("October")) return 10;
        else if (m.equals("November")) return 11;
        else if (m.equals("December")) return 12;
        else throw new IllegalArgumentException("Invalid month");
    }

    public static String numToMonth(Integer m) {
/*
TODO: this method is the inverse of the method above. Example: 1 -> January, 12 -> December
*/
        if (m == 1) return "January";
        else if (m == 2) return "February";
        else if (m == 3) return "March";
        else if (m == 4) return "April";
        else if (m == 5) return "May";
        else if (m == 6) return "June";
        else if (m == 7) return "July";
        else if (m == 8) return "August";
        else if (m == 9) return "September";
        else if (m == 10) return "October";
        else if (m == 11) return "November";
        else if (m == 12) return "December";
        else throw new IllegalArgumentException("Month must be between 1-12");
    }

    private boolean dateTimeOk(int year, int month, int day, int hour, int minute, int second) {
        return ((year >= 1000 && year <= 9999) && (month >= 1 && month <= 12) && (day >= 1 && day <= 31)
                && (hour<=23 && hour>= 0) && (minute<=59 && minute>=0) && (second <= 59 && second >= 0));
    }

    private boolean precedes(Object other) {
        if (other == null) {
            return false;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }
        DateTime otherDateTime = (DateTime) other;
        if (this.year < otherDateTime.year || (this.year == otherDateTime.year && this.month < otherDateTime.month)
                || (this.year == otherDateTime.year && this.month == otherDateTime.month && this.day < otherDateTime.day)
                || (this.year == otherDateTime.year && this.month == otherDateTime.month && this.day == otherDateTime.day && this.hour < otherDateTime.hour)
                || (this.year == otherDateTime.year && this.month == otherDateTime.month && this.day == otherDateTime.day && this.hour == otherDateTime.hour && this.minute < otherDateTime.minute)
                || (this.year == otherDateTime.year && this.month == otherDateTime.month && this.day == otherDateTime.day && this.hour == otherDateTime.hour && this.minute == otherDateTime.minute && this.second < otherDateTime.second)) {
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

        DateTime otherDateTime = (DateTime) other;

        if (this.year == otherDateTime.year && this.minute == otherDateTime.month && this.day == otherDateTime.day
                && this.hour == otherDateTime.hour && this.minute == otherDateTime.minute && this.second == otherDateTime.second) return false;

        return !this.precedes(other);
    }
}