package bc10.shlc;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class Test2 {


    WebDriver driver;

    //Localizadores
    By btnNewComputerLoc = By.xpath("//a[@id='add']");
    By btnCreateComputerLoc = By.xpath("//input[@value='Create this computer']");

    By mensajeErrorLoc = By.xpath("//span[contains(text(),'Failed to refine type : Predicate isEmpty() did no')]");


    @BeforeEach
    void setUp(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.navigate().to("https://computer-database.gatling.io/computers");
    }

    @Test
    void creteUserFailed(){
        WebElement btnNewComputer = driver.findElement(btnNewComputerLoc);
        btnNewComputer.click();
        WebElement btnCreateComputer = driver.findElement(btnCreateComputerLoc);
        btnCreateComputer.click();
        WebElement mensajeError = driver.findElement(mensajeErrorLoc);
        Assertions.assertEquals("Failed to refine type : Predicate isEmpty() did not fail.",mensajeError.getText());
    }

    @AfterEach
    void clean(){
        driver.close();
    }
}
