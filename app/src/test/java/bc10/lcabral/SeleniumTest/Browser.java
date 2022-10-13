package bc10.lcabral.SeleniumTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Browser {
    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();

        driver.get("https://www.google.com");

        driver.close();
        //obtener la url
        System.out.println(driver.getCurrentUrl());
        //obtener el titulo
        System.out.println(driver.getTitle());
    }
}
