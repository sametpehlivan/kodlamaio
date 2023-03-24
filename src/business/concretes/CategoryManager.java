package business.concretes;

import business.abstracts.ICategoryManager;
import core.log.ILog;
import core.validation.IValidation;
import dataAccess.abstracts.ICategoryRepository;
import entites.Category;

import java.util.List;
import java.util.function.Predicate;

public class CategoryManager implements ICategoryManager
{
    private ICategoryRepository repository;
    private List<ILog> loggers;
    private IValidation<Category> validation;
    public CategoryManager(ICategoryRepository repository,List<ILog> loggers,IValidation<Category> validation )
    {
        this.repository = repository;
        this.loggers = loggers;
        this.validation = validation;
    }
    @Override
    public List<Category> getAll(Predicate<? super Category> filter) throws Exception
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
    public Category getById(int id) throws Exception
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
    public boolean add(Category entity) throws Exception
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
    public boolean remove(Category entity) throws Exception
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
    public boolean update(Category entity) throws Exception
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
    public boolean containAll(List<Category> entities)
    {
        return repository.containAll(entities);
    }
}
