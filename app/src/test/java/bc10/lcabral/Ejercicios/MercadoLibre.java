package bc10.lcabral.Ejercicios;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class MercadoLibre {
    WebDriver driver;
    //localizaadores
    @FindBy(xpath ="(//li[@class='nav-menu-item']/a)[1]")
    WebElement elementoEnviara;

    @FindBy(xpath = "//input[@name = 'zipcode' and @class = 'andes-form-control__field']")
    WebElement elementoEscribitCodigoPostal;

    @FindBy(xpath = "//span[@class = 'andes-button__content']")
    WebElement elementoMandarCodigoPostal;

    @FindBy(xpath = "//a[@href = 'https://www.mercadolibre.com.ar/registration?confirmation_url=https%3A%2F%2Fwww.mercadolibre.com.ar%2F#nav-header']" )
    WebElement elementoCrearCuenta;

    @FindBy(xpath ="//a[@id = 'view_more' or @href = '//www.mercadolibre.com.ar/mercado-puntos#origin=benefits-home']")
    WebElement elementoBeneficios;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/button[1]" )
   WebElement elementoAceptarCookies;

    @FindBy(xpath = "//a[normalize-space() = 'Trabajá con nosotros' or @href = 'https://careers-meli.mercadolibre.com/?utm_campaign=site-mla&utm_source=mercadolibre&utm_medium=mercadolibre']" )
    WebElement elementoTrabajaConNosotros;

    @FindBy(xpath = "//a[@href = 'https://mercadolibre.eightfold.ai/careers?la=es']/span" )
    WebElement elementoverOportunidades;

    By iframeLocalizador = By.cssSelector(".andes-modal-dialog > iframe:nth-child(1)");



    @BeforeEach
    void setUp (){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get("https://www.mercadolibre.com.ar");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        PageFactory.initElements(driver, this);//Para crear una instancia de los elementos

    }

    @Test
    void busquedaMercadoLibre() throws InterruptedException {
        /*WebElement direccion = driver.findElement(elementoDireccion);
        direccion.click();
        WebElement Zipcode = driver.findElement(By.xpath("/html/body/main/div/div[2]/form/div/div/div/div[1]/label/div/input"));
        Zipcode.clear();
        Zipcode.sendKeys("5300");
        WebElement btnUsar = driver.findElement(By.xpath("/html/body/main/div/div[2]/form/div/div/div/div[1]/label/div/div/button/span"));
        btnUsar.click();*/
        elementoEnviara.click();
        driver.switchTo().frame(driver.findElement((iframeLocalizador)));
        elementoEscribitCodigoPostal.sendKeys("5300");
        elementoMandarCodigoPostal.click();
    }

    @Test
    void entrarBeneficios(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1200)");
        elementoBeneficios.click();
        driver.navigate().back();
    }

    @Test
    void entrarCrearCuenta() throws IOException{
        elementoCrearCuenta.click();
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile,new File("./creoCuenta.png"));
        driver.navigate().back();
    }

    @Test
    void entrarTrabajaConNosotros() throws IOException{
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,4000)");
        elementoAceptarCookies.click();
        elementoTrabajaConNosotros.click();
        elementoverOportunidades.click();
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile,new File("./oportunidades.png"));
        driver.navigate().back();
        driver.navigate().back();
    }

    @AfterEach
    void clean(){
        driver.close();
    }
}