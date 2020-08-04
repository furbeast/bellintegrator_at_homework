package com.google;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Steps {

    @Step("Шаг 1. Проверка что открылся {linkName}")
    public static void checkOpenSite(WebDriver driver, String linkName) {
        if (driver.getCurrentUrl().contains(linkName)) {
            Assertions.assertTrue(true);
        } else {
            CustomUtils.getScreen(driver);
            Assertions.fail("Ошибка при открытии страницы: " + linkName);
        }
    }

    @Step("Шаг 2. Поиск слова {searchLine}")
    public static void checkSearchLine(WebDriver driver, String searchLine) {
        if (driver.getTitle().contains(searchLine)) {
            Assertions.assertTrue(true);
        } else {
            CustomUtils.getScreen(driver);
            Assertions.fail("Не найдено: " + searchLine);
        }
    }

    @Step("Шаг 3. Убедится что результатов больше трёх")
    public static void checkMoreThreeResult(WebDriver driver, PageObjectGoogleWithSearch searchPO) {
        searchPO.getListElement();

        if (searchPO.getResult().size() > 3) {
            Assertions.assertTrue(true);
        } else {
            CustomUtils.getScreen(driver);
            Assertions.fail("Результат меньше 3");
        }
    }

    @Step("Шаг 3. Убедится что есть ссылка \"{linkName}\"")
    public static void checkResultWiki(WebDriver driver, PageObjectGoogleWithSearch searchPO, String linkName) {
        searchPO.getListElement();

        if (searchPO.getResult().stream().anyMatch(x -> x.getText().contains(linkName))) {
            Assertions.assertTrue(true);
        } else {
            CustomUtils.getScreen(driver);
            Assertions.fail("Результат \"" + linkName + "\" не найден");
        }
    }
}
