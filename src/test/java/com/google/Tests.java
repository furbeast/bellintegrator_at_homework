package com.google;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Tests extends WebDriverSettings {

    @Test
    public void searchGladThree(){
        chromeDriver.get("https://www.google.com/");
        PageObjectGlad gladPO = new PageObjectGlad(chromeDriver);

        gladPO.find("гладиолус");
        gladPO.getListElement();

        Assertions.assertTrue(gladPO.getResult().size() > 3);
    }

    @Test
    public void searchGladWiki() {
        chromeDriver.get("https://www.google.com/");
        PageObjectGlad gladPO = new PageObjectGlad(chromeDriver);

        gladPO.find("гладиолус");
        gladPO.getListElement();

        Assertions.assertTrue(gladPO.getResult().stream().anyMatch(x -> x.getText().contains("Гладиолус — Википедия")));
    }
}
