package com.google;

import org.junit.jupiter.api.Test;

public class Tests extends WebDriverSettings {

    @Test
    public void searchGladThree(){
        chromeDriver.get("https://www.google.com/");
    }
}
