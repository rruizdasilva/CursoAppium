package br.com.rruizdasilva.appium.test;

import br.com.rruizdasilva.appium.core.BaseTest;
import br.com.rruizdasilva.appium.page.AbasPage;
import br.com.rruizdasilva.appium.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class AbasTeste extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private AbasPage abasPage = new AbasPage();

    @Test
    public void deveInteragirComAbaS(){
        // acessar menu abas
        menuPage.acessarAbas();

        // verificar que está na aba 1
        Assert.assertTrue(abasPage.isAba1());

        // acessar aba 2
        abasPage.selecionarAba2();

        // verificar que está na aba 2
        Assert.assertTrue(abasPage.isAba2());
    }
}
