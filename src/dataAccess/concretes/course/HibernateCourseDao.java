package dataAccess.concretes.course;

import dataAccess.abstracts.ICourseDao;
import entities.Course;

public class HibernateCourseDao implements ICourseDao {
    @Override
    public void add(Course course) {
        System.out.println("Course added with Hibernate.");
    }
}
