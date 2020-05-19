package br.com.rruizdasilva.appium.test;

import br.com.rruizdasilva.appium.core.BaseTest;
import br.com.rruizdasilva.appium.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class OpcaoEscondidaTeste extends BaseTest {

    private MenuPage menuPage = new MenuPage();

    @Test
    public void deveEncontrarOpcaoEscondida() {
        // talvez seja necessário uma espera implícita ou explícita
        
        // scroll down
        menuPage.scrollDown();

        // clicar menu
        menuPage.clicarPorTexto("Opção bem escondida");

        // verificar mensagem
        Assert.assertEquals("Você achou essa opção", menuPage.obterTextoAlerta());

        // sair
        menuPage.clicarPorTexto("OK");
    }
}
