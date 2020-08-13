package ru.yandex.market;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;

public class Tests extends WebDriverSettings{

    @Test
    public void testTask2() {
        PageObjectYandexMarketWithSearch iphone = new PageObjectYandexMarketWithSearch(chromeDriver);

        // костыль от капчи
        new WebDriverWait(chromeDriver, 30)
                .until(ExpectedConditions.presenceOfElementLocated(By.className("_3wPGpzKmmn")));

        Steps.checkOpenSite(chromeDriver, "Яндекс.Маркет");

        iphone.selectFilter(chromeDriver, "Apple");
//        Steps.checkFilterValue(chromeDriver, "iPhone");

        List<Map<String, Object>> resultSearch = iphone.getCollectResults();

        resultSearch.stream().forEach(x -> System.out.println(x.get("VENDOR").toString() + " " + x.get("MODEL").toString() + " " + x.get("PRICE").toString()));
    }
}
