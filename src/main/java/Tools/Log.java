package Tools;

import org.apache.log4j.*;
import org.apache.log4j.FileAppender;

public class Log {
    private static Logger logger = Logger.getLogger(Log.class);

    //setupLogger: this method holds the logger setup
    //             exists to keep main clean
    public static void setupLogger() {
        logger.setLevel(Level.DEBUG);
        FileAppender fa = new FileAppender();
        fa.setFile("debug.txt");
        fa.setLayout(new SimpleLayout());
        logger.addAppender(fa);
        fa.activateOptions();

        System.out.println(logger.getLevel());
    }

    //LoggerMethods
    //logMessage: this method takes a log level and a message to log to debug.txt
    public static void logMessage(String logType, String message) {

        switch (logType.toLowerCase()){
            case "debug":
                logger.debug(message);
                break;
            case"info":
                logger.info(message);
                break;
            case"warn":
                logger.warn(message);
                break;
            case"error":
                logger.error(message);
                break;
            case"fatal":
                logger.fatal(message);
                break;
        }
    }

    //logDash: creates a clear break in the debug file for readability
    public static void logDash() {
        logger.debug("----------------------------------------------------------");
    }


}
