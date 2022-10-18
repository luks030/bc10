package bc10.EjercicioGrupalRL;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Parte2 {
    WebDriver driver;
    @FindBy(id = "add")
    WebElement btnAdd;
    @FindBy(xpath = "//span[@class='help-inline'and text()='Failed to refine type : Predicate isEmpty() did not fail.']")
    WebElement nombreComputerVacio;
    @FindBy(xpath = "//input[@class='btn primary']")
    WebElement btnCreateComputer;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://computer-database.gatling.io/computers");
        driver.manage().deleteAllCookies();
        PageFactory.initElements(driver, this);
    }
    @Test
    public void test2_1(){
        driver.manage().window().maximize();
        Dimension dimension = driver.manage().window().getSize();
        Assertions.assertEquals(1382,dimension.getWidth());
        Assertions.assertEquals(744,dimension.getHeight());
        btnAdd.click();
        btnCreateComputer.click();
        Assertions.assertEquals("Failed to refine type : Predicate isEmpty() did not fail.",nombreComputerVacio.getText());
    }
    @AfterEach
    void close(){
        driver.close();
    }
}
