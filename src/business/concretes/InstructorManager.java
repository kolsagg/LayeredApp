package business.concretes;

import business.abstracts.IInstructorManager;
import core.logging.abstracts.ILogger;
import dataAccess.abstracts.IInstructorDao;
import entities.Instructor;

import java.util.ArrayList;
import java.util.List;

public class InstructorManager implements IInstructorManager {
    private final IInstructorDao instructorDao;
    private final ILogger[] loggers;
    private static final List<Instructor> instructorList = new ArrayList<>();

    public InstructorManager(IInstructorDao instructorDao, ILogger[] loggers) {
        this.instructorDao = instructorDao;
        this.loggers = loggers;
    }

    @Override
    public void add(Instructor instructor) throws Exception {
        //kontrol algoritması yazılacak
        if (instructorList.isEmpty()) {
            instructorList.add(instructor);
            instructorDao.add(instructor);
        } else {
            for (Instructor instructors : instructorList) {
                if (instructor.getName().equals(instructors.getName())) {
                    throw new Exception("Instructor is already exists.");
                }
            }
            instructorList.add(instructor);
            instructorDao.add(instructor);
        }


        for (ILogger logger : loggers) {
            logger.log(instructor.getName());
        }
        System.out.println("/---------------------------------------------/");
    }
}
