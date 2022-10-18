package bc10.lcabral.webElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;


import java.time.Duration;

public class Waits {

    WebDriver driver;

    //Localizadores
    By linkloc = By.xpath("//a[text()='Example 1: Element on page that is hidden']");

    By btnStartLoc = By.xpath("//div/button[text()='Start']");

    By helloAsinLoc = By.xpath("//h4[text()='Hello World!']");



    @BeforeEach
    void setUp(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        // waits :: implicit = Va intentar encontrar el elemneto si es que no esta avilitado
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
    }

    @Test
    void waits(){
        driver.navigate().to("https://the-internet.herokuapp.com/dynamic_loading");
        WebElement link1 = driver.findElement(linkloc);
        link1.click();
        WebElement btnStart = driver.findElement(btnStartLoc);
        btnStart.click();
        //WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        //espera explicita de un webelemnt

        //Fluent wait
        Wait<WebDriver> fluentwait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(100)).ignoring((NoSuchElementException.class));



        fluentwait.until(ExpectedConditions.elementToBeClickable(helloAsinLoc));
        Assertions.assertEquals("Hello World!", driver.findElement(helloAsinLoc).getText());
    }

    @AfterEach
    void clean(){
        driver.close();
    }
}

