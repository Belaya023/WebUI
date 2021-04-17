package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Moe_Delo_new_employee {
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

        //клик на "Контрагенты"
        driver.findElement(By.xpath("//a[text()='Контрагенты']")).click();

        //клик на "Добавить"
        driver.findElement(By.xpath("//*[@id=\"buttonsBarRegion\"]/div/div/div/button")).click();

        //клик на выпад.список "Физическое лицо"
        driver.findElement(By.xpath("//li[@class='js-create js-fl']")).click();

        //Покупатель/поставщик
        Select customer = new Select(driver.findElement(By.xpath("//div[@class='mdDropdown mdSelect mdSelect--select']")));
        customer.selectByValue("0");

        //ФИО
        driver.findElement(By.xpath("//*[@id=\"kontragentCommonInfoMainRegion\"]/div/div[4]/div/input")).sendKeys("Воландеморт Кошмар Ужасный");

        //Расчетные счета
        driver.findElement(By.xpath("//input[@placeholder='Р/сч']")).sendKeys("12345678987654321234");

        //БИК
        driver.findElement(By.xpath("//input[@data-bind='BankName']")).sendKeys("\"БАНК \"МБА-МОСКВА\" ООО");
        driver.findElement(By.xpath("//input[@data-bind='BankName']")).sendKeys(Keys.ENTER);


        //закрытие браузера
        //driver.quit();
    }
}
