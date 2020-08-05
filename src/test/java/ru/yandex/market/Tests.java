package ru.yandex.market;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class Tests extends WebDriverSettings{

    @Test
    public void testTask2() {
        PageObjectYandexMarketWithSearch iphone = new PageObjectYandexMarketWithSearch(chromeDriver);

        List<Map<String, Object>> resultSearch = iphone.getCollectResults();

        resultSearch.stream().forEach(x -> System.out.println(x.get("VENDOR").toString()));
    }
}
