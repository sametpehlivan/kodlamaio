package dataAccess.abstracts;

import entites.BaseEntity;
import entites.Teacher;

import java.util.List;
import java.util.function.Predicate;

public interface IRepository<T extends BaseEntity>
{
    List<T> getAll(Predicate<? super T> filter) throws Exception;
    T getById(int id) throws Exception;
    boolean add(T entity) throws Exception;
    boolean remove(T entity) throws Exception;
    boolean update(T entity) throws Exception;
    boolean containAll(List<T> entities);
}
