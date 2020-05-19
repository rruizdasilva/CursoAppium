package br.com.rruizdasilva.appium.test;

import br.com.rruizdasilva.appium.core.BaseTest;
import br.com.rruizdasilva.appium.page.MenuPage;
import br.com.rruizdasilva.appium.page.SwipePage;
import org.junit.Assert;
import org.junit.Test;

public class SwipeTeste extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private SwipePage swipePage = new SwipePage();

    @Test
    public void deveRealizarSwipe() {

        // acessar menu
        menuPage.acessarSwipe();

        // verificar texto 'à esquerda'
        Assert.assertTrue(swipePage.existeElementoPorTexto("a esquerda"));

        // swipe para a direita
        swipePage.swipeRight();

        // verificar texto 'E veja se'
        Assert.assertTrue(swipePage.existeElementoPorTexto("E veja se"));

        // clicar botão direita
        swipePage.clicarPorTexto("›");

        // verificar texto 'Chegar até o fim!'
        Assert.assertTrue(swipePage.existeElementoPorTexto("Chegar até o fim!"));

        // swipe esquerda
        swipePage.swipeLeft();

        // clicar botão esquerda
        swipePage.clicarPorTexto("‹");

        // verificar texto 'à esquerda'
        Assert.assertTrue(swipePage.existeElementoPorTexto("a esquerda"));
    }
}
