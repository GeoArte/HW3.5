import org.example.Employee;
import org.example.EmployeeDAO;
import org.example.EmployeeDAOImpl;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.sql.*;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException {
        EmployeeDAO test = new EmployeeDAOImpl();
        test.getAll();
    }
}
