package backendWeek4;

interface Logger { // Interface with two void methods
    void log(String inString);
    void error(String inString);
}

// Implementing AsteriskLogger
class AsteriskLogger implements Logger {
    @Override
    public void log(String inString) {
        System.out.println("***" + inString + "***");
    }

    @Override
    public void error(String inString) {
        String outString = "***Error: " + inString + "***";
        String border = "*".repeat(outString.length()); // Creates a border of asterisks the same length as the error message

        System.out.println(border);
        System.out.println(outString);
        System.out.println(border);
    }
}

// Implementing SpacedLogger
class SpacedLogger implements Logger {
    @Override
    public void log(String inString) {
        System.out.println(addSpaces(inString));
    }

    @Override
    public void error(String inString) {
        System.out.println("ERROR: " + addSpaces(inString));
    }

    private String addSpaces(String message) {
        StringBuilder spacedMessage = new StringBuilder();
        for (char c : message.toCharArray()) {
            spacedMessage.append(c).append(' ');
        }
        return spacedMessage.toString().trim();
    }
}

// Main application class
public class App {
    public static void main(String[] args) {
        Logger asteriskLogger = new AsteriskLogger();
        Logger spacedLogger = new SpacedLogger();

        System.out.println("AsteriskLogger test prints:");
        asteriskLogger.log("Testing base");
        asteriskLogger.error("Error print test");

        System.out.println("\nSpacedLogger test prints:");
        spacedLogger.log("Testing base");
        spacedLogger.error("Error print test");
    }
}
