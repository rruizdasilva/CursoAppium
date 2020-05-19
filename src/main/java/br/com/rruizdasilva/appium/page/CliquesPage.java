package br.com.rruizdasilva.appium.page;

import br.com.rruizdasilva.appium.core.BasePage;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;

import static br.com.rruizdasilva.appium.core.DriverFactory.getDriver;

public class CliquesPage extends BasePage {

    public void cliqueLongo() {
        new TouchAction(getDriver())
                .longPress(getDriver().findElement(By.xpath("//*[@text='Clique Longo']")))
                .perform();
    }

    public String obterTextoCampo(){
        return obterTexto(By.xpath("(//android.widget.TextView)[3]"));
    }
}
