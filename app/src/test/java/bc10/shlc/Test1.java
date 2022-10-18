package bc10.shlc;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.hc.core5.util.Asserts;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
import java.util.List;

public class Test1 {


    WebDriver driver;

    //Localizadores
    By btnFilterNameLoc = By.xpath("//input[@id='searchsubmit']");
    By btnNewComputerLoc = By.xpath("//a[@id='add']");
    By tablaLoc = By.xpath("//table[@class='computers zebra-striped']");



    @BeforeEach
    void setUp(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().setSize(new Dimension(800, 600));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.navigate().to("https://computer-database.gatling.io/computers");
        Dimension dimension = driver.manage().window().getSize();
        int wight = dimension.getWidth();
        int height = dimension.getHeight();
        System.out.println("La resolucion de pantalla es: "+wight+" x "+ height);
    }

    @Test
    void userInterfaceFilterName(){

        WebElement btnFilterName = driver.findElement(btnFilterNameLoc);
        boolean btnFilter  =  btnFilterName.isDisplayed();
        System.out.println("Boton Filter by Name esta funcionando de manera correta: " +btnFilter);
        Assertions.assertEquals("Filter by name",btnFilterName.getAccessibleName());
        Assertions.assertTrue(btnFilter);

    }
    @Test
    void userInterfaceNewComputer(){

        WebElement btnNewComputer = driver.findElement(btnNewComputerLoc);
        boolean btnFilter  =  btnNewComputer.isDisplayed();
        System.out.println("Boton Filter by Name esta funcionando de manera correta: " +btnFilter);
        Assertions.assertEquals("Add a new computer",btnNewComputer.getAccessibleName());
        Assertions.assertTrue(btnFilter);


    }

    @Test
    void userInterfaceTable(){

        List<WebElement> webTables = driver.findElements(tablaLoc);
        WebElement tabla = webTables.get(0);

        List<WebElement> columnas = tabla.findElement(By.tagName("thead")).findElements(By.tagName("th"));
        for (int i = 0; i <columnas.size() ; i++) {
            String nombre = columnas.get(i).findElement(By.xpath("//th["+(i+1)+"]")).getText();
            Assertions.assertEquals(nombre, columnas.get(i).getText());

        }

    }

    @AfterEach
    void clean(){
        driver.close();
    }
}
