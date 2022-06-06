import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class BankingTest {

    private WebDriver driver;
    private WebDriverWait driverWait;
    private HomePage homePage;
    private ManagerPage managerPage;
    private CustomerPage customerPage;

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driverWait = new WebDriverWait(driver, Duration.ofSeconds(15));

        homePage = new HomePage(driver,driverWait);
        managerPage = new ManagerPage(driver,driverWait);
        customerPage = new CustomerPage(driver,driverWait);
        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }

    @Test (priority = 1)
    public void bankManagerLogin(){
        homePage.managerLogin();
        Assert.assertTrue(managerPage.isDisplayedAddCustomerBtn());
    }

    @Test (priority = 2)
    public void createCustomer(){
        managerPage.createCustomer("Ivan","Ivanovic", "21000");
        List<WebElement> count = driver.findElements(By.xpath("//*[@id=\"userSelect\"]"));
        Assert.assertEquals(count.size(), 6);
    }
    @Test (priority = 4)
    public void customerLogin(){
        customerPage.customerLogin();
        Assert.assertTrue(customerPage.isDisplayedLogoutBtn());
    }

    @Test (priority = 3)
    public void creatingAccountForCustomer(){
        driverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/div/div[1]/button[2]")));
        managerPage.createAccountForCustomer();
        List<WebElement> count = driver.findElements(By.xpath(
                "/html/body/div/div/div[2]/div/div[2]/div/div/table/tbody/tr[6]/td[4]"));
        Assert.assertEquals(count.size(), 1);
    }
    @Test (priority = 5)
    public void customerLogout(){
        Assert.assertTrue(customerPage.isDisplayedLogoutBtn());
        customerPage.customerLogout();
        Assert.assertTrue(driver.findElement(By.id("userSelect")).isDisplayed());
    }
    
}
