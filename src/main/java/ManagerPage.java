import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ManagerPage extends BasePage{
    private By addCustomerBtn = new By.ByXPath("/html/body/div/div/div[2]/div/div[1]/button[1]");
    private By firstName = new By.ByXPath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[1]/input");
    private By lastName = new By.ByXPath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[2]/input");
    private By postalCode = new By.ByXPath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[3]/input");
    private By customerSubmitBtn = new By.ByXPath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button");
    private By openAccountBtn = new By.ByXPath("/html/body/div/div/div[2]/div/div[1]/button[2]");
    private By customerDropDownBtn = new By.ById("userSelect");
    public Select customerName = new Select(getDriver().findElement(By.id("userSelect")));
    private By currencyBtn = new By.ById("currency");
    private Select currency = new Select(getDriver().findElement(By.id("currency")));
    private By process = new By.ByXPath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button");
    private By logoutBtn = new By.ByXPath("/html/body/div/div/div[1]/button[2]");


    public ManagerPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }



    public By setLogoutBtn() {
        return logoutBtn;
    }
    public boolean isDisplayedAddCustomerBtn(){return getDriver().findElement(addCustomerBtn).isDisplayed();}
    public void loginAsCustomer(){getDriver().findElement(addCustomerBtn).click();}

    public void enterFirstName(String firstName){getDriver().findElement(this.firstName).sendKeys(firstName);}
    public void enterLastName(String lastName){getDriver().findElement(this.lastName).sendKeys(lastName);}
    public void enterPostalCode(String postalCode){getDriver().findElement(this.postalCode).sendKeys(postalCode);}
    public void clickCustomerSubmitBtn(){getDriver().findElement(customerSubmitBtn).click();}

    public void createCustomer(String firstName, String lastName, String postalCode){
        enterFirstName(firstName);
        enterLastName(lastName);
        enterPostalCode(postalCode);
        clickCustomerSubmitBtn();
    }

    public void openAccount(){getDriver().findElement(openAccountBtn).click();}

    public void customerNameDropDown(){getDriver().findElement(customerDropDownBtn).click();}
    public void currencyDropDown(){getDriver().findElement(currencyBtn).click();}

    public void createAccountForCustomer(){
        customerNameDropDown();
        customerName.selectByValue("6");
        currencyDropDown();
        currency.selectByValue("Dollar");
        getDriver().findElement(process).click();
    }
}
