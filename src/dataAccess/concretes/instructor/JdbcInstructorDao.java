package dataAccess.concretes.instructor;

import dataAccess.abstracts.IInstructorDao;
import entities.Instructor;

public class JdbcInstructorDao implements IInstructorDao {
    @Override
    public void add(Instructor instructor) {
        System.out.println("Instructor added with JDBC.");
    }
}
