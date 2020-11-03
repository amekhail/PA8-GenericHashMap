import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        testCases.class
            })
// The main class to be executed; this is the entry point for your tests
public class test {
    public static void main(String[] args) {
        JUnitCore runner = new JUnitCore();
        // Attach a listener for JSON output

        // Run the test suite defined within this class
        @SuppressWarnings("unused")
		Result r = runner.run(test.class);
    }
}