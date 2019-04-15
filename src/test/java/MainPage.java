import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import java.util.List;


public class MainPage {
    private static WebDriver driver;
    private WebDriverWait wait;



    public MainPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
    }

    @FindBy (xpath = "//button[contains(text(),'YES')]")
    private WebElement modalContent;

    @FindBy (xpath = "//a[contains(text(),'WHO WE SERVE')]")
    private WebElement wheWeServeIsDisplay;

    @FindBy (xpath = "//a[contains(text(),'SUBJECTS')]")
    private WebElement subjectISDisplay;

    @FindBy (xpath = "//a[contains(text(),'ABOUT')]")
    private WebElement aboutIsDisplay;

    @FindBy (xpath = "//a[@title='Students']")
    private WebElement clickStudentsItem;

    @FindBy (xpath = "//div[@id='Level1NavNode2']/ul/li/a[@title='with submenu'][contains(text(),'Education')]")
    private WebElement educationIsDisplayAndClick;


    @FindBy (xpath = "//div[@id='Level1NavNode2']/ul/li/a[@title='with submenu'][contains(text(),'Education')]")
    private WebElement educationandClick;

    @FindBy (xpath = "//img[@title='Wiley']")
    private WebElement clickLogo;

    @FindBy (xpath = "//button[@type='submit']")
    private WebElement searchButtonClick;


    @FindBy(xpath = "//div[@class = 'search-list']/div") //Suggestions
    private List<WebElement> searchSuggetions;

    @FindBy(xpath = "//form/aside[@id='ui-id-2']/section[@class='searchresults-section related-content-products-section']/div//a")
    private List<WebElement> searchProducts;

    @FindBy (xpath = "//input[@id='js-site-search-input']")
    private WebElement searchInput;

    public void setSerchInput() {
        searchInput.sendKeys("Java");
    }

    public void checkNumberOfItemsInSearchProducts(int expectedNumberOfItemsInSearchProducts) {
        Assert.assertEquals(null, expectedNumberOfItemsInSearchProducts, searchProducts.size());
    }

    public void checkNumberOfItemsInSearchSuggetions(int expectedNumberOfItemsSearchSuggetions) {
        Assert.assertEquals(null, expectedNumberOfItemsSearchSuggetions, searchSuggetions.size());
    }

    public void setSerchButtonClick() {
        searchButtonClick.click();
    }

    public void setClickLogo() {
        clickLogo.click();
    }

    public void setEducationandClick() {
        educationandClick.click();
    }


    public void setEducationIsDisplayAndClick() {
        educationIsDisplayAndClick.isDisplayed();

    }

    public void setClickStudentsItem() {
        clickStudentsItem.click();
    }

    public void setAboutIsDisplay() {
        aboutIsDisplay.isDisplayed();
    }

    public void setSubjectISDisplay() {
        subjectISDisplay.isDisplayed();
    }

    public void setWheWeServeIsDisplay() {
        wheWeServeIsDisplay.isDisplayed();
    }

    public void openLinck(){
        driver.get("https://www.wiley.com/en-us");
    }

    public void setModalContent() {
        modalContent.click();
    }

    public void checkSearchList() {
        for (WebElement element : searchSuggetions) {
            Assert.assertTrue(getItemName(element).matches("Java.*"));
        }
    }

    public String getItemName(WebElement element) {
        return ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText;", element).toString().trim();
    }

    public List<WebElement> getElementsByCssSelector(String selector) {
        return getDriver().findElements(By.cssSelector(selector));
    }




    @BeforeTest
    public static WebDriver getDriver() {
        return driver;
    }

}
