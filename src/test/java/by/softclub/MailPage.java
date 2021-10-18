package by.softclub;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MailPage {
    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;
    public MailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }
    /**
     * определение локатора меню пользователя
     */
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/header/div[2]/div[2]/div/div/a[1]/div/img")
    private WebElement userMenu;
    /**
     * определение локатора имени пользователя
     */
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[3]/main/div/div/div/div[1]/div/div/div/div[1]/div[2]/div[2]/div[1]/div[2]/div")
    private WebElement userNameLogin;

    /**
     * определение локатора кнопки "Почта"
     */
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/header/div[2]/div[2]/div/div/div/ul/ul/li[1]/a/span")
    private WebElement mailBoxBtn;

    /**
     * определение локатора кнопки "написать (письмо)"
     */
    @FindBy(xpath = "//*[@id=\"js-apps-container\"]/div[2]/div[8]/div/div[3]/div[2]/div[1]/div/div/div/a/span")
    private WebElement writeMessageBtn;

    /**
     * определение локатора кнопки "входящие"
     */
    @FindBy(xpath = "//*[@id=\"nb-1\"]/body/div[15]/div/div[1]/div[2]/a")
    private WebElement inboxBtn;

    /**
     * определение локатора кнопки выхода из аккаунта
     */
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/header/div[2]/div[2]/div/div/div/ul/ul/li[6]/a")
    private WebElement logoutBtn;

    /**
     * метод для получения имени пользователя из меню пользователя
     */
    public String getUserName() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/main/div/div/div/div[1]/div/div/div/div[1]/div[2]/div[2]/div[1]/div[2]/div")));
        String userName = userNameLogin.getText();
        return userName; }

    /**
     * метод для нажатия кнопки меню пользователя
     */
    public void entryMenu() {
        userMenu.click(); }

    /**
     * метод для нажатия кнопки "Почта"
     */
    public void mailIn() {
        mailBoxBtn.click(); }

    /**
     * метод для нажатия кнопки "написать письмо"
     */
    public void PushMessageBtn() {
        writeMessageBtn.click(); }

    /**
     * метод для возврата во "Входящие"
     */
    public void getIndox() {
        inboxBtn.click(); }

    /**
     * метод для нажатия кнопки выхода из аккаунта
     */
    public void userLogout() {
        logoutBtn.click(); }

}
