package com.click.component;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Component
public class ClickComponent {
    @Scheduled(fixedRate = 86400000)
    public void click() {

        LocalDateTime date = LocalDateTime.now();
        if (!date.getDayOfWeek().equals(DayOfWeek.SATURDAY))
            return;

        WebDriver driver = getWebDriver();
        driver.get("https://sqlformat.org/");

        WebElement dataSQL = driver.findElement(By.id("id_data"));
        dataSQL.clear();
        dataSQL.sendKeys("select MyBigIntColumn, MyIntColumn, MySmallIntColumn, MyTinyIntColumn from dbo.MyTable;");

        WebElement button = driver.findElement(By.id("btn_format"));
        button.click();

//        Caso queira fechar a página web em seguida
//        driver.quit();
    }

    private static WebDriver getWebDriver() {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("enable-automation");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--disable-gpu");

        driver = new ChromeDriver(options);

        return driver;
    }
}
