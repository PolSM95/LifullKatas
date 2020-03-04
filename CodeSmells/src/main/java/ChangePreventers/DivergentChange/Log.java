package ChangePreventers.DivergentChange;

import java.util.List;

public class Log {
    public List<String> Log;

    public Log() {
    }

    void loginfo(String info) {
        Log.add("INFO: " + info);
    }

    void logWarning(String warning) {
        Log.add("WARNING: " + warning);
    }

    void logError(String errorMessage) {
        Log.add("ERROR: " + errorMessage);
    }
}