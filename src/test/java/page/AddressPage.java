package page;


import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static util.WebElementActionsUtil.*;

public class AddressPage extends BasePage{
   protected static final String CURRENT_PAGE_URL ="/index.php";

    private String  addressNameElement = "//*[text()='Secondary Address']/../..//*[@class='address_name' and contains(text(),'%s')]";
    private String  addressCompanyElement = "//*[text()='Secondary Address']/../..//*[@class='address_company' and contains(text(),'%s')]";
    private String  addressFirstRowElement = "//*[text()='Secondary Address']/../..//*[@class='address_address1' and contains(text(),'%s')]";
    private String  addressSecondRowElement = "//*[text()='Secondary Address']/../..//*[@class='address_address2' and contains(text(),'%s')]";
    private String  addressCountryAttributes = "//*[text()='Secondary Address']/../..//span[contains(text(),'%s')]";
    private String deleteButtonByAddress = "//*[text()='%s']/../..//a[@title='Delete']";
    private String addressByTitle = "//*[@class='page-subheading' and text()='%s']";

    @FindBy(xpath = "//a[@title='Add an address']")
    private WebElement addNewAddressButton;
    @FindBy(id ="firstname")
    private WebElement firstName;
    @FindBy(id ="lastname")
    private WebElement lastName;
    @FindBy(id ="company")
    private WebElement company;
    @FindBy(id ="address1")
    private WebElement address1;
    @FindBy(id ="address2")
    private WebElement address2;
    @FindBy(id ="city")
    private WebElement city;
    @FindBy(id ="id_state")
    private WebElement state;
    @FindBy(id ="postcode")
    private WebElement postcode;
    @FindBy(id ="id_country")
    private WebElement country;
    @FindBy(id ="phone")
    private WebElement phone;
    @FindBy(id ="phone_mobile")
    private WebElement phoneMobile;
    @FindBy(id ="other")
    private WebElement other;
    @FindBy(id ="alias")
    private WebElement addressTitle;
    @FindBy(id ="submitAddress")
    private WebElement submitButton;
    @FindBy(xpath = "//*[text() = 'Secondary Address']/../..//*[@class='address_phone']")
    private WebElement addressPhone;
    @FindBy(xpath = "//*[text() = 'Secondary Address']/../..//*[@class='address_phone_mobile']")
    private WebElement addressPhoneMobile;



   public AddressPage(WebDriver driver){
       super(driver);
   }

    @Override
    protected String currentPageUrl() {
        return CURRENT_PAGE_URL;
    }

    public void clickAddNewAddressButton(){
        waitForElementBePresent(addNewAddressButton);
        addNewAddressButton.click();
    }


    public void setFirstName(String firstname){
       firstName.clear();
       enterText(firstName, firstname);
    }

    public void setLastName(String lastname){
        lastName.clear();
        enterText(lastName, lastname);
    }

    public void setCompany(String companyname){
        company.clear();
        enterText(company, companyname);
    }

    public void setFirstAddress(String address){
        address1.clear();
        enterText(address1, address);
    }

    public void setSecondAddress(String address){
        address2.clear();
        enterText(address2, address);
    }

    public void setCity(String cityname){
        city.clear();
        enterText(city, cityname);
    }

    public void setState(String statename){
        selectDropdownOption(state, statename);
    }

    public void setPostCode(String zipcode){
        postcode.clear();;
        enterText(postcode, zipcode);
    }

    public void setCountry(String countryName){
        selectDropdownOption(country, countryName);
    }

    public void setHomePhone(String phoneNumber){
        phone.clear();
        enterText(phone, phoneNumber);
    }

    public void setMobilePhone(String phoneNumber){
        phoneMobile.clear();
        enterText(phoneMobile, phoneNumber);
    }

    public void setAdditionalInformation(String aditionalInfo){
        other.clear();
        enterText(other, aditionalInfo);
    }

    public void setAddressTitle(String addresstitle){
       addressTitle.clear();
       enterText(addressTitle, addresstitle);

    }

    public void enterAddressData(String firstname, String lastname, String companyName, String address1, String address2,
                                 String city, String state, String zipcode, String country, String phone, String mobilephone,
                                 String additionalinfo,  String addresstitle){
        setFirstName(firstname);
        setLastName(lastname);
        setCompany(companyName);
        setFirstAddress(address1);
        setSecondAddress(address2);
        setCity(city);
        setState(state);
        setPostCode(zipcode);
        setCountry(country);
        setHomePhone(phone);
        setMobilePhone(mobilephone);
        setAdditionalInformation(additionalinfo);
        setAddressTitle(addresstitle);
   }

   public void clickSubmitButton(){
       submitButton.click();
   }

    public boolean isNameOnPage(String text){
        return isWebElementPresentByText(addressNameElement, text);
    }

    public boolean isCompanyNameOnPage(String text){
       return isWebElementPresentByText(addressCompanyElement, text);
    }

    public boolean isFirstAddressOnPage(String text){
       return isWebElementPresentByText(addressFirstRowElement, text);
    }

    public boolean isSecondAddressOnPage(String text){
        return isWebElementPresentByText(addressSecondRowElement, text);
    }

   public boolean isCityOnPage(String text){
       return isWebElementPresentByText(addressCountryAttributes, text);
   }

    public boolean isStateOnPage(String text){
        return isWebElementPresentByText(addressCountryAttributes, text);
    }

    public boolean isPostalCodeOnPage(String text){
        return isWebElementPresentByText(addressCountryAttributes, text);
    }

    public boolean isCountryOnPage(String text){
        return isWebElementPresentByText(addressCountryAttributes, text);
    }

    public String getAddressPhone(){
       return getWebElementText(addressPhone);
    }

    public String getAddressPhoneMobile(){
       return getWebElementText(addressPhoneMobile);
    }

    public void deleteAddressBuTitle(String title){
       xpathFormator(deleteButtonByAddress, title).click();
       acceptAlert();
    }

    public boolean isAddressOnPage(String text){
      return isWebElementPresentByText(addressByTitle, text);
    }
}
