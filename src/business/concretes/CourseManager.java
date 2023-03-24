package business.concretes;

import business.abstracts.ICategoryManager;
import business.abstracts.ICourseManager;
import business.abstracts.ITeacherManager;
import core.log.ILog;
import core.validation.IValidation;
import dataAccess.abstracts.ICourseRepository;
import entites.Category;
import entites.Course;
import entites.Teacher;

import java.util.List;
import java.util.function.Predicate;

public class CourseManager implements ICourseManager
{
    private ICourseRepository repository;
    private List<ILog> loggers;
    private IValidation<Course> courseValidation;
    private ITeacherManager teacherManager;
    private ICategoryManager categoryManager;
    private IValidation<Teacher> teacherValidation;
    private IValidation<Category> categoryValidation;
    //going to constructor hell :)
    public CourseManager(ICourseRepository repository,
                         ITeacherManager teacherManager,
                         ICategoryManager categoryManager,
                         List<ILog> loggers,
                         IValidation<Course> courseValidation
                         )
    {
        this.repository = repository;
        this.loggers = loggers;
        this.courseValidation = courseValidation;
        this.teacherManager = teacherManager;
        this.categoryManager = categoryManager;
    }
    @Override
    public List<Course> getAll(Predicate<? super Course> filter) throws Exception
    {
        try
        {
            return repository.getAll(filter);
        }
        catch (Exception e)
        {
            loggers.forEach(logger -> logger.log(e.getMessage()));
            throw e;
        }
    }

    @Override
    public Course getById(int id) throws Exception
    {
        try
        {
            return repository.getById(id);
        }
        catch (Exception e)
        {
            loggers.forEach(logger -> logger.log(e.getMessage()));
            throw e;
        }
    }

    @Override
    public boolean add(Course entity) throws Exception
    {
        try
        {
            courseValidation.validate(entity);
            if (!teacherManager.containAll(entity.getTeachers())) throw new Exception("contains undefined teacher");
            if (!categoryManager.containAll(entity.getCategories())) throw new Exception("contains undefined category");
            return repository.add(entity);
        }catch (Exception e)
        {
            loggers.forEach(logger -> logger.log(e.getMessage()));
            throw e;
        }
    }

    @Override
    public boolean remove(Course entity) throws Exception
    {
        try
        {
            return repository.remove(entity);
        }catch (Exception e)
        {
            loggers.forEach(logger -> logger.log(e.getMessage()));
            throw e;
        }
    }

    @Override
    public boolean update(Course entity) throws Exception
    {
        try
        {
            courseValidation.validate(entity);
            if (!teacherManager.containAll(entity.getTeachers())) throw new Exception("contains undefined teacher");
            if (!categoryManager.containAll(entity.getCategories())) throw new Exception("contains undefined category");
            return repository.add(entity);
        }catch (Exception e)
        {
            loggers.forEach(logger -> logger.log(e.getMessage()));
            throw e;
        }
    }
    @Override
    public boolean containAll(List<Course> entities)
    {
        return repository.containAll(entities);
    }
}
