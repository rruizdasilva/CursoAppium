package br.com.rruizdasilva.appium.test;

import br.com.rruizdasilva.appium.core.BaseTest;
import br.com.rruizdasilva.appium.page.MenuPage;
import br.com.rruizdasilva.appium.page.WebViewPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class WebViewTeste extends BaseTest {

    private MenuPage menu = new MenuPage();
    private WebViewPage page = new WebViewPage();

    @Test
    public void deveFazerLogin(){

        // acessar o menu
        menu.acessarSBHibrido();
        esperaFixa(3);
        page.entrarContextoWeb();

        // preencher email
        page.setEmail("roger@abc.com");

        // senha
        page.setSenha("1234");

        // entrar
        page.entrar();

        // verificar
        Assert.assertEquals("Bem vindo, Roger Silva!", page.getMensagem());
    }

    @After
    public void tearDown(){
        page.sairContextoWeb();
    }
}
