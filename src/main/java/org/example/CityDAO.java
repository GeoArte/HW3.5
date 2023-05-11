package org.example;

import javax.persistence.EntityManager;
import java.util.List;

public interface CityDAO {

    void getById(int id);

    void getAll();

    void create(City city);

    void update(City city);

    void deleteById(int id);
    City returnCityById(int id);
}
