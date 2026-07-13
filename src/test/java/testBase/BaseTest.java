package testBase;


import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;

import utilities.VideoTraceManager;

public class BaseTest {

    public Playwright playwright;
    public Browser browser;
    public BrowserContext context;
    public Page page;
    public Logger logger;
    public Properties p;
           

    @BeforeClass(groups = { "Sanity", "Regression", "Master" })
    @Parameters({ "os", "browser" })
    public void launchBrowser(String os, String br) throws IOException {

        FileReader file = new FileReader("./src//test//resources//config.properties");
        p = new Properties();
        p.load(file);
        playwright = Playwright.create();
       

            switch (br.toLowerCase()) {
                case "chrome":
                    browser = playwright.chromium()
                            .launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(true));
                    break;
                case "msedge":
                    browser = playwright.chromium()
                            .launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(true));
                    break;
                case "chromium":
                    browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
                    break;
                case "firefox":
                    browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(true));
                    break;
                case "webkit":
                    browser = playwright.webkit().launch(new BrowserType.LaunchOptions().setHeadless(true));
                    break;

                default:
                    System.out.println("invalid browser name");
                    return;
            }
        }


    @AfterClass(groups = { "Sanity", "Regression", "Master" })
    public void closeBrowser() {
        playwright.close();
    }

    @BeforeMethod(groups = { "Sanity", "Regression", "Master" })
    public void createContextAndPage()  {
        logger = LogManager.getLogger(this.getClass());
        context = browser.newContext(new Browser.NewContextOptions()
                .setRecordVideoDir(Paths.get("videos"))
                .setRecordVideoSize(1280, 720));
        context.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(true));
        page = context.newPage();
        page.navigate(p.getProperty("appURL"));
    }

    @AfterMethod(groups = { "Sanity", "Regression", "Master" })
    public void closeContext(ITestResult result) throws IOException {
        String testname = result.getName();
        String tracefile = "traces" + testname + ".zip";
        context.tracing().stop(new Tracing.StopOptions().setPath(Paths.get(tracefile)));
        VideoTraceManager.setTracePath(tracefile);
        page.close();
        Path video = page.video().path();
        VideoTraceManager.setVideoPath(video.toString());
        if (result.getStatus() == ITestResult.SUCCESS) {
            Files.deleteIfExists(video);
            Files.deleteIfExists(Paths.get(tracefile));

        }
        context.close();
    }

    public String randomString() {
        String generatedString = RandomStringUtils.randomAlphanumeric(8);
        return generatedString;
    }

    public String randomNumber() {
        String generatedNumber = RandomStringUtils.randomNumeric(10);
        return generatedNumber;
    }

    public String randomAlphaNumaricString() {
        String generatedAlphaNumaric = RandomStringUtils.randomAlphabetic(3) + RandomStringUtils.randomNumeric(3);
        return generatedAlphaNumaric;
    }
}
