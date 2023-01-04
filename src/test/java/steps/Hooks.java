package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import static driver.DriverProvider.driver;

public class Hooks {
    @Before
    public void setUpDriver() {
        driver().manage().window().maximize();
    }
    @After
    public void afterScenario() {
        driver().close();
        driver().quit();
    }
}
