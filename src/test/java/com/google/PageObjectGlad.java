package com.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PageObjectGlad {

    private WebDriver chromeDriver;
    private WebElement searchField;
    private WebElement searchButton;
    private List<WebElement> result;

    public PageObjectGlad(WebDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
        searchField = chromeDriver.findElement(By.cssSelector("div.a4bIc > input.gLFyf.gsfi"));
        searchButton = chromeDriver.findElement(By.cssSelector("div.tfB0Bf > center > input.gNO89b"));
    }

    public void find(String query) {
        searchField.click();
        searchField.sendKeys(query);
        searchButton.click();
    }
}
