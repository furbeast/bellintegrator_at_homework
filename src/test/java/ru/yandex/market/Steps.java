package ru.yandex.market;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;


public class Steps {
    @Step("Шаг 1. Проверка что открылся {pageName}")
    public static void checkOpenSite(WebDriver driver, String pageName) {
        if (driver.getTitle().toLowerCase().contains(pageName.toLowerCase())) {
            Assertions.assertTrue(true);
        } else {
            CustomUtils.getScreen(driver);
            Assertions.fail("Не найдено: " + pageName);
        }
    }

    @Step("Шаг 2. Проверка что все элементы {filterValue}")
    public static void checkFilterValue(WebDriver driver, PageObjectYandexMarketWithSearch pageObject, String filterValue) {
        if (pageObject.checkResultAllPages(filterValue)) {
            Assertions.assertTrue(true);
        } else {
            CustomUtils.getScreen(driver);
            Assertions.fail("Не все элементы равны " + filterValue);
        }
    }
}
