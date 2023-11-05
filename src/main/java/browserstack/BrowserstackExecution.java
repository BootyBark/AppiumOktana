package browserstack;

import io.appium.java_client.AppiumDriver;
import org.driver.MobileDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.ITestResult;

import java.io.InputStream;
import java.util.Properties;

public class BrowserstackExecution {
    private static Properties properties;

    public static void setTestCaseName(AppiumDriver driver, String testName) {
        properties = new Properties();
        try {
            InputStream input = MobileDriver.class.getClassLoader().getResourceAsStream("application.properties");
            properties.load(input);
        } catch (Exception ignored) {
        }
        boolean browserstackExecution = Boolean.parseBoolean(properties.getProperty("browserstack.execution"));

        if (browserstackExecution) {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript(
                    "browserstack_executor: {"
                            + "\"action\": "
                            + "\"setSessionName\", "
                            + "\"arguments\": {"
                            + "\"name\":"
                            + "\""
                            + testName
                            + "\" }}");
        }
    }

    public static void setTestCaseStatus(AppiumDriver driver, ITestResult result) {
        properties = new Properties();
        try {
            InputStream input = MobileDriver.class.getClassLoader().getResourceAsStream("application.properties");
            properties.load(input);
        } catch (Exception ignored) {
        }
        boolean browserstackExecution = Boolean.parseBoolean(properties.getProperty("browserstack.execution"));

        if (browserstackExecution) {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            if (result.isSuccess()) {
                jse.executeScript(
                        "browserstack_executor: {"
                                + "\"action\": "
                                + "\"setSessionStatus\", "
                                + "\"arguments\": {"
                                + "\"status\": "
                                + "\"passed\", "
                                + "\"reason\": "
                                + "\"Successful test case!\"}}");
            } else {
                jse.executeScript(
                        "browserstack_executor: {"
                                + "\"action\": "
                                + "\"setSessionStatus\", "
                                + "\"arguments\": {"
                                + "\"status\": "
                                + "\"failed\", "
                                + "\"reason\": "
                                + "\"" + result.getThrowable().toString().replaceAll("[\n\t]","").replaceAll("\"", "'") + "\"}}");
            }
        }
    }

}
