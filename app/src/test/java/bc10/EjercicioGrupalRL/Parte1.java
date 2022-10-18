package bc10.EjercicioGrupalRL;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Parte1 {
    WebDriver driver;
    @FindBy(id = "searchsubmit")
    WebElement btnFiltrar;
    @FindBy(id = "add")
    WebElement btnAdd;
    @FindBy(xpath = "//a[text()='Computer name']")
    WebElement colComputerName;
    @FindBy(xpath = "//a[text()='Introduced']")
    WebElement colIntroduced;
    @FindBy(xpath = "//a[text()='Discontinued']")
    WebElement colDiscontinued;
    @FindBy(xpath = "//a[text()='Company']")
    WebElement colCompany;


    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to("https://computer-database.gatling.io/computers");
        driver.manage().deleteAllCookies();
        PageFactory.initElements(driver, this);
    }
    @Test
    public void test1(){
        driver.manage().window().setSize(new Dimension(800,600));
        Dimension dimension = driver.manage().window().getSize();
        Assertions.assertEquals(800,dimension.getWidth());
        Assertions.assertEquals(600,dimension.getHeight());
        Assertions.assertEquals("Filter by name",btnFiltrar.getAccessibleName());
        Assertions.assertEquals("Add a new computer",btnAdd.getAccessibleName());
        Assertions.assertEquals("Computer name",colComputerName.getText());
        Assertions.assertEquals("Introduced",colIntroduced.getText());
        Assertions.assertEquals("Discontinued",colDiscontinued.getText());
        Assertions.assertEquals("Company",colCompany.getText());
    }

    @AfterEach
    void close(){
        driver.close();
    }
}
