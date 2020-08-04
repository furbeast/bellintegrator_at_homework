package com.google;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Steps {

    @Step("Шаг 1. Проверка что открылся {linkName}")
    public static void checkOpenSite(WebDriver driver, String linkName) {
        Assertions.assertTrue(driver.getCurrentUrl().contains(linkName));
    }

    @Step("Шаг 2. Поиск слова {searchLine}")
    public static void checkSearchLine(WebDriver driver, String searchLine) {
        Assertions.assertTrue(driver.getTitle().contains(searchLine));
    }

    @Step("Шаг 3. Убедится что результатов больше трёх")
    public static void checkMoreThreeResult(PageObjectGoogleWithSearch searchPO) {
        searchPO.getListElement();
        Assertions.assertTrue(searchPO.getResult().size() > 3);
    }

    @Step("Шаг 3. Убедится что есть ссылка \"{linkName}\"")
    public static void checkResultWiki (PageObjectGoogleWithSearch searchPO, String linkName) {
        searchPO.getListElement();
        Assertions.assertTrue(searchPO.getResult().stream().anyMatch(x -> x.getText().contains(linkName)));
    }
}
