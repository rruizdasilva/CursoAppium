package br.com.rruizdasilva.appium.test;

import br.com.rruizdasilva.appium.core.BaseTest;
import br.com.rruizdasilva.appium.page.FormularioPage;
import br.com.rruizdasilva.appium.page.MenuPage;
import io.appium.java_client.MobileBy;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static br.com.rruizdasilva.appium.core.DriverFactory.getDriver;

public class FormularioTeste extends BaseTest {

    private MenuPage menu = new MenuPage();
    private FormularioPage formularioPage = new FormularioPage();

    @Before
    public void inicializarAppium() throws MalformedURLException {
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        menu.acessarFormulario();
    }

    @Test
    public void devePreencherCampoTexto() throws MalformedURLException {

        /*List<MobileElement> elementosEncontrados = driver.findElements(By.className("android.widget.TextView"));
        elementosEncontrados.get(1).click();*/

        // Escrever nome
        formularioPage.escreverNome("Roger Silva");

        // Checar nome escrito
        String texto = formularioPage.obterNome();
        Assert.assertEquals("Roger Silva", texto);
    }


    @Test
    public void deveInteragirCombo() throws MalformedURLException {
        formularioPage.selecionarCombo("Nintendo Switch");

        Assert.assertEquals("Nintendo Switch", formularioPage.obterValorCombo());
    }

    @Test
    public void deveInteragirComSwitchECheckBox() throws MalformedURLException {
        Assert.assertFalse(formularioPage.isCheckMarcado());
        Assert.assertTrue(formularioPage.isSwitchMarcado());

        formularioPage.clicarCheck();
        formularioPage.clicarSwitch();

        Assert.assertTrue(formularioPage.isCheckMarcado());
        Assert.assertFalse(formularioPage.isSwitchMarcado());
    }

    @Test
    public void deveRealizarCadastro() throws MalformedURLException {
        formularioPage.escreverNome("Roger Ruiz da Silva");
        formularioPage.clicarCheck();
        formularioPage.clicarSwitch();
        formularioPage.selecionarCombo("PS4");
        formularioPage.salvar();

        // Asserts
        Assert.assertEquals("Nome: Roger Ruiz da Silva", formularioPage.obterNomeCadastrado());
        Assert.assertEquals("Console: ps4", formularioPage.obterConsoleCadastrado());
        Assert.assertTrue(formularioPage.obterCheckCadastrado().endsWith("Marcado"));
        Assert.assertFalse(formularioPage.obterSwitchCadastrado().endsWith("Marcado"));
    }

    @Test
    public void deveRealizarCadastroDemorado() throws MalformedURLException {
        formularioPage.escreverNome("Roger Ruiz da Silva");
        formularioPage.salvarDemorado();

        // Asserts
        Assert.assertEquals("Nome: Roger Ruiz da Silva", formularioPage.obterNomeCadastrado());
    }

    @Test
    public void deveAlterarData(){
        formularioPage.clicarPorTexto("01/01/2000");
        formularioPage.clicarPorTexto("20");
        formularioPage.clicarPorTexto("OK");
        Assert.assertTrue(formularioPage.existeElementoPorTexto("20/1/2000"));
    }

    @Test
    public void deveAlterarHora(){
        formularioPage.clicarPorTexto("06:00");
        formularioPage.clicar(MobileBy.AccessibilityId("10"));
        formularioPage.clicar(MobileBy.AccessibilityId("50"));
        formularioPage.clicarPorTexto("OK");
        Assert.assertTrue(formularioPage.existeElementoPorTexto("10:50"));
    }

    @Test
    public void deveInteragirComSeekBar(){
        // clicar no seekbar
        formularioPage.clicarSeekBar(0.05);

        // salvar
        formularioPage.salvar();

        // obter o valor
    }
}
