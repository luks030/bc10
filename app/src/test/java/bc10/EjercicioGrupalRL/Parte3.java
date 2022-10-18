package bc10.EjercicioGrupalRL;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Parte3 {
    WebDriver driver;
    @FindBy(id = "add")
    WebElement btnAdd;
    @FindBy(name = "name")
    WebElement nombre;
    @FindBy(name = "introduced")
    WebElement introducir;
    @FindBy(name = "discontinued")
    WebElement descontinuado;
    @FindBy(name = "company")
    WebElement compania;
    @FindBy(xpath = "//input[@class='btn primary']")
    WebElement btnCreateComputer;
    @FindBy(xpath = "//strong[normalize-space()='Done !']")
    WebElement confirmacion;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://computer-database.gatling.io/computers");
        driver.manage().deleteAllCookies();
        PageFactory.initElements(driver, this);
    }
    @Test
    public void test2_2(){
        btnAdd.click();
        driver.manage().window().maximize();
        nombre.sendKeys("BC10_RL");
        introducir.sendKeys("1988-01-10");
        descontinuado.sendKeys("2022-10-18");
        Select company = new Select(compania);
        company.selectByVisibleText("Nintendo");
        btnCreateComputer.click();
        Assertions.assertEquals("Done !",confirmacion.getText());
    }
    @AfterEach
    void close(){
        driver.close();
    }
}
