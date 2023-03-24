package core.validation;

import entites.Course;
import entites.Teacher;

import java.util.List;


public class TeacherValidation implements IValidation<Teacher>
{
    @Override
    public void validate(Teacher data) throws Exception
    {
        if (data.getName() == null || data.getName().isEmpty()) throw new Exception("course name should not be empty");
        if (data.getIdentityNumber() == null || data.getIdentityNumber().isEmpty()) throw new Exception("course identity number(T.C. NO) should not be empty");
    }
    @Override
    public void validateAll(List<Teacher> data) throws Exception
    {
        for (Teacher teacher : data) validate(teacher);
    }
}
