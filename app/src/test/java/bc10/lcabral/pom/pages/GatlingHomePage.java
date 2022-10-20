package bc10.lcabral.pom.pages;

import bc10.lcabral.pom.base.SeleniumBase;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GatlingHomePage extends SeleniumBase {

    public GatlingHomePage(WebDriver driver) {
        super(driver);
    }
    //Localizadores
    String urlHome = "https://computer-database.gatling.io/computers";
    By inputBlanck = By.xpath("//input[@id='searchbox']");
    By filterB = By.xpath("//input[@id='searchsubmit']");
    By botonAdd = By.xpath("//a[@id='add']");
    By home = By.xpath("//a[@class='fill']");
    By computerName = By.xpath("//a[normalize-space()='Computer name']");
    By introduced = By.xpath("//a[normalize-space()='Introduced']");
    By discontinued = By.xpath("//a[normalize-space()='Discontinued']");
    By company = By.xpath("//a[normalize-space()='Company']");



    //funciones o acciones que podemos desarrollar en la pagina
    public void irHomePage(){
        navegarAPagina(urlHome);

    }

    public void redimensionar(int width, int height){
        cambiarTananhoDriver(width,height);
    }

    public void validarDespliegueBotones(){
        isDisplayed(filterB);
        isDisplayed(botonAdd);

    }

    public void validarDespliegueColumnas(){
        isDisplayed(computerName);
        isDisplayed(introduced);
        isDisplayed(discontinued);
        isDisplayed(company);
    }

    public void escribirEnBarraBusqueda(String texto){
        type(texto,inputBlanck);
    }
}
