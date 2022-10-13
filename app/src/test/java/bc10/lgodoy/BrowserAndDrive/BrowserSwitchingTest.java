package bc10.lgodoy.BrowserAndDrive;

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
        //obtiene el numero de identificador del browser
        String originalWindows =driver.getWindowHandle();
        driver.navigate().to("https:www.google.com.ar");
        //crear nueva ventana y cambiarme a una nueva ventana
        driver.switchTo().newWindow(WindowType.WINDOW);
        String newWindows = driver.getWindowHandle();
        driver.navigate().to("https:www.google.cl");

        //cambiarme a windows 1
        driver.switchTo().window(originalWindows);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https:selenium.dev");
        //cambio a la ventana 2
        driver.switchTo().window(newWindows);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https:selenium.dev");

    }
    @AfterEach
    void close(){
        driver.close();
    }
}
