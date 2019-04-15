import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage extends Settings{
    private WebDriver driver;
    private WebDriverWait wait;
    private static List<WebElement> list;




    public SearchPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
    }

    @FindBy(className = "product-title")
    private List<WebElement> titlesList;


    public String getItemName(WebElement element) {
        return ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText;", element).toString().trim();
    }

    public void checkTitles(){
        waiting();
        for (WebElement title : titlesList){
            Assert.assertTrue(getItemName(title).matches(".*Java.*"));
        }
    }

    public void checkNumberOfTitles(int expectedNumberOfTitles) {
        Assert.assertEquals(null, expectedNumberOfTitles, titlesList.size());
        System.out.println(titlesList);

    }

    public void checkAddToCartButton(){
        for (WebElement title : titlesList){
            Assert.assertTrue(title.findElement(
                    By.xpath(".//following-sibling::div/div/div/div/div/div[@class = 'product-button']")).isDisplayed());
        }
    }

    public void saveTitlesList(){
        waiting();
        list = titlesList;
        System.out.println(list);


    }

    public void compareTitles(){
        Assert.assertEquals(list, titlesList);

    }



//    public void saveSearchReultTitles (List<String> searchTitles) {
//        List<WebElement> elementList = driver.findElements(By.cssSelector(".products-list .product-item .product-title a "));
//        for (WebElement element : elementList) {
//            String title = element.getText();
//            searchTitles.add(title);
//            System.out.println(elementList);
//        }
//    }
}
