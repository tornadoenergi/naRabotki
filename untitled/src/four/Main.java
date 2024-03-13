package four;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args){
        List<Student> students = new ArrayList<>();

        students.add(new Student("Tom",18));
        students.add(new Student("Bob",21));
        students.add(new Student("Anastasiay",25));
        students.add(new Student("Joe",24));
        students.add(new Student("Obj",19));
        students.add(new Student("Kol",18));

        List<Student> filterStudent = students.stream().filter(student -> student.getAge() <= 21).toList();

        System.out.println("Отфильтрованный лист: " + filterStudent);
    }
}
