package ru.yandex.market;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PageObjectYandexMarketWithSearch {

    private String selectorSearchItems = "//article[@class=\"_1O1OnAPlSR _29bSn5MwO8 cia-vs cia-cs\"]";

    private WebDriver driver;

    private List<Map<String, Object>> collectResults = new ArrayList<>();

    public PageObjectYandexMarketWithSearch(WebDriver driver) {
        this.driver = driver;
        driver.get("https://market.yandex.ru/catalog--smartfony/16814639/list?glfilter=7893318%3A153043");
    }
}
