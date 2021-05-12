package tec.fc.app.dao;

import tec.fc.app.domain.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public abstract class GenericDAOImpl<T extends Entity, ID extends Integer> implements GenericDAO<T,ID> {

    protected ArrayList<T> table;
    protected Class<T> clazz;

    public GenericDAOImpl(ArrayList<T> table, Class<T> clazz) {
        Objects.requireNonNull(table);
        Objects.requireNonNull(clazz);
        this.table = table;
        this.clazz = clazz;
    }

    @Override
    public List<T> findAll() {
        return table;
    }

    @Override
    public Optional<T> findById(ID id) {
//        for (T tClass : table){
//            if (tClass.getId() == id)
//        }
        return Optional.empty();
    }

    @Override
    public void save(T t) {

    }

    @Override
    public void update(T t) {

    }

    @Override
    public void delete(ID id) {

    }


}
