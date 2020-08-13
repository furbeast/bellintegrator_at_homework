package ru.yandex.market;

import jdk.jfr.Timespan;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public class PageObjectYandexMarketWithSearch {

    private String selectorFilterVendor = "//span[text()='Apple']";
    private String selectorLoadCircle = "//div[@class='_13-JCDb2SZ _1No7Ewj2pS']";

    private String selectorResultItems = "//article[@class='_1O1OnAPlSR _29bSn5MwO8 cia-vs cia-cs']";
    private String selectorResultVendor = ".//div[@class='_1NyIdwOZ6-']";
    private String selectorResultModel = ".//h3[@class='_3dCGE8Y9v3 _25uOAS5e4A']//span";

    private String selectorNextPage = "//a[contains(@class, '_3T1NDSfqDx')]";

    private WebDriver driver;

    private List<WebElement> searchItsems = new ArrayList<>();
    private List<Map<String, Object>> collectResults = new ArrayList<>();

//    searchItsems = driver.findElements(By.xpath(selectorResultItems));

    public PageObjectYandexMarketWithSearch(WebDriver driver) {
        this.driver = driver;
        driver.get("https://market.yandex.ru/catalog--smartfony/16814639/");
    }

    public void selectFilter(WebDriver driver, String filterName) {

        // ожидание полной загрузки страницы
        new WebDriverWait(driver, 30)
                .until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

        driver.findElement(By.xpath(selectorFilterVendor)).click();     // выбор в фильтре

        // ожидание когда кружок съебёт
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath(selectorLoadCircle))));

        searchItsems = driver.findElements(By.xpath(selectorResultItems));
    }

    public List<Map<String, Object>> getCollectResults() {
        for (WebElement result : searchItsems) {
            collectResults.add(Map.of(
                    "WEB_ELEMENT", result,
                    "VENDOR", result.findElement(By.xpath(selectorResultVendor)).getText(),
                    "MODEL", result.findElement(By.xpath(selectorResultModel)).getText()
            ));
        }
        return collectResults;
    }

    public void nextPage() {
        System.out.println(driver.findElements(By.xpath(selectorNextPage)));
        System.out.println(driver.findElements(By.xpath(selectorNextPage)).size());
        System.out.println(driver.findElements(By.xpath(selectorNextPage)).toString());
    }
}
