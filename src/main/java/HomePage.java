import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{
    private By bankManagerBtn = new By.ByXPath("/html/body/div/div/div[2]/div/div[1]/div[2]/button");
    private By customerBtn = new By.ByXPath("/html/body/div/div/div[2]/div/div[1]/div[1]/button");

    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void managerLogin(){getDriver().findElement(bankManagerBtn).click();}

    public void customerLogin(){getDriver().findElement(customerBtn).click();}
}
