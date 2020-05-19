package br.com.rruizdasilva.appium.page;

import br.com.rruizdasilva.appium.core.BasePage;
import org.openqa.selenium.By;

public class AlertasPage extends BasePage {

    public void clicarAlertaConfirm(){
        clicarPorTexto("ALERTA CONFIRM");
    }

    public String obterTituloAlerta(){
        return obterTexto(By.id("android:id/alertTitle"));
    }

    public String obterMensagemAlerta(){
        return obterTexto(By.id("android:id/message"));
    }

    public void confirmar(){
        clicarPorTexto("CONFIRMAR");
    }

    public void sair(){
        clicarPorTexto("SAIR");
    }

    public void clicarAlertaSimples(){
        clicarPorTexto("ALERTA SIMPLES");
    }

    public void clicarForaCaixa(){
        tap(100, 150);
    }
}
