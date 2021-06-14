package com.dejan.entity;
import javax.persistence.*;

@Entity(name="student_tabe_db")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "surname")
    private String surname;
    @Column(name = "height")
    private double height;
    @Column(name = "age")
    private int age;
    @Column(name = "std_year")
    private int stdyear;

    public Student(Long id, String userName, String surname, double height, int age, int stdyear) {
        this.id = id;
        this.userName = userName;
        this.surname = surname;
        this.height = height;
        this.age = age;
        this.stdyear = stdyear;
    }

    public Student() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getStdyear() {
        return stdyear;
    }

    public void setStdyear(int stdyear) {
        this.stdyear = stdyear;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", userName='" + userName + '\'' + ", surname='" + surname + '\'' + ", height=" + height + ", age=" + age + ", stdyear=" + stdyear + '}';
    }
}
