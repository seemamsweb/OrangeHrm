package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	
	@Before
    public void setup() {
        DriverFactory.initDriver();
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
