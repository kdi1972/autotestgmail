package by.softclub;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class LoginTest {
    private static final String chromedriver = ConfProperties.getProperty("chromedriver");
    private static final String login = ConfProperties.getProperty("login");
    private static final String loginpage = ConfProperties.getProperty("loginpage");
    private static final String password = ConfProperties.getProperty("password");

    private static final String recipient = ConfProperties.getProperty("recipient");
    private static final String subject = ConfProperties.getProperty("subject");
    private static final String messagetext = ConfProperties.getProperty("messagetext");

    public static LoginPage loginPage;
    public static MailPage mailPage;
    public static WebDriver driver;
    public static TextBoxPage textBoxPage;
    /**
     * осуществление первоначальной настройки
     */
    @BeforeTest
    public static void setup() {
        //определение пути до драйвера и его настройка
        System.setProperty("webdriver.chrome.driver", chromedriver);

        driver = new ChromeDriver();

        loginPage = new LoginPage(driver);
        mailPage = new MailPage(driver);

        driver.manage().window().maximize();

        // задает максимум 10 секунд ожидания для каждого поиска
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //получение ссылки на страницу входа из файла настроек
        driver.get(loginpage);
    }

    @Test
    public  void loginTest() {
        //значение login/password берутся из файла настроек по аналогии с chromedriver
        //и loginpage
        //вводим логин
        loginPage.inputLogin(login);
        //нажимаем кнопку входа
        loginPage.clickLoginBtn();

        //вводим пароль
        loginPage.inputPasswd(password);

        //нажимаем кнопку входа
        loginPage.clickLoginBtn();

        //получаем отображаемый логин
        String user = mailPage.getUserName();
        //и сравниваем его с логином из файла настроек
        Assert.assertEquals(login, user);

        mailPage.entryMenu();
        mailPage.mailIn();

        // Ждем пока на странице не обнаружим кнопку "Написать (письмо)"
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"js-apps-container\"]/div[2]/div[8]/div/div[3]/div[2]/div[1]/div/div/div/a/span")));

        // Убеждаемся, что драйвер находится на странице "Входящие"
        Assert.assertEquals(driver.getTitle(), "1 · Входящие — Яндекс.Почта");

        //Нажимаем кнопку "Написать"
        mailPage.PushMessageBtn();
        //Вводим получаетля в поле "Кому"
        textBoxPage.inputRecipient(recipient);
        //Вводим тему письма
        textBoxPage.inputSubject(subject);
        //Вводим текст письма
        textBoxPage.inputMessageText(messagetext);
        //Нажимем кнопку "Отправить"
        textBoxPage.sendMesage();

    }

    @AfterTest
    public static void tearDown() {
        mailPage.entryMenu();
        mailPage.userLogout();
        driver.close(); }
}
