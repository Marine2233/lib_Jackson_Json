package json.person;

public class Person {
    private String name;
    private int age;
    private Passport passport;

    public Person() {
    }

    public Person(int age, String name, Passport passport) {
        this.age = age;
        this.name = name;
        this.passport = passport;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", passport=" + passport +
                '}';
    }
}
