package bc10.lcabral.Ejercicios;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SPDigital {
    WebDriver driver;
    //localizaadores

    @FindBy(xpath = "//input[@class = 'Fractal-SearchBar--searchbar  ']")
    WebElement barraBusqueda;

    @FindBy(xpath = "//button[@class = 'Fractal-SearchBar--button']")
    WebElement btnBuscar;

    @FindBy(xpath = "//li/a[normalize-space() = 'Quiénes somos' or @href = '/about/']")
    WebElement elementoQuinesSomos;

    @FindBy(xpath = "//a[@href = '/faq/payments/']" )
    WebElement elementoPago;

    @FindBy(xpath = "//li/a[normalize-space() = \"SP Labs\" or @href = \"/sp-labs/\"]" )
    WebElement elementoSPLabs;

    @BeforeEach
    void setUp (){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get("https://www.spdigital.cl/");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        PageFactory.initElements(driver, this);//Para crear una instancia de los elementos
    }

    @Test
    void busquedaSPDigital(){
        barraBusqueda.clear();
        barraBusqueda.sendKeys("mouse");
        btnBuscar.click();
        driver.navigate().back();
    }

    @Test
    void entrarQuienesSomos(){
        elementoQuinesSomos.click();
        driver.navigate().back();
    }

    @Test
    void entrarPago(){
        elementoPago.click();
        driver.navigate().back();
    }

    @Test
    void entrarSPLabs(){
        elementoSPLabs.click();
        driver.navigate().back();
    }

    @AfterEach
    void clean(){
        driver.close();
    }
}
