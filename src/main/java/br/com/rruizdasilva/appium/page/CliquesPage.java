package br.com.rruizdasilva.appium.page;

import br.com.rruizdasilva.appium.core.BasePage;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;

import static br.com.rruizdasilva.appium.core.DriverFactory.getDriver;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class CliquesPage extends BasePage {

    public void cliqueLongo() {
        cliqueLongo(By.xpath("//*[@text='Clique Longo']"));
    }

    public String obterTextoCampo(){
        return obterTexto(By.xpath("(//android.widget.TextView)[3]"));
    }
}
