package com.google;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests extends WebDriverSettings {

    private String linkName = "https://www.google.com/";

    @Test
    public void testTask1_1(){

        PageObjectGoogleWithSearch gladPO = new PageObjectGoogleWithSearch(chromeDriver, linkName);
        Steps.checkOpenSite(chromeDriver, "google");

        gladPO.find("гладиолус");
        Steps.checkSearchLine(chromeDriver, "гладиолус");

        Steps.checkMoreThreeResult(chromeDriver, gladPO);
    }

    @Test
    public void testTask1_2() {

        PageObjectGoogleWithSearch gladPO = new PageObjectGoogleWithSearch(chromeDriver, linkName);
        Steps.checkOpenSite(chromeDriver, "google");

        gladPO.find("гладиолус");
        Steps.checkSearchLine(chromeDriver, "гладиолус");

        Steps.checkResultWiki(chromeDriver, gladPO, "Гладиолус — Википедия");
    }
}
