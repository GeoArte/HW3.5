package org.example;

import org.example.Employee;

import java.util.List;

public interface EmployeeDAO {
    void create(Employee employee);
    Employee getById(int id);
    List<Employee> getAll();
    void update(Employee employee);
    void deleteById(int id);
}
