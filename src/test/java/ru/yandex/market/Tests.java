package ru.yandex.market;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Tests extends WebDriverSettings{

    @Test
    public void testTask2() {
        PageObjectYandexMarketWithSearch iphone = new PageObjectYandexMarketWithSearch(chromeDriver);

        // костыль от капчи
        new WebDriverWait(chromeDriver, 30)
                .until(ExpectedConditions.presenceOfElementLocated(By.className("_3wPGpzKmmn")));

        Steps.checkOpenSite(chromeDriver, "Яндекс.Маркет");

//        String searchVendor = "ZTE";        // 1 pages
        String searchVendor = "Apple";      // 2 pages
//        String searchVendor = "Xiaomi";     // 3 pages

        iphone.selectFilter(searchVendor);
        Steps.checkFilterValue(chromeDriver, iphone, searchVendor);
    }
}
