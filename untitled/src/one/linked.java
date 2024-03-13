package one;

import java.util.LinkedList;

public class linked {
    public static void main(String[] args){
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("two");
        linkedList.add("three");
        linkedList.addFirst("one");
        linkedList.addLast("four");
        System.out.println(linkedList);
    }
}
