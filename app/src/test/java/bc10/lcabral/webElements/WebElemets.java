package bc10.lcabral.webElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class WebElemets {

    WebDriver driver;
    //Localizadores

    @FindBy(name = "q")
    WebElement barraBusqueda;

    @FindBy(name = "btnK")
    WebElement btnBuscarConGoogle;

    @BeforeEach
    void setUp(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get("https://www.google.com");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        // Es una instruccion que espera que en cada elemento espera 3 segundos para cada referencia
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

    }

    @Test
    void busquedaGoogle() throws InterruptedException {

        //WebElemnt capturamos el elemento a traves de sus atributos
        //WebElement barraBusqueda = driver.findElement(barraBusquedaLocalizador);
        // Para limpiar el texto de busqueda clear()
        barraBusqueda.clear();
        barraBusqueda.sendKeys("Tsoft");
        barraBusqueda.sendKeys(Keys.ESCAPE);
        Thread.sleep(500);
        //WebElement btnBuscarConGoogle = driver.findElement(btnBuscarConGoogleLocalizador);
        btnBuscarConGoogle.click();
        Assertions.assertEquals("Tsoft - Buscar con Google",driver.getTitle());



    }

    @AfterEach
    void clean(){
        driver.close();
    }

}
