import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;

import java.time.Duration;

public class BaseTest {
    protected static WebDriver driver;
    protected static MainPage mainPage;
    @BeforeAll
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        WebElement cookieAcceptButton = driver.findElement(By.id("cookie-agree"));
        cookieAcceptButton.click();
        mainPage = new MainPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @AfterAll
    public static void tearDown() {
        driver.quit();
    }
}
