package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.io.IOException;

public class ContactUsPage extends BasePage {
    protected static final String CURRENT_PAGE_URL = "/index.php?controller=contact";

    @FindBy(id = "id_contact")
    private WebElement subjectHeading;
    @FindBy(id = "email")
    private WebElement emailAddress;
    @FindBy(name = "id_order")
    private WebElement orderReference;
    @FindBy(name = "MAX_FILE_SIZE")
    private WebElement fileUploadField;
    @FindBy(id = "message")
    private WebElement message;
    @FindBy(name = "id_product")
    private WebElement orderedProduct;
    @FindBy(id = "message")
    private WebElement contactUsMessage;
    @FindBy(xpath = "//*[@id='submitMessage']/span")
    private WebElement sendButton;
    @FindBy(xpath = "//*[@id='center_column']//*[@class='alert alert-success']")
    private WebElement alertMessage;
    @FindBy(xpath = "//*[@class='icon-chevron-left']//parent::span/parent::a")
    private WebElement backButton;

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected String currentPageUrl() {
        return CURRENT_PAGE_URL;
    }

    public void uploadTempFile(String prefix, String suffix) throws IOException {
        File file = File.createTempFile(prefix, suffix);
        String path = file.getAbsolutePath();
        inputFile(path);


    }

    public void inputFile(String filePath) {
        enterText(fileUploadField, filePath);
    }

    public void selectSubjectHeading(String header) {
        selectDropdownOption(subjectHeading, header);
    }

    public void selectOrderReference(String reference) {
        selectDropdownOption(orderReference, reference);
    }

    public void selectProduct(String product) {
        selectDropdownOption(orderedProduct, product);
    }

    public void brouseFile(String fileName) {
        String workingDirectory = System.getProperty("user.dir");
        File file = new File(workingDirectory + "/test-data/" + fileName + ".txt");
        enterText(fileUploadField, file.getAbsolutePath());
    }

    public void sendMessage(String text, String color)   {
        performTab();
        performTab();
        enterText(contactUsMessage, text);
        highlightElement(driver, contactUsMessage, color );
        performTab();
        performEnter(sendButton);

    }

    public String getAlertMessage() {
        waitForElementBePresent(alertMessage);
        return alertMessage.getText().trim();
    }

    public void clickBackButton(){
        jsClick(backButton);
    }

}
