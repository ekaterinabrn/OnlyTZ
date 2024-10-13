import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private WebDriver driver;
    private WebDriverWait wait;
    //
    private final By homeFooter = By.cssSelector("div.hkYUoj > div");
// селектор поля в контакте в футере
private final By homeVK = By.xpath(".//footer//span[contains(text(), 'Vkontakte')]") ;
    //селектор поля начать проект
private final By startProject = By.xpath("//p[@class=\"sc-222969c7-1 eNylzl\" and text()='Начать проект']") ;
    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5)); // Увеличенное время ожидания
    }
    public void open() {
        driver.get(Url.BASE_URL);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    // Метод прокрутки футеру
    public MainPage scrollToFooter() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(homeFooter));
        return this;
    }
    //доступность клика на ВК в футере
    public  boolean footerVK() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(homeVK));
        return driver.findElement(homeVK).isDisplayed();
    }
    //начать проект  получить текст
    public String getTextStartProject(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(startProject));
        WebElement startProjectField = wait.until(ExpectedConditions.visibilityOfElementLocated(startProject));
        return startProjectField.getText();
    }
}
