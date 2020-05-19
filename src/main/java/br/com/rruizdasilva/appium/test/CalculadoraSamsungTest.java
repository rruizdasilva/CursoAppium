package br.com.rruizdasilva.appium.test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculadoraSamsungTest {

    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "5200fd1d4a085575");
        desiredCapabilities.setCapability("automationName", "uiautomator2");
        desiredCapabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
        desiredCapabilities.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");

        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    }

    @Test
    public void somaDoisValores() {
        MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("2");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("Mais");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("2");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("4 Visualizar resultado");
        System.out.println(el4.getText());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
