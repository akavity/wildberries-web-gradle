package org.akavity.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import io.qameta.allure.selenide.LogType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Selenide.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Execution(ExecutionMode.CONCURRENT)
public class BaseTest {
    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle("test_framework");

    @BeforeEach
    public void setUp() {
        startBrowser();
        open(BUNDLE.getString("path_to_url"));
    }

    @AfterEach
    public void tearDown() {
        clearBrowserLocalStorage();
        clearBrowserCookies();
        closeWebDriver();
    }

    private void startBrowser() {
        String startType = System.getProperty("startType", BUNDLE.getString("test.startType"));
        String browser = System.getProperty("browser", BUNDLE.getString("test.browser"));
        String version = System.getProperty("version", BUNDLE.getString("test.version"));

        if ("local".equals(startType)) {
            startLocal();
        } else if ("selenoid".equals(startType)) {
            startSelenoid(browser, version);
        }
    }

    private static void startLocal() {
        SelenideLogger.addListener("allure", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
                .enableLogs(LogType.BROWSER, Level.ALL));
        Configuration.browserSize = "1920x1080";
        Configuration.browser = CHROME;
        Configuration.timeout = 8_000;
    }

    private static void startSelenoid(String browser, String version) {
        SelenideLogger.addListener("allure", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
                .enableLogs(LogType.BROWSER, Level.ALL));
        Configuration.browserSize = "1920x1080";
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.browser = browser;
        Configuration.timeout = 8_000;

        Map<String, Boolean> options = new HashMap<>();
        options.put("enableVNC", true);
        options.put("enableVideo", false);
        options.put("enableLog", true);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browser);
        capabilities.setVersion(version);
        capabilities.setCapability("selenoid:options", options);
        Configuration.browserCapabilities = capabilities;
    }
}
