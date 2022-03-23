import Tools.Log;
import org.junit.jupiter.api.Test;

public class logMessageTest {

    @Test
    public void testLogMessageDoesNotThrowAnException() {
        //This is not a JUNIT Test it is simply a test that prints to the logger if it is working or not
        Log.setupLogger();
        Log.logMessage("Debug", "This is a test to see if the logger is working");
        Log.logDash();
        Log.logMessage("Info", "does it work twice in a row");
    }


}
