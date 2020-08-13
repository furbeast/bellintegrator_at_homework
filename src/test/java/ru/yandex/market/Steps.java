package ru.yandex.market;

import com.google.CustomUtils;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class Steps {
    @Step("Шаг 1. Проверка что открылся {pageName}")
    public static void checkOpenSite(WebDriver driver, String pageName) {
        if (driver.getTitle().contains(pageName)) {
            Assertions.assertTrue(true);
        } else {
            CustomUtils.getScreen(driver);
            Assertions.fail("Не найдено: " + pageName);
        }
    }

    @Step("Шаг 2. Проверка что открылся {filterValue}")
    public static void checkFilterValue(WebDriver driver, String filterValue) {
        System.out.println("*** 2. " + driver.getTitle().contains(filterValue) + " ***");

        if (driver.getTitle().contains(filterValue)) {
            Assertions.assertTrue(true);
        } else {
            CustomUtils.getScreen(driver);
            Assertions.fail("Не найдено: " + filterValue);
        }
    }

//    @Step("Шаг 3. Проверка что открылся {filterValue}")
}
