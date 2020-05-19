package br.com.rruizdasilva.appium.test;

import br.com.rruizdasilva.appium.core.BaseTest;
import br.com.rruizdasilva.appium.page.AlertasPage;
import br.com.rruizdasilva.appium.page.MenuPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AlertaTeste extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private AlertasPage alertasPage = new AlertasPage();

    @Before
    public void setup(){
        menuPage.acessarAlertas();
    }

    @Test
    public void deveConfirmarAlerta(){

        // clicar em alerta confirm
        alertasPage.clicarAlertaConfirm();

        // verificar os textos
        Assert.assertEquals("Info", alertasPage.obterTituloAlerta());
        Assert.assertEquals("Confirma a operação?", alertasPage.obterMensagemAlerta());

        // confirmar alerta
        alertasPage.confirmar();

        // verificar nova mensagem
        Assert.assertEquals("Confirmado", alertasPage.obterMensagemAlerta());

        // sair
        alertasPage.sair();
    }

    @Test
    public void deveClicarForaAlerta(){

        // clicar alerta simples
        alertasPage.clicarAlertaSimples();

        // clicar fora da caixa
        esperaFixa(1);
        alertasPage.clicarForaCaixa();

        // verificar que a mensagem não está presente
        Assert.assertFalse(alertasPage.existeElementoPorTexto("Pode clicar no OK ou fora da caixa para sair"));

    }
}
