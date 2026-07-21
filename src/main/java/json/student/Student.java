package json.student;

public class Student {


    private String name;
    private int age;
    private double averageMark;

    public Student() {
    }

    public Student(String name,
                   int age,
                   double averageMark) {

        this.name = name;
        this.age = age;
        this.averageMark = averageMark;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getAverageMark() {
        return averageMark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", averageMark=" + averageMark +
                '}';
    }
}
