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

    public List<WebElement> getResult() {
        return result;
    }

    public PageObjectGlad(WebDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
        searchField = chromeDriver.findElement(By.xpath("//input[@name=\"q\"]"));
        searchButton = chromeDriver.findElement(By.xpath("//input[@class=\"gNO89b\"]"));
    }

    public void find(String query) {
        searchField.click();
        searchField.sendKeys(query);
        searchButton.click();
    }

    public void getListElement() {
        result = chromeDriver.findElements(By.cssSelector("h3.LC20lb.DKV0Md"));
    }
}
