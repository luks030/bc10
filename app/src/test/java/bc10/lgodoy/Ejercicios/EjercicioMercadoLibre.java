package bc10.lgodoy.Ejercicios;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class EjercicioMercadoLibre {
    WebDriver driver;
    @FindBy(xpath = "//button[@data-testid='action:understood-button']")
            WebElement aceptarCookies;
    @FindBy(xpath = "//a[@class='nav-menu-cp nav-menu-cp-logged']")
            WebElement cambiarCodigoPostal;
    @FindBy (name = "zipcode")
            WebElement ingresoCodigoPostal;
    @FindBy(xpath = "//a[@id='view_more']")
            WebElement beneficios;
    @FindBy(xpath = "//a[@data-link-id='registration']")
            WebElement crearCuenta;
    @FindBy(css = "a[href='https://careers-meli.mercadolibre.com/?utm_campaign=site-mla&utm_source=mercadolibre&utm_medium=mercadolibre']")
            WebElement trabajaConNosotros;
    @FindBy(xpath = "//a[@aria-label='See Opportunities Button']//span[@class='styles__Wrapper-sc-g49ob4-0 bpAbpc button button'][normalize-space()='Ver oportunidades']")
            WebElement verOportunidades;
    By iframeLocalizador = By.cssSelector(".andes-modal-dialog > iframe:nth-child(1)");

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.mercadolibre.com.ar/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        PageFactory.initElements(driver, this);
    }

    @Test
    void mercadoLibreTest() throws IOException, InterruptedException {
        aceptarCookies.click();
        //inicio del iframe
        cambiarCodigoPostal.click();
        driver.switchTo().frame(driver.findElement(iframeLocalizador));
        Thread.sleep(1500);
        ingresoCodigoPostal.sendKeys("5300");
        ingresoCodigoPostal.submit();
        //fin del iframe
        beneficios.click();
        driver.navigate().back();
        crearCuenta.click();
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile,new File("./beneficios.png"));
        driver.navigate().back();
        trabajaConNosotros.click();
        verOportunidades.click();
        File srcFile2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile2,new File("./oportunidades.png"));
        driver.navigate().back();
        driver.navigate().back();
    }
    @AfterEach
    void close(){
        driver.close();
    }
}
