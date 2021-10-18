package by.softclub;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;
    public  LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    /**
     * определение локатора поля ввода логина (ID)
     */
    @FindBy(xpath ="//*[@id=\"passp-field-login\"]" )
    private WebElement loginField;

    /**
     * определение локатора кнопки входа в аккаунт
     */
    @FindBy (xpath = "//*[@id=\"passp:sign-in\"]")
    private WebElement loginBtn;

    /**
     * определение локатора поля ввода пароля
     */
    @FindBy (xpath = "//*[@id=\"passp-field-passwd\"]")
    private  WebElement passwdField;

    /**
     * метод ввода логина
     */
    public void inputLogin(String login) { loginField.sendKeys(login); }

    /**
     * метод ввода пароля
     */
    public void inputPasswd(String passwd) { passwdField.sendKeys(passwd); }

    /**
     * метод для осуществления нажатия кнопки входа в аккаунт
     */
    public void clickLoginBtn() { loginBtn.click(); }
}
