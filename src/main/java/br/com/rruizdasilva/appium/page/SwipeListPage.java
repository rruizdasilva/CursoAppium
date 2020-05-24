package br.com.rruizdasilva.appium.page;

import br.com.rruizdasilva.appium.core.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;

import static br.com.rruizdasilva.appium.core.DriverFactory.getDriver;

public class SwipeListPage extends BasePage {

    public void swipeElementLeft(String opcao){
        swipeElement(getDriver().findElement(By.xpath("//*[@text='" + opcao + "']/..")), 0.1, 0.9);
    }

    public void swipeElementRight(String opcao){
        swipeElement(getDriver().findElement(By.xpath("//*[@text='" + opcao + "']/..")), 0.9, 0.1);
    }

    public void clicarNoBotaoMais(){
        MobileElement botao = getDriver().findElement(By.xpath("//*[@text='(+)']/.."));
        new TouchAction<>(getDriver())
                .tap(TapOptions.tapOptions().withElement(ElementOption.element(botao, -50, 0)))
                .perform();
    }
}
