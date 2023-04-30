package org.example;

import javax.persistence.*;
import java.sql.*;
import java.util.List;


public class EmployeeDAOImpl implements EmployeeDAO {
    private Connection connection;

    public EmployeeDAOImpl() {
        this.connection = connection;
    }

    @Override
    public void create(Employee employee) {
        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            Employee newEmployee = new Employee();
            newEmployee.setFirstName(employee.getFirstName());
            newEmployee.setLastName(employee.getLastName());
            newEmployee.setGender(employee.getGender());
            newEmployee.setAge(employee.getAge());
            newEmployee.setCityId(employee.getCityId());
            entityManager.getTransaction().begin();
            entityManager.persist(newEmployee);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error creating employee: " + e.getMessage());
        }
    }


    @Override
    public void getById(int id) {
        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            Employee employee = entityManager.find(Employee.class, id);
            if (employee != null) {
                System.out.println(employee.getId() + " " + employee.getFirstName() + " " + employee.getLastName() + " " + employee.getGender() + " " + employee.getAge() + " " + employee.getCityId());
            }
        } catch (Exception e) {
            System.out.println("Error getting employee by ID: " + e.getMessage());
        }
    }

    public void getAll() {
        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            TypedQuery<Employee> query = entityManager.createQuery("SELECT e FROM Employee e", Employee.class);
            List<Employee> employees = query.getResultList();
            for (Employee employee : employees) {
                System.out.println(employee.getId() + " " + employee.getFirstName() + " " + employee.getLastName() + " " + employee.getGender() + " " + employee.getAge() + " " + employee.getCityId());
            }
        } catch (Exception e) {
            System.out.println("Error getting all employees: " + e.getMessage());
        }
    }

    public void update(Employee employee) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(employee);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deleteById(Employee employee, int id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Employee employeeToDelete = entityManager.find(Employee.class, id);
        if (employeeToDelete != null) {
            entityManager.remove(employeeToDelete);
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    private Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/skypro";
        String username = "postgres";
        String password = "polkiklopov12";
        return DriverManager.getConnection(url, username, password);
    }
}