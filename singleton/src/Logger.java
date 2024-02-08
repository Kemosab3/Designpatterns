import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
    private static Logger instance;
    private PrintWriter writer;
    private String fileName;

    private Logger() {
        fileName = "log.txt"; // Default file name
        try {
            writer = new PrintWriter(new FileWriter(fileName, true));
        } catch (IOException e) {
            System.err.println("Error creating logger: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public synchronized void setFileName(String fileName) {
        if (writer != null) {
            writer.close();
        }
        this.fileName = fileName;
        try {
            writer = new PrintWriter(new FileWriter(fileName, true));
        } catch (IOException e) {
            System.err.println("Error setting file name: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public synchronized void write(String message) {
        if (writer != null) {
            writer.println(message);
            writer.flush();
        } else {
            System.err.println("Logger is not initialized.");
        }
    }

    public synchronized void close() {
        if (writer != null) {
            writer.close();
        } else {
            System.err.println("Logger is not initialized.");
        }
    }
}
