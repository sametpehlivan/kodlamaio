package dataAccess.concretes.hibernate;

import dataAccess.abstracts.ICourseRepository;
import entites.Category;
import entites.Course;
import entites.Teacher;
import ui.Helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class HibernateCourseRepository implements ICourseRepository
{
    private Set<Course> db = Helper.getCourses();
    @Override
    public List<Course> getAll(Predicate<? super Course> filter) throws Exception
    {
        List<Course> result = new ArrayList<>(db.stream().filter(filter).collect(Collectors.toList()));
        if (!(result.size() > 0)) throw new Exception("Not found any Course");
        return result;
    }

    @Override
    public Course getById(int id) throws Exception
    {
        List<Course> result = db.stream().filter(c->c.getId() == id).collect(Collectors.toList());
        if (!(result.size() > 0)) throw new Exception("Not found Course");
        return result.get(0);
    }

    @Override
    public boolean add(Course entity) throws Exception
    {
        if (db.contains(entity)) throw  new Exception("Teacher already exists");
        return db.add(entity);
    }

    @Override
    public boolean remove(Course entity) throws Exception
    {
        if (!db.contains(entity)) throw new Exception("Teacher not found");
        return db.remove(entity);
    }

    @Override
    public boolean update(Course entity) throws Exception
    {
        if (!db.contains(entity)) throw new Exception("Teacher not found");
        db.forEach(t-> {
            if (t.equals(entity))
            {
                t.setName(entity.getName());
                t.setUnitPrice(entity.getUnitPrice());
                t.setTeachers(entity.getTeachers());
            }
        });
        return true;
    }
    @Override
    public boolean containAll(List<Course> courses) {
        return db.containsAll(courses);
    }
}
