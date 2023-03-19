package core.logging.concretes;

import core.logging.abstracts.ILogger;

public class FileLogger implements ILogger {
    @Override
    public void log(String message) {
        System.out.println("Logged to file: " + message);
    }
}
