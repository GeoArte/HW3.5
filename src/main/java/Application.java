import org.example.Employee;
import org.example.EmployeeDAO;
import org.example.EmployeeDAOImpl;

import java.sql.*;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException {
        EmployeeDAO test = new EmployeeDAOImpl();
        Employee a;
        a = test.getById(1);
        System.out.println(a.getId() + " " + a.getFirstName() + " " + a.getLastName() + " " + a.getGender() + " " + a.getAge() + " " + a.getCityId());
        Employee create = new Employee(6, "Иван", "Иванов", "male", 30, 1);
        test.create(create);
        Employee update = new Employee(1, "Дмитрий", "Иванов", "male", 21, 1);
        test.update(update);
        test.deleteById(10);
        List<Employee> employees = test.getAll();
        for (Employee employee : employees) {
            System.out.println(employee.getId() + " " + employee.getFirstName() + " " + employee.getLastName() + " " + employee.getGender() + " " + employee.getAge() + " " + employee.getCityId());
        }
    }
}
