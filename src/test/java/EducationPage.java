import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EducationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public EducationPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);



    }
}
