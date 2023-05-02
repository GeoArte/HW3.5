package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class CityDAOImpl implements CityDAO {
    private Connection connection;

    public CityDAOImpl() {this.connection = connection;
    }

    public void getById(int id) {
        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            City city = entityManager.find(City.class, id);
            if (city != null) {
                System.out.println(city.getId() + " " + city.getName());
            }
        } catch (Exception e) {
            System.out.println("Error getting employee by ID: " + e.getMessage());
        }
    }

    public void getAll() {
        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            TypedQuery<City> query = entityManager.createQuery("SELECT c FROM City c", City.class);
            List<City> cities = query.getResultList();
            for (City city : cities) {
                System.out.println(city.getId() + " " + city.getName());
            }
        } catch (Exception e) {
            System.out.println("Error getting all employees: " + e.getMessage());
        }
    }

    public void create(City city) {
        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            City newCity = new City();
            newCity.setName(city.getName());
            entityManager.getTransaction().begin();
            entityManager.persist(newCity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error creating employee: " + e.getMessage());
        }
    }

    public void update(City city) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(city);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void deleteById(int id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        City cityToDelete = entityManager.find(City.class, id);
        if (cityToDelete != null) {
            entityManager.remove(cityToDelete);
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
