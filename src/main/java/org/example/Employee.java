package org.example;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String gender;
    private int age;
    private int cityId;

    public Employee(int id, String firstName, String lastName, String gender, int age, int cityId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.cityId = cityId;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public int getCityId() {
        return cityId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getGender() {
        return gender;
    }

    public String getLastName() {
        return lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
