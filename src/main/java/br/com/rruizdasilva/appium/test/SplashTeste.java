package br.com.rruizdasilva.appium.test;

import br.com.rruizdasilva.appium.core.BaseTest;
import br.com.rruizdasilva.appium.page.MenuPage;
import br.com.rruizdasilva.appium.page.SplashPage;
import org.junit.Assert;
import org.junit.Test;

public class SplashTeste extends BaseTest {

    MenuPage menuPage = new MenuPage();
    SplashPage splashPage = new SplashPage();

    @Test
    public void deveAguardarSplashSumir() {
        //acessar menu splash
        menuPage.acessarSplash();

        // verificar que o splash está sendo exibido
        splashPage.isTelaSplashVisivel();

        // aguardar saída do splash
        splashPage.aguardarSplashSumir();

        // verificar que o formulário está aparecendo
        Assert.assertTrue(menuPage.existeElementoPorTexto("Formulário"));
    }
}
