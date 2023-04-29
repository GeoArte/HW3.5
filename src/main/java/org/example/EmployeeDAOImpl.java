package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDAOImpl implements EmployeeDAO {
    private Connection connection;

    public EmployeeDAOImpl() {
        this.connection = connection;
    }

    @Override
    public void create(Employee employee) {
        String sql = "INSERT INTO employee (first_name, last_name, gender, age, city_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getGender());
            statement.setInt(4, employee.getAge());
            statement.setInt(5, employee.getCityId());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error creating employee: " + e.getMessage());
        }
    }

    @Override
    public Employee getById(int id) {
            String sql = "SELECT id, first_name, last_name, gender, age, city_id FROM employee WHERE id = ?";

            try (Connection connection = getConnection();
                 PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        int employeeId = resultSet.getInt("id");
                        String firstName = resultSet.getString("first_name");
                        String lastName = resultSet.getString("last_name");
                        String gender = resultSet.getString("gender");
                        int age = resultSet.getInt("age");
                        int cityId = resultSet.getInt("city_id");

                        return new Employee(employeeId, firstName, lastName, gender, age, cityId);
                    }
                }
            } catch (SQLException e) {
                System.out.println("Error getting employee by ID: " + e.getMessage());
            }

            return null;
        }

    public List<Employee> getAll() {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee");

            ResultSet result = statement.executeQuery();

            List<Employee> employees = new ArrayList<>();
            while (result.next()) {
                Employee employee = new Employee(result.getInt("id"), result.getString("first_name"), result.getString("last_name"), result.getString("gender"), result.getInt("age"), result.getInt("city_id"));
                employees.add(employee);
            }

            return employees;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    public void update(Employee employee) {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE employee SET first_name = ?, last_name = ?, gender = ?, age = ?, city_id = ? WHERE id = ?");
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getLastName());
            statement.setString(3, employee.getGender());
            statement.setInt(4, employee.getAge());
            statement.setLong(5, employee.getCityId());
            statement.setLong(6, employee.getId());

            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void deleteById(int id) {
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM employee WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/skypro";
        String username = "postgres";
        String password = "polkiklopov12";
        return DriverManager.getConnection(url, username, password);
    }
}