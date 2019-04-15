import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class StudentsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public StudentsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
    }

    @FindBy (xpath = "//span[contains(text(),'Students')]")
    private WebElement studentsIsDisplay;

    @FindBy (xpath = "//a[@href='https://www.wileyplus.com/']//span//span[contains(text(),'Learn More')]")
    private WebElement learnMoreIsDispla;



    @FindBy (xpath = "//a[@href='https://www.wileyplus.com/']//span//span[contains(text(),'Learn More')]")
    private WebElement learnClick;

    public void setLearnClick() {
        learnClick.click();
    }
    public void setLearnMoreIsDisplayAndClick() {
        learnMoreIsDispla.isDisplayed();

    }

    public void setStudentsIsDisplay() {
        studentsIsDisplay.isDisplayed();

    }
}
