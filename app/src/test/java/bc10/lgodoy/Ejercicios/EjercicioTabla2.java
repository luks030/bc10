package bc10.lgodoy.Ejercicios;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;
import java.util.List;

public class EjercicioTabla2 {

    WebDriver driver;
    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        PageFactory.initElements(driver, this);
    }
    @Test
    public void tabla2(){
        driver.get("https://the-internet.herokuapp.com/tables");
        //ejercicio tabla 2
        List<WebElement> webTables = driver.findElements(By.tagName("table"));
        WebElement tabla2 = webTables.get(1);
        List<WebElement> filas2 = tabla2.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
        List<WebElement> columnas2 = tabla2.findElement(By.tagName("thead")).findElements(By.tagName("th"));
        if (columnas2.get(1).getText().contains("First Name")) {
            columnas2.get(1).click();
        }
        String nombre="";
        String apellido="";
        String deuda="";

        for (int i = 0; i < filas2.size(); i++) {
            nombre = filas2.get(i).findElement(By.xpath(" //*[@id=\"table2\"]/tbody/tr["+(i+1)+"]/td[2]")).getText();
            apellido= filas2.get(i).findElement(By.xpath(" //*[@id=\"table2\"]/tbody/tr["+(i+1)+"]/td[1]")).getText();
            deuda = filas2.get(i).findElement(By.xpath(" //*[@id=\"table2\"]/tbody/tr["+(i+1)+"]/td[4]")).getText();
            System.out.println("Nombre: " + nombre + ", Apellido: " + apellido + ", Deuda: " + deuda);
        }
    }
    @AfterEach
    void close() {
        driver.close();
    }
}
