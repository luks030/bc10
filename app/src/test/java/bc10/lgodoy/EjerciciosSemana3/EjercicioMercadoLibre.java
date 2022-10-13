package bc10.lgodoy.EjerciciosSemana3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class EjercicioMercadoLibre {
    WebDriver driver;
    By ubicacionSelector = By.xpath("/html/body/header/div/div[2]/ul/li[1]/a");
    By cockieAceparSelector = By.xpath("/html/body/div[2]/div[1]/div[2]/button[1]");
    By cambioCodigoPostalSelector = By.xpath("/html/body/main/div/div[2]/form/div/div/div/div[1]/label/div/input");
    By beneficiosSelector = By.xpath("/html/body/main/div/div/section[4]/div/div[1]/a");
    By crearCuentaSelector = By.xpath("/html/body/header/div/div[1]/nav[2]/a[1]");
    By trabajaConNosotrosSelector = By.xpath("/html/body/footer/div/div[1]/div/nav/a[1]");
    By verOportunidadesSelector = By.xpath("/html/body/div/div[2]/main/section[1]/div[5]/div/a/span");


    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.mercadolibre.com.ar/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }
    @Test
    void mercadoLibreTest() throws IOException {
        /*
        WebElement enviar = driver.findElement(ubicacionSelector);
        enviar.click();
        WebElement aceptar = driver.findElement(cockieAceparSelector);
        aceptar.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("1900");
        alert.accept();
        */
        WebElement selec = driver.findElement(cockieAceparSelector);
        selec.click();
        WebElement beneficios = driver.findElement(beneficiosSelector);
        beneficios.click();
        driver.navigate().back();
        WebElement cuenta = driver.findElement(crearCuentaSelector);
        cuenta.click();
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile,new File("./beneficios.png"));
        driver.navigate().back();
        WebElement trabaja = driver.findElement(trabajaConNosotrosSelector);
        trabaja.click();
        WebElement oportunidades = driver.findElement(verOportunidadesSelector);
        oportunidades.click();
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
