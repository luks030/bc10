package bc10.lgodoy.WebElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class WebElements {
    WebDriver driver;
    //localizadores
    By barraBusquedaLocalizador = By.name("q");
    By botonBuscarConGoogleLocalizador = By.name("btnK");

    @BeforeEach
    void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

    }
    @Test
    void busquedaGoogle(){
        //con WebElement capturamos el elemento, atravez de sus atributos
        WebElement barraBusqueda = driver.findElement(barraBusquedaLocalizador);
        barraBusqueda.clear();
        barraBusqueda.sendKeys("Tsoft");
        barraBusqueda.sendKeys(Keys.ESCAPE);
        WebElement btnBuscarConGoogle = driver.findElement(botonBuscarConGoogleLocalizador);
        btnBuscarConGoogle.click();
    }

    @AfterEach
    void close(){
        driver.close();
    }
}
