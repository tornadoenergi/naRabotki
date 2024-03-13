package three;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SettingFilter {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        set.add("one");
        set.add("two");
        set.add("three");
        set.add("ten");

        String search = scanner.nextLine();
        for(String elem : set){
            if(elem.contains(search)){
                System.out.println("Элемент найден: " + elem);
            }
        }
    }
}
