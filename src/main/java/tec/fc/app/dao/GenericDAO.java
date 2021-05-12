package tec.fc.app.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDAO<T, ID extends Integer> {

    List<T> findAll();

    T findById(ID id);

    void save(T t);

    void update(T t);

    void delete(ID id);
}
