package ru.yandex.market;

import org.junit.jupiter.api.Test;

public class TestsDocker extends WebDriverSettingsDocker{

    @Test
    public void testTask3() {
        PageObjectYandexMarketWithSearch iphone = new PageObjectYandexMarketWithSearch(chromeDriver);

        // костыль от капчи
        /*new WebDriverWait(chromeDriver, 30)
                .until(ExpectedConditions.presenceOfElementLocated(By.className("_3wPGpzKmmn")));*/

        Steps.checkOpenSite(chromeDriver, "Яндекс.Маркет");

//        String searchVendor = "ZTE";        // 1 pages
        String searchVendor = "Apple";      // 2 pages
//        String searchVendor = "Xiaomi";     // 3 pages

        iphone.selectFilter(searchVendor);
        Steps.checkFilterValue(chromeDriver, iphone, searchVendor);
    }
}
