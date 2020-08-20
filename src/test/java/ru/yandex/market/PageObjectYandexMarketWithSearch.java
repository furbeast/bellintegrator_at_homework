package ru.yandex.market;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PageObjectYandexMarketWithSearch {
    private final String selectorLoadShadow = "//div[@class='_2LvbieS_AO _1oZmP3Lbj2']";
    private final String selectorResultItems = "//article[@class='_1O1OnAPlSR _29bSn5MwO8 cia-vs cia-cs']";
    private final String selectorResultVendor = ".//div[@class='_1NyIdwOZ6-']";
    private final String selectorResultModel = ".//h3[@class='_3dCGE8Y9v3 _25uOAS5e4A']//span";
    private final String selectorNextPage = "//a[contains(@class, '_3T1NDSfqDx')]";

    private WebDriver driver;


    public PageObjectYandexMarketWithSearch(WebDriver driver) {
        this.driver = driver;
        driver.get("https://market.yandex.ru/catalog--smartfony/16814639/");
//        driver.get("https://2ip.ru/");
    }

    public void selectFilter(String filterName) {
        waitLoadBefore();
        driver.findElement(By.xpath("//span[text()='" + filterName + "']")).click();     // выбор в фильтре
        waitLoadBefore(selectorLoadShadow);
    }

    public List<Map<String, Object>> getCollectResults() {
        List<WebElement> searchItsems = driver.findElements(By.xpath(selectorResultItems));
        List<Map<String, Object>> collectResults = new ArrayList<>();

        for (WebElement result : searchItsems) {
            collectResults.add(Map.of(
                    "WEB_ELEMENT", result,
                    "VENDOR", result.findElement(By.xpath(selectorResultVendor)).getText(),
                    "MODEL", result.findElement(By.xpath(selectorResultModel)).getText()
            ));
        }
        return collectResults;
    }

    public boolean checkResultAllPages(String filterValue) {
        int countPages = driver.findElements(By.xpath(selectorNextPage)).size();
        String currentURL = driver.getCurrentUrl();
        int page = 1;

        do {
            if (page >= 2) {
                driver.findElement(By.xpath("//a[@aria-label='Страница " + page + "']")).click();
                waitLoadBefore(selectorLoadShadow);
            }

            List<Map<String, Object>> resultSearch = getCollectResults();

            if (!resultSearch.stream().allMatch(x -> x.get("VENDOR").toString().toLowerCase().equals(filterValue.toLowerCase()))) {
                return false;
            }

            page++;
        } while (page <= countPages);

        return true;
    }

    // ожидание полной загрузки страницы
    private void waitLoadBefore() {
        new WebDriverWait(driver, 30)
                .until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    // ожидание когда уйдёт что-то
    private void waitLoadBefore(String param) {
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath(param))));
    }
}
