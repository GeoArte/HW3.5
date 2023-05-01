package org.example;

import javax.persistence.*;

@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "gender")
    private String gender;
    @Column(name = "age")
    private int age;
    @ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City city;

    public Employee() {

    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public int getCityId() {
        return city.getId();
    }

    public City getCity(){
        return city;
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

    public void setCity(City city) {
        this.city = city;
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
