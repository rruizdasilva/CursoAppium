package br.com.rruizdasilva.appium.page;

import br.com.rruizdasilva.appium.core.BasePage;
import org.openqa.selenium.By;

public class MenuPage extends BasePage {

    public void acessarFormulario() {
        clicarPorTexto("Formulário");
    }

    public void acessarSplash() {
        clicarPorTexto("Splash");
    }

    public void acessarAlertas() {
        clicarPorTexto("Alertas");
    }

    public void acessarAbas() {
        clicarPorTexto("Abas");
    }

    public void acessarAccordion() {
        clicarPorTexto("Accordion");
    }

    public void acessarCliques() {
        clicarPorTexto("Cliques");
    }

    public void acessarSwipe() {
        clicarPorTexto("Swipe");
    }

    public void acessarSwipeList() {
        scrollDown();
        clicarPorTexto("Swipe List");
    }

    public void acessarDragAndDrop(){
        scrollDown();
        clicarPorTexto("Drag and drop");
    }

    public void acessarSBHibrido(){
        scrollDown();
        clicarPorTexto("SeuBarriga Híbrido");
    }

    public String obterTextoAlerta() {
        return obterTexto(By.id("android:id/message"));
    }
}
