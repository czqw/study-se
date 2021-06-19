package test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

/**
 * @Description
 * @Author zhiqiang.cheng
 * @Date2020/6/7 10:53 下午
 **/
public class Test {

    public static void main(String[] args) {
        HashSet set = new HashSet();
        Student s1 = new Student("a",22);
        Student s2 = new Student("b",23);
        Student s3 = new Student("a",24);
        set.add(s1);
        set.add(s2);
        set.add(s3);

        Iterator<Student> it = set.iterator();

        while (it.hasNext()){
            Student s = it.next();
            System.out.println(s);
        }
    }
}


class Student{
    private String name;
    private Integer age;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}