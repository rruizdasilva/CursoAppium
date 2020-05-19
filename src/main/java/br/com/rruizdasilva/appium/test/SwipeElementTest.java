package br.com.rruizdasilva.appium.test;

import br.com.rruizdasilva.appium.core.BaseTest;
import br.com.rruizdasilva.appium.page.MenuPage;
import br.com.rruizdasilva.appium.page.SwipeListPage;
import org.junit.Assert;
import org.junit.Test;

public class SwipeElementTest extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private SwipeListPage swipeListPage = new SwipeListPage();

    @Test
    public void deveInteragirComSwipeList(){

        menuPage.acessarSwipeList();
        swipeListPage.swipeElementRight("Opção 1");
        swipeListPage.clicarNoBotaoMais();
        Assert.assertTrue(swipeListPage.existeElementoPorTexto("Opção 1 (+)"));
        swipeListPage.swipeElementRight("Opção 4");
        swipeListPage.clicarPorTexto("(-)");
        Assert.assertTrue(swipeListPage.existeElementoPorTexto("Opção 4 (-)"));
        swipeListPage.swipeElementLeft("Opção 5 (-)");
        Assert.assertTrue(swipeListPage.existeElementoPorTexto("Opção 5"));
    }
}
