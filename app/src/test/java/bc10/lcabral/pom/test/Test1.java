package bc10.lcabral.pom.test;

import bc10.lcabral.pom.base.TestBase;
import bc10.lcabral.pom.pages.GatlingHomePage;
import org.junit.jupiter.api.Test;

public class Test1 extends TestBase {

    GatlingHomePage gatlingHomePage;

    @Test
    public void test1(){
        gatlingHomePage = new GatlingHomePage(gatlingHomePage.getDriver());
        gatlingHomePage.irHomePage();
        gatlingHomePage.validarDespliegueBotones();
        gatlingHomePage.validarDespliegueColumnas();
    }
}
