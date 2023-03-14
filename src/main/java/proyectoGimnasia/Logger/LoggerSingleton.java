package proyectoGimnasia.Logger;

import java.io.IOException;
import java.util.logging.*;

public class LoggerSingleton {

    private static LoggerSingleton instance = null;
    private static final String LOG_FILE = "logs.txt";
    private static final Logger LOGGER = Logger.getLogger(LoggerSingleton.class.getName());

    private LoggerSingleton() throws IOException {
        FileHandler fileHandler = new FileHandler(LOG_FILE, true);
        SimpleFormatter formatter = new SimpleFormatter();
        fileHandler.setFormatter(formatter);
        LOGGER.addHandler(fileHandler);
        LOGGER.setLevel(Level.INFO);
    }

    public static LoggerSingleton getInstance() throws IOException {
        if (instance == null) {
            instance = new LoggerSingleton();
        }
        return instance;
    }

    public void logger(String message) {
        LOGGER.log(Level.INFO, message);
    }
}
