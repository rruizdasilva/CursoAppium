package br.com.rruizdasilva.appium.page;

import br.com.rruizdasilva.appium.core.BasePage;
import org.openqa.selenium.By;

import static br.com.rruizdasilva.appium.core.DriverFactory.getDriver;

public class WebViewPage extends BasePage {

    public void entrarContextoWeb() {
        getDriver().context((String) getDriver().getContextHandles().toArray()[1]);
    }

    public void sairContextoWeb() {
        getDriver().context((String) getDriver().getContextHandles().toArray()[0]);
    }

    public void setEmail(String valor) {
        getDriver().findElement(By.id("email")).sendKeys(valor);
    }

    public void setSenha(String valor) {
        getDriver().findElement(By.id("senha")).sendKeys(valor);
    }

    public void entrar() {
        clicar(By.xpath("//button[@type='submit']"));
    }

    public String getMensagem(){
        return obterTexto(By.xpath("//div[@class='alert alert-success']"));
    }
}
