package core.validation;

import entites.Category;
import entites.Course;

import java.util.List;

public class CourseValidation implements IValidation<Course>
{
    @Override
    public void validate(Course data) throws Exception
    {
            if (!(data.getUnitPrice() > 0)) throw new Exception("course unit price greater than 0");
            if (data.getName() == null || data.getName().isEmpty()) throw new Exception("course must be the name.");
            if (data.getTeachers() == null || data.getTeachers().isEmpty()) throw new Exception("must have at least one teacher");
            if (data.getCategories() == null || data.getCategories().isEmpty()) throw new Exception("must have at least one teacher");
    }
    @Override
    public void validateAll(List<Course> data) throws Exception
    {
        for (Course course : data) validate(course);
    }
}
