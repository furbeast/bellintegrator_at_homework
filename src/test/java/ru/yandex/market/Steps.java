package ru.yandex.market;

import com.google.CustomUtils;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class Steps {
    @Step("Шаг 1. Проверка что открылся {pageName}")
    public static void checkOpenSite(WebDriver driver, String pageName) {
        System.out.println("*** 1. " + driver.getTitle().contains(pageName) + " ***");

        if (driver.getTitle().contains(pageName)) {
            Assertions.assertTrue(true);
        } else {
            CustomUtils.getScreen(driver);
            Assertions.fail("Не найдено: " + pageName);
        }
    }
}
