package bc10.RLLG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Parte2 {
    WebDriver driver;
    By btnAddLocalizador = By.id("add");
    By nombreComputerVacioLocalizador = By.xpath("//span[@class='help-inline'and text()='Failed to refine type : Predicate isEmpty() did not fail.']");
    By btnCreateComputerLocalizador = By.xpath("//input[@class='btn primary']");

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://computer-database.gatling.io/computers");
        driver.manage().deleteAllCookies();
    }
    @Test
    public void test2_1(){
        driver.manage().window().maximize();
        Dimension dimension = driver.manage().window().getSize();
        Assertions.assertEquals(1382,dimension.getWidth());
        Assertions.assertEquals(744,dimension.getHeight());
        WebElement btnAddCompu = driver.findElement(btnAddLocalizador);
        btnAddCompu.click();
        WebElement btnCreateCompu = driver.findElement(btnCreateComputerLocalizador);
        btnCreateCompu.click();
        WebElement compuVacio = driver.findElement(nombreComputerVacioLocalizador);
        Assertions.assertEquals("Failed to refine type : Predicate isEmpty() did not fail.",compuVacio.getText());
    }
    @AfterEach
    void close(){
        driver.close();
    }
}
