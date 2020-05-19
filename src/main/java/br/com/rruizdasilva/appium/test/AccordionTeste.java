package br.com.rruizdasilva.appium.test;

import br.com.rruizdasilva.appium.core.BaseTest;
import br.com.rruizdasilva.appium.page.AccordionPage;
import br.com.rruizdasilva.appium.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class AccordionTeste extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private AccordionPage accordionPage = new AccordionPage();

    @Test
    public void deveInteragirComAccordion(){
        //acessar menu
        menuPage.acessarAccordion();

        // clicar Op1
        accordionPage.selecionarOp1();

        // verificar texto Op1
        esperaFixa(1);
        Assert.assertEquals("Esta é a descrição da opção 1", accordionPage.obterValorOp1());
    }
}
