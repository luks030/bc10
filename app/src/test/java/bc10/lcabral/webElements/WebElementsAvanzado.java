package bc10.lcabral.webElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class WebElementsAvanzado {

    WebDriver driver;

    @FindBy(id = "dropdown")
    WebElement dropdown;

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
    void setUp(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get("https://www.google.com");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        // Es una instruccion que espera que en cada elemento espera 3 segundos para cada referencia
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        PageFactory.initElements(driver, this);//Para crear una instancia de los elementos


    }

    @Test
    public void dropdown(){
        driver.get("https://the-internet.herokuapp.com/dropdown");

        // Clase para trabajar con los elementos
        Select manedoDropDown = new Select(dropdown);

        //Funcionalidades del select
        manedoDropDown.selectByValue("1");
        manedoDropDown.selectByValue("2");
        manedoDropDown.selectByValue("");


        manedoDropDown.selectByVisibleText("Option 1");
        manedoDropDown.selectByVisibleText("Option 2");


    }

    @Test
    public void dropdownDinamico(){
        driver.navigate().to("https://the-internet.herokuapp.com/jqueryui/menu");
        btnEnable.click();
        btnDowloads.click();
        Assertions.assertEquals("PDF",btnPDF.getText());

    }

    @Test
    public void checlbox(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        checkbox1.click();
        boolean estaClickeado = checkbox1.isSelected();
        checkbox2.click();
        estaClickeado = checkbox2.isSelected();

    }

    @Test
    public void iframe(){
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");


        //Obtener todos los elementos que contengan el tag iframe
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));

        //cambiar a iframe
        driver.switchTo().frame(iframes.get(0));

        //Ya cambiados al iframe, obtendremos nuevos objetos de esta pagina
        WebElement areaEscritura = driver.findElement(By.id("tinymce"));
        areaEscritura.clear();
        areaEscritura.sendKeys("Hola saludos BC10 :)");
    }

    @Test
    public void webTables1(){
        //Ejercicio tabal 1: Ordenar la tabla por deuda de mayor a menor
        driver.navigate().to("https://the-internet.herokuapp.com/tables");

        //Lista de webTablas en la pagina
        List<WebElement> webTables = driver.findElements(By.tagName("table"));

        WebElement tabla1 = webTables.get(0);
        //1. Cuantas filas y columnas tiene?
        List<WebElement> filas = tabla1.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
        System.out.println(filas.size());
        List<WebElement> columnas = tabla1.findElement(By.tagName("thead")).findElements(By.tagName("th"));
        System.out.println(columnas.size());

        //Obtener el webElemnt Due y presionarlo 2 veces para obtener la tabla
        if(columnas.get(3).getText().contains("Due")){
            columnas.get(3).click();
            columnas.get(3).click();
        }

        // Obtener el nombre, apellido y valor de deuda de la primera fila
        String nombre = filas.get(0).findElement(By.xpath("//td[2]")).getText();
        String apellido = filas.get(0).findElement(By.xpath("//td[1]")).getText();
        String deuda = filas.get(0).findElement(By.xpath("//td[4]")).getText();

        System.out.println("El usuario con mayor deuda actual es: "+nombre+" "+apellido+" "+deuda);

        //TABLA 2:
        //ejercicio tabla 2: ordenar por Nombre y entregar datos de deuda de todos los usuarios
        //declaramos la tabla 2 con la posicion 1 de la lista de todas las tablas traidas de la pagina
        WebElement tabla2 = webTables.get(1);

        List<WebElement> filas2 = tabla2.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));

        List<WebElement> columnas2 =tabla2.findElement(By.tagName("thead")).findElements(By.tagName("th"));
        //Clickear en FirstName
        columnas2.get(1).click();
        //Obtener los nombres y las deudas ya ordenadas por nombre

        String nombre1 = filas2.get(0).findElement(By.xpath("//*[@id=\"table2\"]/tbody/tr[1]/td[2]")).getText();
        String deuda1 =filas2.get(0).findElement(By.xpath("//*[@id=\"table2\"]/tbody/tr[1]/td[4]")).getText();



        String nombre2 = filas2.get(1).findElement(By.xpath("//*[@id=\"table2\"]/tbody/tr[2]/td[2]")).getText();
        String deuda2 =filas2.get(1).findElement(By.xpath("//*[@id=\"table2\"]/tbody/tr[2]/td[4]")).getText();


        String nombre3 = filas2.get(2).findElement(By.xpath("//*[@id=\"table2\"]/tbody/tr[3]/td[2]")).getText();
        String deuda3 =filas2.get(2).findElement(By.xpath("//*[@id=\"table2\"]/tbody/tr[3]/td[4]")).getText();


        String nombre4 = filas2.get(3).findElement(By.xpath("//*[@id=\"table2\"]/tbody/tr[4]/td[2]")).getText();
        String deuda4 =filas2.get(3).findElement(By.xpath("//*[@id=\"table2\"]/tbody/tr[4]/td[4]")).getText();

        System.out.println("las deudas de la  persona son " +nombre1 + deuda1);
        System.out.println("las deudas de la segunda persona son " +nombre2 + deuda2);
        System.out.println("las deudas de la tercera persona son " +nombre3 + deuda3);
        System.out.println("las deudas de la cuarta persona son " +nombre4 + deuda4 );

    }

    @Test
    public void webTablas2(){
        driver.navigate().to("https://the-internet.herokuapp.com/tables");

        //Creamos una tabala de todas la tablas en nuesta pagina web
        List<WebElement> webTablas = driver.findElements(By.tagName("table"));
        WebElement tabla2 = webTablas.get(1);
        //Cantidad de filas y columnas
        List<WebElement> columnas2 = tabla2.findElement(By.tagName("thead")).findElements(By.tagName("th"));
        List<WebElement> filas2 = tabla2.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
        columnas2.get(1).click();
        for (int i = 0; i < filas2.size(); i++) {
            String nombre = filas2.get(i).findElement(By.xpath("//tr["+(i+1)+"]/td[@class = 'first-name']")).getText();
            String deuda = filas2.get(i).findElement(By.xpath("//tr["+(i+1)+"]/td[@class = 'dues']")).getText();
            System.out.println("Usuario:"+nombre+" con deuda"+deuda);
        }


    }

    @AfterEach
    void clean(){
        driver.close();
    }
}
