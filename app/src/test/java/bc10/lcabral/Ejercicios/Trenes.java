package bc10.lcabral.Ejercicios;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Trenes {

    WebDriver driver;
    //localizaadores




    @BeforeEach
    void setUp (){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get("https://www.rumbo.es");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        PageFactory.initElements(driver, this);//Para crear una instancia de los elementos

    }

    @Test
    void busquedaMercadoLibre() {
        System.out.println("Hola");
    }

}
