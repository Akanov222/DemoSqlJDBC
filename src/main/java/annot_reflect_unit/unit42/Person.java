package annot_reflect_unit.unit42;


import java.time.LocalDate;
import java.util.Objects;

@Author2(name = "Bro", age = 25)
public class Person {
    private String name;
    private int age;
//    public int dateOfBirth;

    public Person() {
        this.name = "No name";
        this.age = 15;
//        this.dateOfBirth = 1825;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private int getAge() {
        return age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public int run(String man) {
        System.out.println("Person run");
        return age;
    }

    public String sleep(LocalDate date) {
        System.out.println("Person sleep");
        return name;
    }

}
