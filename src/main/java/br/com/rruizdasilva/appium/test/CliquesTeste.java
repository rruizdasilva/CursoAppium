package br.com.rruizdasilva.appium.test;

import br.com.rruizdasilva.appium.core.BaseTest;
import br.com.rruizdasilva.appium.page.CliquesPage;
import br.com.rruizdasilva.appium.page.MenuPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CliquesTeste extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private CliquesPage cliquesPage = new CliquesPage();

    @Before
    public void setup(){
        menuPage.acessarCliques();
    }

    @Test
    public void deveRealizarCliqueLongo(){

        // clique longo
        cliquesPage.cliqueLongo();

        // verificar texto
        Assert.assertEquals("Clique Longo", cliquesPage.obterTextoCampo());
    }

    @Test
    public void deveRealizarCliqueDuplo(){
        cliquesPage.clicarPorTexto("Clique duplo");
        cliquesPage.clicarPorTexto("Clique duplo");
        Assert.assertEquals("Duplo Clique", cliquesPage.obterTextoCampo());
    }
}
