package bc10.lgodoy.Ejercicios;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class EjercicioSpDigital {
    WebDriver driver;
    //localizadores
    By barraBusquedaLocalizador = By.className("Fractal-SearchBar--searchbar");
    By botonLupaLocalizador = By.xpath("//button[@type='submit']//*[name()='svg']");
    By homeLocalizador = By.xpath("//a[normalize-space()='Home']");
    By quienesSomosLocalizador = By.xpath("/html/body/div[1]/div[1]/div/div[4]/section[16]/div/div[1]/span/span[2]/ul/li[1]/a/span");
    By pagosLocalizador = By.xpath("/html/body/div[1]/div[1]/div/div[4]/section[15]/div/div/span[3]/span[1]/a");
    By gamingYStrimingLocalizador = By.xpath("/html/body/div[1]/div[1]/div/div[3]/div/a[1]/div/span");
    By armadoSpLabsLocalizador = By.xpath("//span[normalize-space()='Armados SP Labs']");

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.spdigital.cl");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
    }

    @Test
    void Ejercicio() throws InterruptedException {
        //con WebElement capturamos el elemento, atravez de sus atributos
        WebElement barraBusqueda = driver.findElement(barraBusquedaLocalizador);
        barraBusqueda.sendKeys("Nvidia");
        WebElement busqueda = driver.findElement(botonLupaLocalizador);
        busqueda.click();
        Thread.sleep(4000);
        WebElement home = driver.findElement(homeLocalizador);
        home.click();
        WebElement linkQuienesSomos = driver.findElement(quienesSomosLocalizador);
        linkQuienesSomos.click();
        driver.navigate().back();
        WebElement linkPago = driver.findElement(pagosLocalizador);
        linkPago.click();
        driver.navigate().back();
        //Navega por el menu desplegable de la pagina web
        WebElement gamingStr = driver.findElement(gamingYStrimingLocalizador);
        Actions actions = new Actions(driver);
        actions.moveToElement(gamingStr).perform();
        WebElement armados = driver.findElement(armadoSpLabsLocalizador);
        armados.click();
    }
    @AfterEach
    void close() {
        driver.close();
    }
}
