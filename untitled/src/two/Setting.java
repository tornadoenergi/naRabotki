package two;

import java.util.HashSet;
import java.util.Set;

public class Setting {
    public static void main(String[] args){
        Set<String> set = new HashSet<>();

        set.add("one");
        set.add("two");
        set.add("three");

        Set<String> set2 = new HashSet<>();

        set2.add("two");
        set2.add("three");
        set2.add("four");

        Set<String> setCombined = new HashSet<>(set);
        setCombined.addAll(set2);

        System.out.println(setCombined);
    }
}
