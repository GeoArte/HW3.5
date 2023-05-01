package org.example;

import javax.persistence.EntityManager;
import java.util.List;

public interface CityDAO {

    City getById(int id);

    void getAll();

    void create(City city);

    void update(City city);

    void deleteById(int id);
}
