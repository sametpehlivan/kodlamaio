package business.concretes;

import business.abstracts.ITeacherManager;
import core.log.ILog;
import core.validation.IValidation;
import dataAccess.abstracts.ICourseRepository;
import dataAccess.abstracts.ITeacherRepository;
import entites.Course;
import entites.Teacher;

import java.util.List;
import java.util.function.Predicate;

public class TeacherManager implements ITeacherManager
{
    private ITeacherRepository repository;
    private List<ILog> loggers;
    private IValidation<Teacher> validation;
    public TeacherManager(ITeacherRepository repository,List<ILog> loggers,IValidation<Teacher> validation )
    {
        this.repository = repository;
        this.loggers = loggers;
        this.validation = validation;
    }
    @Override
    public List<Teacher> getAll(Predicate<? super Teacher> filter) throws Exception
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
    public Teacher getById(int id) throws Exception
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
    public boolean add(Teacher entity) throws Exception
    {
        try
        {
            validation.validate(entity);
            return repository.add(entity);
        }catch (Exception e)
        {
            loggers.forEach(logger -> logger.log(e.getMessage()));
            throw e;
        }
    }

    @Override
    public boolean remove(Teacher entity) throws Exception
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
    public boolean update(Teacher entity) throws Exception
    {
        try
        {
            validation.validate(entity);
            return repository.add(entity);
        }catch (Exception e)
        {
            loggers.forEach(logger -> logger.log(e.getMessage()));
            throw e;
        }
    }
    @Override
    public boolean containAll(List<Teacher> entities)
    {
        return repository.containAll(entities);
    }
}
