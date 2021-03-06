package com.revature.Repository;

import java.util.List;

public interface DAO<T> {

    void create(T t);

    T getById(int id);

    List<T> getAll();

    void update(T t);

    void deleteById(int id);
}
