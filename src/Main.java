import business.concretes.CategoryManager;
import business.concretes.CourseManager;
import business.concretes.InstructorManager;
import core.logging.abstracts.ILogger;
import core.logging.concretes.FileLogger;
import core.logging.concretes.MailLogger;
import dataAccess.concretes.category.HibernateCategoryDao;
import dataAccess.concretes.category.JdbcCategoryDao;
import dataAccess.concretes.course.HibernateCourseDao;
import dataAccess.concretes.course.JdbcCourseDao;
import dataAccess.concretes.instructor.HibernateInstructorDao;
import dataAccess.concretes.instructor.JdbcInstructorDao;
import entities.Category;
import entities.Course;
import entities.Instructor;


public class Main {
    public static void main(String[] args) throws Exception {
        //Define logger array
        ILogger[] loggers = {new FileLogger(), new MailLogger()};
        //Define Instructors
        Instructor instructor1 = new Instructor(1, "Emre Kolunsağ");
        Instructor instructor2 = new Instructor(2, "Osman Emir Mesut");
        //Define Instructor Managers
        InstructorManager instructorManagerJdbc = new InstructorManager(new JdbcInstructorDao(),loggers);
        InstructorManager instructorManagerHibernate = new InstructorManager(new HibernateInstructorDao(),loggers);
        //Add Instructors
        instructorManagerHibernate.add(instructor1);
        instructorManagerJdbc.add(instructor2);
        //Define Categories
        Category category1 = new Category("OOP");
        Category category2 = new Category("Data");
        //Define Category Managers
        CategoryManager categoryManagerJdbc = new CategoryManager(new JdbcCategoryDao(), loggers);
        CategoryManager categoryManagerHibernate = new CategoryManager(new HibernateCategoryDao(), loggers);
        //Add Categories
        categoryManagerJdbc.add(category1);
        categoryManagerHibernate.add(category2);
        //Define Courses
        Course course1 = new Course("Java 2023", 69);
        Course course2 = new Course("Data Structures", 69);
        Course course3 = new Course(".Net", 69);
        //Define Course Managers
        CourseManager courseManagerJdbc = new CourseManager(new JdbcCourseDao(), loggers);
        CourseManager courseManagerHibernate = new CourseManager(new HibernateCourseDao(), loggers);
        //Add Courses
        courseManagerJdbc.add(course1);
        courseManagerHibernate.add(course2);
        courseManagerJdbc.add(course3);

    }
}