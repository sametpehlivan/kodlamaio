package ui;

import entites.Category;
import entites.Course;
import entites.Teacher;


import java.util.HashSet;
import java.util.Set;

public class Helper
{
    private static final Set<Teacher> teachers = new HashSet<>();
    private static final Set<Course>  courses = new HashSet<>();
    private static final Set<Category>  categories = new HashSet<>();

    public static Set<Teacher> getTeachers() {
        return teachers;
    }
    public static Set<Course> getCourses()
    {
        return courses;
    }
    public static Set<Category> getCategories()
    {
        return categories;
    }
}
