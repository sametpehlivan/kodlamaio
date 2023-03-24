package core.validation;

import entites.Category;

import java.util.List;

public class CategoryValidation implements IValidation<Category>
{
    @Override
    public void validate(Category data) throws Exception
    {
        if (data.getName() == null || data.getName().isEmpty()) throw new Exception("course must be the name.");
    }

    @Override
    public void validateAll(List<Category> data) throws Exception
    {
        for (Category category: data) validate(category);
    }

}
