package mp.g17.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.logging.*;

public class LoggerUtils {
    private static Logger LOGGER;

    public static Logger getLogger() {// Constructor for the logger
        if (LOGGER == null) {
            setupLogger();
        }
        return LOGGER;
    }

    private static void setupLogger() {
        //LogManager.getLogManager().reset();
        LOGGER = Logger.getLogger("");
        // Set better logging format.
        StreamHandler handler = new StreamHandler(System.out, new Formatter() {
            private static final String LOGGER_FORMAT = "[%1$tY-%1$tm-%1$td %1$tl:%1$tM:%1$tS] %4$s %3$s: %5$s%6$s%n";

            @Override
            public String format(LogRecord record) { //This method is used to have a better way for return messages
                Date date = new Date(record.getMillis());
                String source;
                if (record.getSourceClassName() != null) {
                    source = record.getSourceClassName();
                    if (record.getSourceMethodName() != null) {
                        source += " " + record.getSourceMethodName();
                    }
                } else {
                    source = record.getLoggerName();
                }
                String message = formatMessage(record);
                String throwable = "";
                if (record.getThrown() != null) {
                    StringWriter sw = new StringWriter();
                    PrintWriter pw = new PrintWriter(sw);
                    pw.println();
                    record.getThrown().printStackTrace(pw);
                    pw.close();
                    throwable = sw.toString();
                }
                return String.format(LOGGER_FORMAT,
                        date,
                        source,
                        record.getLoggerName(),
                        record.getLevel().getName(),
                        message,
                        throwable);
            }
        });

        for (Handler loggerHandler : LOGGER.getHandlers()) {
            LOGGER.removeHandler(loggerHandler);
        }

        LOGGER.setLevel(Level.ALL);
        handler.setLevel(Level.ALL);

        LOGGER.addHandler(handler);
    }
}
