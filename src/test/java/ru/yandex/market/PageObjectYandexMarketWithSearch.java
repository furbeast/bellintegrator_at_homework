package ru.yandex.market;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PageObjectYandexMarketWithSearch {

    private String selectorResultItems = "//article[@class=\"_1O1OnAPlSR _29bSn5MwO8 cia-vs cia-cs\"]";
    private String selectorResultVendor = "//article[@class=\"_1O1OnAPlSR _29bSn5MwO8 cia-vs cia-cs\"]//div[@class=\"_1NyIdwOZ6-\"]";
    private String selectorResultModel = "//article[@class=\"_1O1OnAPlSR _29bSn5MwO8 cia-vs cia-cs\"]//h3//span";
    private String selectorResultPrice = "//article[@class=\"_1O1OnAPlSR _29bSn5MwO8 cia-vs cia-cs\"]//div[@class=\"_1PaCzxbbzN _3f2ZtYT7NH _2Sc2mRSDwb\"]//span/span[1]";

    private WebDriver driver;

    private List<WebElement> searchItsems = new ArrayList<>();
    private List<Map<String,Object>> collectResults = new ArrayList<>();

    public PageObjectYandexMarketWithSearch(WebDriver driver) {
        this.driver = driver;
        driver.get("https://market.yandex.ru/catalog--smartfony/16814639/list?glfilter=7893318%3A153043");
        searchItsems = driver.findElements(By.xpath(selectorResultItems));
    }

    public List<Map<String, Object>> getCollectResults() {
        for (WebElement result : searchItsems) {
            collectResults.add(Map.of(
                    "WEB_ELEMENT", result,
                    "VENDOR", result.findElement(By.xpath(selectorResultVendor)).getText(),
                    "Model", result.findElement(By.xpath(selectorResultModel)).getText(),
                    "PRICE", result.findElement(By.xpath(selectorResultPrice)).getText()
            ));
        }
        return collectResults;
    }
}
