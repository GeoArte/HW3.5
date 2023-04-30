package org.example;

import org.example.Employee;

import java.util.List;

public interface EmployeeDAO {
    void create(Employee employee);
    void getById(int id);
    void getAll();
    void update(Employee employee);
    void deleteById(Employee employee,int id);

    void deleteById(int id);
}
