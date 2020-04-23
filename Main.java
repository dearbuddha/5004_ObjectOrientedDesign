import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
	// write your code here

        HashMap<Integer,Integer> map = new HashMap<>();
        map.hashCode();
        map.equals(map);

        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        HashSet<Integer> set1 = new HashSet<>();
        set1.add(1);
        System.out.println(set.equals(set1));
        System.out.println(set.hashCode());
    }
}
