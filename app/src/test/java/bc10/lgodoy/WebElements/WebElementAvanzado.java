package bc10.lgodoy.WebElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;
import java.util.List;

public class WebElementAvanzado {
    WebDriver driver;
    //localizadores
    @FindBy(id = "dropdown")
    WebElement dropdawn;
    @FindBy(id = "ui-id-3")
    WebElement btnEnable;
    @FindBy(id = "ui-id-4")
    WebElement btnDowloads;
    @FindBy(id = "ui-id-5")
    WebElement btnPDF;
    @FindBy(xpath = "//input[1]")
    WebElement checkbox1;
    @FindBy(xpath = "//input[2]")
    WebElement checkbox2;

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
    void dropdown() {
        driver.get("https://the-internet.herokuapp.com/dropdown");

        //clase para trabajar con el elemento <select>
        Select manejoDropdown = new Select(dropdawn);
        //funcionalidades de select
        manejoDropdown.selectByValue("1");
        manejoDropdown.selectByValue("2");
        manejoDropdown.selectByValue("");
        //seleccion por texto
        manejoDropdown.selectByVisibleText("Option 1");
        manejoDropdown.selectByVisibleText("Option 2");
    }

    @Test
    void setDropdawnDinamico() {
        driver.navigate().to("https://the-internet.herokuapp.com/jqueryui/menu");
        btnEnable.click();
        btnDowloads.click();
        btnPDF.click();
        Assertions.assertEquals("PDF", btnPDF.getText());
    }

    @Test
    public void checkBox() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        checkbox1.click();
        boolean estaclikeado = checkbox1.isSelected();
        checkbox2.click();
        estaclikeado = checkbox2.isSelected();
    }

    @Test
    public void iframe() {
        driver.get("https://the-internet.herokuapp.com/iframe");
        //obteer todos los elementos web que contenga el tag iframa
        List<WebElement> iframe = driver.findElements(By.tagName("iframe"));
        //cambiar al iframe
        driver.switchTo().frame(iframe.get(0));
        //ya cambiados al ifreme obtenemos objetos de esa pagina
        WebElement areaEscritura = driver.findElement(By.id("tinymce"));
        areaEscritura.clear();
        areaEscritura.sendKeys("Hola Saludos BC10 :) ");
    }
    @Test
    public void webTables() {
        driver.get("https://the-internet.herokuapp.com/tables");
        //ejercicio tabla 1
        List<WebElement> webTables = driver.findElements(By.tagName("table"));
        WebElement tabla1 = webTables.get(0);
        //cuantas filas y columnas hay
        List<WebElement> filas = tabla1.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
        System.out.println(filas.size());
        List<WebElement> columnas = tabla1.findElement(By.tagName("thead")).findElements(By.tagName("th"));
        System.out.println(columnas.size());
        //obtener el web element due y presionar dos veces para ordenar la tabla1
        if (columnas.get(3).getText().contains("Due")) {
            columnas.get(3).click();
            columnas.get(3).click();
        }
        //obtener el nombre, apellido y valor de deuda de la primera fila
        String nombre = filas.get(0).findElement(By.xpath("//td[2]")).getText();
        String apellido = filas.get(0).findElement(By.xpath("//td[1]")).getText();
        String deuda = filas.get(0).findElement(By.xpath("//td[4]")).getText();
        System.out.println("el usuario con mayor deuda es: " + nombre + " " + apellido + " " + deuda);
        System.out.println("marca debug");
    }
    @AfterEach
    void close() {
        driver.close();
    }
}
