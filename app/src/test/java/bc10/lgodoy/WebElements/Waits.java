package bc10.lgodoy.WebElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class Waits {
    WebDriver driver;
    By link1Loc =By.xpath("//a[text()='Example 1: Element on page that is hidden']");
    By btnStarLoc = By.xpath("//button[normalize-space()='Start']");
    By helloAsinLoc = By.xpath("//h4[text()='Hello World!']" );

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        //waits::implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(500));
    }
    @Test
    public void waits(){
        driver.navigate().to("https://the-internet.herokuapp.com/dynamic_loading");
        WebElement link1 = driver.findElement(link1Loc);
        link1.click();
        WebElement btnStar = driver.findElement(btnStarLoc);
        btnStar.click();
        //Espera de elemento web explicit
        //WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.elementToBeClickable(helloAsinLoc));
        //fluent wait
        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(2))
                        .pollingEvery(Duration.ofMillis(100))
                                .ignoring(NoSuchElementException.class);
        Assertions.assertEquals("Hello World",driver.findElement(helloAsinLoc).getText());

    }


    @AfterEach
    void cierre(){
        driver.close();
    }
}
