package ru.yandex.market;

import org.junit.jupiter.api.Test;

public class TestsDocker extends WebDriverSettingsDocker{

    @Test
    public void testTask3() {
        PageObjectYandexMarketWithSearch iphone = new PageObjectYandexMarketWithSearch(chromeDriver);
        Steps.checkOpenSite(chromeDriver, "Яндекс.Маркет");

        String searchVendor = "Apple";      // 2 pages
        iphone.selectFilter(searchVendor);
        Steps.checkFilterValue(chromeDriver, iphone, searchVendor);
    }
}
