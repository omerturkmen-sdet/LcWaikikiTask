package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.BrowserUtils;
import utilities.Driver;

import java.time.Duration;

public class Hooks {

    @Before
    public void setup(){
        Driver.get().manage().window().maximize();
        Driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @After
    public void teardown(){
        BrowserUtils.wait(2);
        Driver.closeDriver();
    }
}
