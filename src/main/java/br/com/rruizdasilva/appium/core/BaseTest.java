package br.com.rruizdasilva.appium.core;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static br.com.rruizdasilva.appium.core.DriverFactory.getDriver;
import static br.com.rruizdasilva.appium.core.DriverFactory.killDriver;

public class BaseTest {

    @Rule
    public TestName testName = new TestName();

    @BeforeClass
    public static void esperaImplicita(){
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void finalizaClasse(){
        killDriver();
    }

    @After
    public void tearDown() {
        gerarScreenShot();
        DriverFactory.getDriver().resetApp();
    }

    private void gerarScreenShot(){
        File imagem = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(imagem, new File("target//screenshots//" + testName.getMethodName() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void esperaFixa(int tempo) {
        try {
            Thread.sleep(tempo * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
