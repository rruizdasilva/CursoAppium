package br.com.rruizdasilva.appium.test;

import br.com.rruizdasilva.appium.core.BaseTest;
import br.com.rruizdasilva.appium.page.DragAndDropPage;
import br.com.rruizdasilva.appium.page.MenuPage;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class DragAndDropTeste extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private DragAndDropPage dragAndDropPage = new DragAndDropPage();
    private String[] estadoInicial = {"Esta", "é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para", "qualquer local desejado."};
    private String[] estadoIntermediario = {"é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para", "Esta", "qualquer local desejado."};
    private String[] estadoFinal = {"Faça um clique longo,", "é uma lista", "Drag em Drop!", "e arraste para", "Esta", "qualquer local desejado."};

    @Test
    public void deveRealizarDragAndDrop() {
        // acessar menu
        menuPage.acessarDragAndDrop();

        // verificar estado inicial
        esperaFixa(1);
        assertArrayEquals(estadoInicial, dragAndDropPage.obterLista());

        // arrastar "Esta" ppara "e arraste para"
        dragAndDropPage.arrastar("Esta", "e arraste para");

        // verificar estado intermediário
        assertArrayEquals(estadoIntermediario, dragAndDropPage.obterLista());

        // arrastar "Faça um clico longo, " para "é uma lista"
        dragAndDropPage.arrastar("Faça um clique longo,", "é uma lista");

        // verificar estado final
        assertArrayEquals(estadoFinal, dragAndDropPage.obterLista());
    }
}
