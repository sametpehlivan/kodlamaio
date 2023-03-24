package ui;

import business.abstracts.ICategoryManager;
import business.abstracts.ICourseManager;
import business.abstracts.ITeacherManager;
import business.concretes.CategoryManager;
import business.concretes.CourseManager;
import business.concretes.TeacherManager;
import core.log.ConsoleLog;
import core.log.DatabaseLog;
import core.log.ILog;
import core.validation.CategoryValidation;
import core.validation.CourseValidation;
import core.validation.IValidation;
import core.validation.TeacherValidation;
import dataAccess.abstracts.ICategoryRepository;
import dataAccess.abstracts.ICourseRepository;
import dataAccess.abstracts.ITeacherRepository;
import dataAccess.concretes.hibernate.HibernateCategoryRepository;
import dataAccess.concretes.hibernate.HibernateCourseRepository;
import dataAccess.concretes.hibernate.HibernateTeacherRepository;
import entites.Category;
import entites.Course;
import entites.Teacher;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception
    {
        List<ILog> loggers = new ArrayList<>();
        loggers.add(new DatabaseLog());
        loggers.add(new ConsoleLog());

        ITeacherRepository teacherRepository = new HibernateTeacherRepository();
        ICourseRepository courseRepository = new HibernateCourseRepository();
        ICategoryRepository categoryRepository = new HibernateCategoryRepository();

        IValidation<Teacher> teacherValidation = new TeacherValidation();
        IValidation<Course> courseValidation = new CourseValidation();
        IValidation<Category> categoryValidation = new CategoryValidation();

        ITeacherManager teacherManager = new TeacherManager(teacherRepository,loggers,teacherValidation);
        ICategoryManager categoryManager = new CategoryManager(categoryRepository,loggers,categoryValidation);
        ICourseManager courseManager = new CourseManager(courseRepository,teacherManager,categoryManager,loggers,courseValidation);


        teacherManager.add(new Teacher("x","y","11111111111"));
        teacherManager.add(new Teacher("k","l","11111111112"));
        teacherManager.add(new Teacher("i","j","11111111113"));
        categoryManager.add(new Category("java"));
        categoryManager.add(new Category("c#"));
        categoryManager.add(new Category("python"));

        List<Teacher> ts = new ArrayList<>();
        List<Category> cs = new ArrayList<>();

        cs.add(categoryManager.getById(2));
        cs.add(categoryManager.getById(1));

        ts.add(teacherManager.getById(1));
        ts.add(teacherManager.getById(2));

        courseManager.add(new Course("null",55.0,cs,ts));
        teacherManager.remove(teacherManager.getById(1));
    }
}