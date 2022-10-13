package bc10.lcabral;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserSwitchingTest {
    WebDriver driver;

    @BeforeEach
    void setUp(){
        WebDriverManager.edgedriver().setup();
    }

    @Test
    void browserSwitchingTest(){
        driver = new EdgeDriver();
        // Numero de ventana del drivers
        String originalWindow = driver.getWindowHandle();
        driver.get("https://www.google.com.ar");
        // Crear new window y cambiarme a esta nueva ventana
        driver.switchTo().newWindow(WindowType.WINDOW);
        String newWindow = driver.getWindowHandle();
        driver.get("https://www.google.cl");

        //Cambiar a window 1
        driver.switchTo().window(originalWindow);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.selenium.dev");

        //Cambiar a window 2
        driver.switchTo().window(newWindow);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.selenium.dev");

    }

    /*@AfterEach
    void close(){
        driver.quit();
    }*/
}
