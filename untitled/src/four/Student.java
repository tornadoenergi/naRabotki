package four;

public class Student {
    private String Name;
    private int Age;


    public Student(String Name, int Age){
        this.Name = Name;
        this.Age = Age;
    }

    public String getName() {
        return Name;
    }

    public int getAge() {
        return Age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Name='" + Name + '\'' +
                ", Age=" + Age +
                '}';
    }
}
