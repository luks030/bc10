package bc10.lcabral.pom.base;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SeleniumBase {


    private WebDriver driver;
    //Constructor
    public SeleniumBase(WebDriver driver){
        this.driver = driver;
    }

    public void navegarAPagina(String url){
        driver.navigate().to(url);
    }
    public WebElement encontrarElemnto(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> encontrarElemntos (By locator){
        return driver.findElements(locator);
    }

    public String getText (By locator){
        return driver.findElement(locator).getText();
    }

    public void type(String inputText, By locator){
        driver.findElement(locator).sendKeys(inputText);
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }

    public Boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }
    public Boolean isSelected(By locator) {
        try {
            return driver.findElement(locator).isSelected();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public void cambiarTananhoDriver(int width, int height){
        driver.manage().window().setSize(new Dimension(width,height));
    }

    public int getWidth(){
        return driver.manage().window().getSize().width;
    }

    public int getHeight(){
        return driver.manage().window().getSize().height;
    }

    public WebDriver getDriver(){
        return driver;
    }
}


