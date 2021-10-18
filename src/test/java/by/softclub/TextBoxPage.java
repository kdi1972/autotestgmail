package by.softclub;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBoxPage {

    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;
    public TextBoxPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    /**
     * определение локатора заголовка окна "Новое письмо"
     */
    @FindBy(xpath ="//*[@id=\"nb-1\"]/body/div[3]/div[11]/div/div/div[2]/div/div[1]/div/div[1]/span/span" )
    private WebElement titleWindownewMessage;

    /**
     * определение локатора кнопки отправки письма
     */
    @FindBy(xpath = "//*[@id=\"js-apps-container\"]/div[2]/div[11]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/div[2]/div/div[1]/div[1]/button")
    private WebElement sendMessagelBtn;

    /**
     * определение локатора поля "Кому"
     */
    @FindBy(xpath = "//div[@class='MultipleAddressesDesktop-Field ComposeYabblesField']/ancestor::div[@class='MultipleAddressesDesktop ComposeRecipients-MultipleAddressField ComposeRecipients-ToField tst-field-to']")
    private WebElement recipientField;

    /**
     * определение локатора поля "Написать самому себе"
     */
    @FindBy (xpath = "//*[@id=\"js-apps-container\"]/div[2]/div[11]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/div[1]/div/div[1]/div[3]/div/div[1]/div")
    private  WebElement recipientFieldAdd;

    /**
     * определение локатора поля "Тема"
     */
    @FindBy(xpath = "//*[@id=\"js-apps-container\"]/div[2]/div[11]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/div[1]/div/div[1]/div[1]/div[3]/div/div/input")
    private WebElement subjectField;

    /**
     * определение локатора тела письма
     */
    @FindBy(xpath = "//*[@id=\"cke_1_contents\"]/div")
    private WebElement messageField;

    /**
     * метод для нажатия кнопки "Отпрвить письмо"
     */
    public void sendMesage() {
        sendMessagelBtn.click(); }

    /**
     * метод ввода данных в поле "Кому"
     */
    public void inputRecipient(String recipient) { recipientField.sendKeys(recipient); }

    /**
     * метод ввода данных в поле "Тема"
     */
    public void inputSubject(String subject) { subjectField.sendKeys(subject); }

    /**
     * метод ввода текста письма
     */
    public void inputMessageText(String messagetext) { messageField.sendKeys(messagetext); }


}
