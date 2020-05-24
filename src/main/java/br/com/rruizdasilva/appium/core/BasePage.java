package br.com.rruizdasilva.appium.core;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import java.time.Duration;

import static br.com.rruizdasilva.appium.core.DriverFactory.getDriver;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;

public class BasePage {

    public void escrever(By by, String texto) {
        getDriver().findElement(by).sendKeys(texto);
    }

    public String obterTexto(By by) {
        return getDriver().findElement(by).getText();
    }

    public void clicar(By by) {
        getDriver().findElement(by).click();
    }

    public void clicarPorTexto(String valor) {
        clicar(By.xpath("//*[@text='" + valor + "']"));
    }

    public void selecionarCombo(By by, String valor) {
        getDriver().findElement(by).click();
        clicarPorTexto(valor);
    }

    public boolean isCheckMarcado(By by) {
        return getDriver().findElement(by).getAttribute("checked").equals("true");
    }

    public boolean existeElementoPorTexto(String texto) {
        return getDriver().findElements(By.xpath("//*[@text='" + texto + "']")).size() > 0;
    }

    public void tap(int x, int y) {
        new TouchAction<>(getDriver())
                .tap(point(new Point(x, y)))
                .perform();
    }

    public void scrollDown() {
        scroll(0.9, 0.1);
    }

    public void scrollUp() {
        scroll(0.1, 0.9);
    }

    public void swipeRight() {
        swipe(0.9, 0.1);
    }

    public void swipeLeft() {
        swipe(0.1, 0.9);
    }

    public void swipeElement(MobileElement element, double inicio, double fim) {

        int y = element.getLocation().y + element.getSize().height / 2;

        int xInicial = (int) (element.getSize().width * inicio);
        int xFinal = (int) (element.getSize().width * fim);

        new TouchAction<>(getDriver())
                .press(point(new Point(xInicial, y)))
                .waitAction(waitOptions(Duration.ofMillis(500)))
                .moveTo(point(new Point(xFinal, y)))
                .release()
                .perform();
    }

    private void scroll(double inicio, double fim) {
        Dimension tamanhoTela = getDriver().manage().window().getSize();

        int x = tamanhoTela.width / 2;

        int yInicial = (int) (tamanhoTela.height * inicio);
        int yFinal = (int) (tamanhoTela.height * fim);

        new TouchAction<>(getDriver())
                .press(point(new Point(x, yInicial)))
                .waitAction(waitOptions(Duration.ofMillis(500)))
                .moveTo(point(new Point(x, yFinal)))
                .release()
                .perform();
    }

    private void swipe(double inicio, double fim) {
        Dimension tamanhoTela = getDriver().manage().window().getSize();

        int y = tamanhoTela.height / 2;

        int xInicial = (int) (tamanhoTela.width * inicio);
        int xFinal = (int) (tamanhoTela.width * fim);

        new TouchAction<>(getDriver())
                .press(point(new Point(xInicial, y)))
                .waitAction(waitOptions(Duration.ofMillis(500)))
                .moveTo(point(new Point(xFinal, y)))
                .release()
                .perform();
    }

    public void cliqueLongo(By by){
        new TouchAction<>(getDriver())
                .longPress(PointOption.point(getDriver().findElement(by).getCenter()));
    }


}
