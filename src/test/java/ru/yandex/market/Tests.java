package ru.yandex.market;

import org.junit.jupiter.api.Test;

public class Tests extends WebDriverSettings{

    @Test
    public void testTask2() {
        PageObjectYandexMarketWithSearch iphone = new PageObjectYandexMarketWithSearch(chromeDriver);
    }
}
