package tec.fc.app.service;

import tec.fc.app.domain.Entity;

import java.util.List;

public interface GenericService<T> {

    List<Entity> getAll();

    T getById(Integer id);

    void addNew(T t);

    void update(T t);

    void delete(Integer id);
}
