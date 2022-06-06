import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerPage extends BasePage{
    private By customerSelect = new By.ById("userSelect");
    private Select customerName = new Select(getDriver().findElement(By.id("userSelect")));
    private By loginBtn = new By.ByXPath("/html/body/div/div/div[2]/div/form/button");
    private By logoutBtn = new By.ByXPath("/html/body/div/div/div[1]/button[2]");


    public CustomerPage(WebDriver driver, WebDriverWait driverWait) {super(driver, driverWait);}

    public void customerSelectDropDown(){getDriver().findElement(customerSelect).click();}

    public void customerLogin (){
        customerSelectDropDown();
        customerName.selectByValue("6");
        getDriver().findElement(loginBtn).click();
    }
    public String getMessage(){return getDriver().findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/strong")).getText();}

    public boolean isDisplayedLogoutBtn(){return getDriver().findElement(logoutBtn).isDisplayed();}

    public void customerLogout(){getDriver().findElement(logoutBtn).click();}


}
