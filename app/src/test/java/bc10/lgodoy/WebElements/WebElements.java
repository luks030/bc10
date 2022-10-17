package bc10.lgodoy.WebElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;


public class WebElements {
    WebDriver driver;
    //localizadores
    @FindBy(name = "q")
            WebElement barraGoogle;
    @FindBy(name = "btnK")
            WebElement botonBuscarGoogle;
    @BeforeEach
    void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        PageFactory.initElements(driver, this);
    }
    @Test
    void busquedaGoogle(){
        //con WebElement capturamos el elemento, atravez de sus atributos
        barraGoogle.sendKeys("Tsoft");
        barraGoogle.sendKeys(Keys.ESCAPE);
        botonBuscarGoogle.click();
        Assertions.assertEquals("Tsoft - Buscar con Google",driver.getTitle());
    }
    @AfterEach
    void close(){
        driver.close();
    }
}
