import org.example.*;

import javax.persistence.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws SQLException {
        EmployeeDAO test = new EmployeeDAOImpl();
        CityDAO test2 = new CityDAOImpl();
        test.getAll();

        // Создание объекта City
        City city = new City();
        city.setName("Тбилиси");
        test2.create(city);

        // Создание объектов Employee
        Employee employee1 = new Employee();
        employee1.setFirstName("Иван");
        employee1.setLastName("Иванов");
        employee1.setGender("Мужской");
        employee1.setAge(25);
        employee1.setCity(city);
        test.create(employee1);

        Employee employee2 = new Employee();
        employee2.setFirstName("Анна");
        employee2.setLastName("Петрова");
        employee2.setGender("Женский");
        employee2.setAge(30);
        employee2.setCity(city);
        test.create(employee2);

        // Добавление сотрудников в объект City
        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        city.setEmployees(employees);

        // Получение города из базы данных и вывод информации о сотрудниках
        int idCity = city.getId();
        city = test2.getById(idCity);
        System.out.println("Город " + city.getName() + " содержит следующих сотрудников:");
        for (Employee employee : city.getEmployees()) {
            System.out.println(" - " + employee.getFirstName() + " " + employee.getLastName());
        }

        // Изменение одного из сотрудников и обновление в БД
        employee2.setAge(25);
        test.update(employee2);

        // Получение обновленной информации о сотруднике из базы данных
        test.getAll();

        // Удаление города из базы данных
        test2.deleteById(city.getId());
        // Проверка, что город и связанные сотрудники были удалены из базы данных
        test.getAll();
        test2.getAll();

    }
}
