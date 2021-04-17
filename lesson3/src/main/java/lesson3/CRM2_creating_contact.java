package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class CRM2_creating_contact {
    private static final String URL = "https://crm.geekbrains.space/user/login";
    private static final String LOGIN = "Applanatest";
    private static final String PASSWORD = "Student2020!";

    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //открытие страницы
        driver.get(URL);
        Thread.sleep(5000);

        //ввод логина
        WebElement LoginTextInput = driver.findElement(By.id("prependedInput"));
        LoginTextInput.sendKeys(LOGIN);

        //ввод пароля
        WebElement passwordTextInput = driver.findElement(By.id("prependedInput2"));
        passwordTextInput.sendKeys(PASSWORD);

        //нажатие кнопки "Войти"
        WebElement loginButton = driver.findElement(By.id("_submit"));
        loginButton.click();

        //клик на Контрагенты
        driver.findElement(By.xpath("//span[text()='Контрагенты']")).click();

        //клик на выпад.список "Контактне лица"
        driver.findElement(By.xpath("//span[text()='Контактные лица']")).click();

        //клик на "Создать контактное лицо"
        driver.findElement(By.xpath("//a[text()='Создать контактное лицо']")).click();

        //заполнить Фамилия
        driver.findElement(By.id("crm_contact_lastName-uid-60682611a147f")).sendKeys("Пупочкин");

        //заполнить Имя
        driver.findElement(By.id("crm_contact_firstName-uid-60682611a13c2")).sendKeys("Паша");

        //Организация
        driver.findElement(By.xpath("//span[text()='Укажите организацию']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/div/input")).sendKeys("1234");
        driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/div/input")).sendKeys(Keys.ENTER);

        //Должность
        driver.findElement(By.id("crm_contact_jobTitle-uid-60682611a1560")).sendKeys("Менеджер");

        //Статус
        Select status = new Select(driver.findElement(By.id("crm_contact_status-uid-60682611a6028")));
        status.selectByValue("1");

        //Клик на "Сохранить и закрыть"
        driver.findElement(By.xpath("//button[text()='Сохранить и закрыть'")).click();

        //закрытие браузера
        driver.quit();
    }
}
