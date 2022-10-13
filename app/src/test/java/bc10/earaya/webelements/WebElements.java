package bc10.earaya.webelements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebElements {
    WebDriver driver;
    //Localizadores
    By barraBusquedaLocalizador = By.name("q");
    By btnBuscarConGoogleLocalizador = By.name("btnK");

    @BeforeEach
    void setUp(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @Test
    void busquedaGoogle() throws InterruptedException {

        driver.get("https://www.google.com");
        //Con WebElement capturamos el elemento, a traves de sus atributos
        WebElement barraBusqueda = driver.findElement(barraBusquedaLocalizador);
        barraBusqueda.clear();
        barraBusqueda.sendKeys("Tsoft");
        barraBusqueda.sendKeys(Keys.ESCAPE);
        Thread.sleep(500);
        WebElement btnBuscarConGoogle = driver.findElement(btnBuscarConGoogleLocalizador);
        btnBuscarConGoogle.click();
        Assertions.assertEquals("Tsoft - Buscar con Google",driver.getTitle());
    }

    @AfterEach
    void clean(){
        driver.close();
    }
}
