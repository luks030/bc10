package bc10.lcabral;

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
        driver.manage().window().setSize(new Dimension(800, 600));
    }

    @Test
    void browserSize(){
        //Largo y ancho de la ventana o browser
        //manage() para manejar los tamaños de la ventana
        //getSize() para obtener el taaño de la ventana
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().getHeight();

        //Dimension, para usar la variable y obtener los valores de ña ventana
        Dimension dimension = driver.manage().window().getSize();
        int width2 = dimension.getWidth();
        int height2 = dimension.getHeight();

        //Cambiar el tamaño de la ventana en ejecucion
        driver.manage().window().setSize(new Dimension(600,400));



    }

    @Test
    void browserPosition(){
        // Para obtener a posicion
        int x = driver.manage().window().getPosition().getX();
        int y = driver.manage().window().getPosition().getY();

        //Position, para saber la posicion de la ventana
        Point posicion = driver.manage().window().getPosition();
        int x1 = posicion.getX();
        int y1 = posicion.getY();

        // Modificar la posicion de la ventana - browser - driver
        driver.manage().window().setPosition(new Point(0,0));

    }

    @AfterEach
    void close(){
        driver.quit();
    }

}
