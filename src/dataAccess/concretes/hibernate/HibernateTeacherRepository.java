package dataAccess.concretes.hibernate;

import dataAccess.abstracts.ITeacherRepository;
import entites.Category;
import entites.Course;
import entites.Teacher;
import ui.Helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class HibernateTeacherRepository implements ITeacherRepository
{
    private Set<Teacher> db = Helper.getTeachers();
    @Override
    public List<Teacher> getAll(Predicate<? super Teacher> filter) throws Exception
    {
        List<Teacher> result = new ArrayList<>(db.stream().filter(filter).collect(Collectors.toList()));
        if (!(result.size() > 0)) throw new Exception("Not found any Teacher");
        return result;
    }

    @Override
    public Teacher getById(int id) throws Exception
    {
        List<Teacher> result = db.stream().filter(c->c.getId() == id).collect(Collectors.toList());
        if (!(result.size() > 0)) throw new Exception("Not found Teacher");
        return result.get(0);
    }

    @Override
    public boolean add(Teacher entity) throws Exception
    {
        if (db.contains(entity)) throw  new Exception("Teacher already exists");
        return db.add(entity);
    }

    @Override
    public boolean remove(Teacher entity) throws Exception
    {
        if (!db.contains(entity)) throw new Exception("Teacher not found");
        return db.remove(entity);
    }

    @Override
    public boolean update(Teacher entity) throws Exception
    {
        if (!db.contains(entity)) throw new Exception("Teacher not found");
        db.forEach(t-> {
            if (t.equals(entity))
            {
                t.setName(entity.getName());
                t.setIdentityNumber(entity.getIdentityNumber());
                t.setSurname(entity.getSurname());
            }
        });
        return true;
    }
    @Override
    public boolean containAll(List<Teacher> teachers) {
        return db.containsAll(teachers);
    }
}
