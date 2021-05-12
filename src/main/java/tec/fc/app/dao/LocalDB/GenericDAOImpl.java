package tec.fc.app.dao.LocalDB;

import tec.fc.app.dao.GenericDAO;
import tec.fc.app.domain.Entity;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


public abstract class GenericDAOImpl<T extends Entity, ID extends Integer> implements GenericDAO<T,ID> {

    protected ArrayList<T> table;

    public GenericDAOImpl(ArrayList<T> table) {
        Objects.requireNonNull(table);
        this.table = table;
    }

    @Override
    public List<T> findAll() {
        return this.table;
    }

    @Override
    public T findById(ID id) {
        for (T t : this.table){
            if (t.getId() == id){
                return t;
            }
        }
        return null;
    }

    @Override
    public void save(T t) {
        this.table.add(t);
    }

    @Override
    public void update(T t) {
        this.table.remove(this.findById((ID) t.getId()));
        this.table.add(t);
    }

    @Override
    public void delete(ID id) {
        table.remove(this.findById(id));
    }
}
