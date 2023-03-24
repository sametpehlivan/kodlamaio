package dataAccess.concretes.hibernate;

import dataAccess.abstracts.ICategoryRepository;
import entites.Category;
import ui.Helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class HibernateCategoryRepository implements ICategoryRepository
{

    private Set<Category> db = Helper.getCategories();
    @Override
    public List<Category> getAll(Predicate<? super Category> filter) throws Exception
    {
        List<Category> result = new  ArrayList<>(db.stream()
                                                        .filter(filter)
                                                        .collect(Collectors.toList()));
        if (!(result.size() > 0)) throw new Exception("Not found any Category");
        return result;
    }

    @Override
    public Category getById(int id) throws Exception
    {

        List<Category> result = new  ArrayList<>(db.stream()
                                                        .filter(category -> category.getId() == id)
                                                        .collect(Collectors.toList()));
        if (!(result.size() > 0)) throw new Exception("Not found Category");
        return result.get(0);
    }

    @Override
    public boolean add(Category entity) throws Exception
    {
        if (db.contains(entity)) throw  new Exception("Category already exists");
        return db.add(entity);
    }

    @Override
    public boolean remove(Category entity) throws Exception
    {
        if (!db.contains(entity)) throw new Exception("Category not found");
        return db.remove(entity);
    }

    @Override
    public boolean update(Category entity) throws Exception
    {
        if (!db.contains(entity)) throw new Exception("Category not found");
        db.forEach(t-> {
            if (t.equals(entity))
            {
                t.setName(entity.getName());
            }
        });
        return true;
    }

    @Override
    public boolean containAll(List<Category> categories)
    {
        return db.containsAll(categories);
    }
}
