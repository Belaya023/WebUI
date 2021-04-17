package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Moe_Delo_login {
    private static final String URL = "https://oauth.moedelo.org/Authorize";
    private static final String LOGIN = "testforgeek@mail.ru";
    private static final String PASSWORD = "StudentGeek";

    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //открытие страницы
        driver.get(URL);
        Thread.sleep(5000);

        //ввод логина
        WebElement LoginTextInput = driver.findElement(By.xpath("//input[@placeholder='E-mail']"));
        LoginTextInput.sendKeys(LOGIN);

        //ввод пароля
        WebElement passwordTextInput = driver.findElement(By.xpath("//input[@placeholder='Пароль']"));
        passwordTextInput.sendKeys(PASSWORD);

        //нажатие кнопки "Войти"
        WebElement loginButton = driver.findElement(By.xpath("//span[text()='Войти в сервис']"));
        loginButton.click();

        //закрытие браузера
        driver.quit();
    }

}
