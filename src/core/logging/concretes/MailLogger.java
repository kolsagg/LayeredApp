package core.logging.concretes;

import core.logging.abstracts.ILogger;

public class MailLogger implements ILogger {
    @Override
    public void log(String message) {
        System.out.println("Mail send..: " + message);
    }
}
