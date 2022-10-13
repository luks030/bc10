package bc10.lgodoy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserSizing {
    WebDriver driver;
    @BeforeEach
    void setUp(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.get("https://www.google.cl");
        driver.manage().window().maximize();
        driver.manage().window().minimize();
        driver.manage().window().fullscreen();
        driver.manage().window().setSize(new Dimension(800,600));
    }
    @Test
    void browserSeze(){

        //obtener el Alto y Largo de la ventana browser
        int width=driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().getHeight();

        //Dimension otra clase de la libreria de selenium permite obtener los tamaños de las ventanas
        Dimension dimension = driver.manage().window().getSize();
        int width2 = dimension.getWidth();
        int heigth2 = dimension.getHeight();
        //Cambiar el tamaño de la ventana
        driver.manage().window().setSize(new Dimension(600,400));

    }
    @Test
    void browsePosition(){
        //obtenemos la posicion de la ventana
        int x = driver.manage().window().getPosition().getX();
        int y = driver.manage().window().getPosition().getY();
        //Position = Point
        Point posicion = driver.manage().window().getPosition();
        int x1= posicion.x;
        int y1=posicion.y;
        //modificar la posicion  de la ventana, browser, driver
        driver.manage().window().setPosition(new Point(0,0));
    }
    @AfterEach
    void close(){
        driver.close();
    }
}
