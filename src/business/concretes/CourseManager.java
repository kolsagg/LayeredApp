package business.concretes;

import business.abstracts.ICourseManager;
import core.logging.abstracts.ILogger;
import dataAccess.abstracts.ICourseDao;
import entities.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseManager implements ICourseManager {
    private final ICourseDao courseDao;
    private final ILogger[] loggers;
    private static final List<Course> courseList = new ArrayList<>();


    public CourseManager(ICourseDao courseDao, ILogger[] loggers) {
        this.courseDao = courseDao;
        this.loggers = loggers;
    }

    @Override
    public void add(Course course) throws Exception {
        //kontrol algoritması yazılacak
        if (course.getPrice() > 0 && !course.getName().isEmpty()) {//kurs ismi boş olamaz ve fiyatı 0 olamaz
            if (courseList.isEmpty()) { //liste boşsa ekle
                courseList.add(course);
                courseDao.add(course);
            } else {
                for (Course courses: courseList) {
                    if (course.getName().equals(courses.getName())) {
                        throw new Exception("Course already exists.");
                    }
                }
                courseList.add(course);
                courseDao.add(course);
            }
        } else {
            throw new Exception("Course need a name and price above zero.");
        }

        for (ILogger logger : loggers) {
            logger.log(course.getName());
        }
        System.out.println("/---------------------------------------------/");
    }
}
