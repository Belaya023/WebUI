package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class CRM1_creating_organization {

    private static final String URL = "https://crm.geekbrains.space/user/login";
    private static final String LOGIN = "Applanatest";
    private static final String PASSWORD = "Student2020!";

    public static void main(String[] args) throws InterruptedException{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        //login();
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

       //клик на "Проекты"
        driver.findElement(By.xpath("//span[text()='Проекты']")).click();

        //клик на выпад.список "Мои проекты"
        driver.findElement(By.xpath("//span[text()='Мои проекты']")).click();

        //клик на кнопку "Создать проект"
        driver.findElement(By.xpath("//a[text()='Создать проект']")).click();
        Thread.sleep(5000);

        //Наименование
        driver.findElement(By.name("crm_project[name]")).sendKeys("Рога и копыта");

        //Организация
        driver.findElement(By.xpath("//span[text()='Укажите организацию']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/div/input")).sendKeys("1234");
        driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/div/input")).sendKeys(Keys.ENTER);

        //Тип
        driver.findElement(By.xpath("//label[text()='Внутренний']")).click();

        //Приоритет
        Select priority = new Select(driver.findElement(By.id("crm_project_priority-uid-6066fd7b7f68f")));
        priority.selectByValue("2");

        //Финансирование
        Select finance = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
        finance.selectByValue("1");

        //Подразделение
        Select subdivision = new Select(driver.findElement(By.id("crm_project_businessUnit-uid-6066fd7b960b4")));
        subdivision.selectByValue("1");

        //Куратор проекта
        Select curator = new Select(driver.findElement(By.id("crm_project_curator-uid-6066fd7bb755d")));
        curator.deselectByVisibleText("Гикбрейнс Студент");

        //Руководитель проекта
        Select leader = new Select(driver.findElement(By.id("crm_project_rp-uid-6066fd7baf52b")));
        leader.deselectByVisibleText("Студентов Студент");

        //Администратор проекта
        Select admin = new Select(driver.findElement(By.id("crm_project_administrator-uid-6066fd7b8cb77")));
        admin.deselectByVisibleText("Гикбрейнс Студент");

        //Менеджер
        Select manager = new Select(driver.findElement(By.id("crm_project_manager-uid-6066fd7b9f2b7")));
        manager.deselectByVisibleText("Applanatest Applanatest Applanatest");

        //Основное контактное лицо
        driver.findElement(By.id("s2id_crm_project_contactMain-uid-6066fd7bbb80c")).click();
        driver.findElement(By.id("s2id_crm_project_contactMain-uid-6066fd7bbb80c")).sendKeys("Иванов Иван");

        //Клик на "Сохранить и закрыть"
        driver.findElement(By.xpath("//button[contains(.,'Сохранить и закрыть')]")).click();

        //закрытие браузера
        driver.quit();
    }

    /*private static void login () throws InterruptedException {
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

        //закрытие браузера
        //driver.quit();
    }*/


}
