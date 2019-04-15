
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


import java.util.*;

import static org.junit.Assert.assertEquals;


public class testWiley extends Settings{

    private static List<String> searchResult;
    public List<String> searchTitles = new ArrayList<String>();





    @Test
    public void testCheckTopmenuLinksIsDisplay(){
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);

        mainPage.openLinck();
        mainPage.setModalContent();
        mainPage.setWheWeServeIsDisplay();
        mainPage.setAboutIsDisplay();
        mainPage.setSubjectISDisplay();
    }

    @Test
    public void checkItemsUnderWhoWeServeForSubHeader(){
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.openLinck();
        mainPage.setModalContent();


        Set<String> expected = new HashSet<String>();
        Set<String> actual = new HashSet<String>();
        expected.addAll(Arrays.asList("Students", "Instructors", "Book Authors", "Professionals",
                "Researchers", "Institutions", "Librarians",
                "Corporations", "Societies", "Journal Editors", "Bookstores", "Government"));

        List<WebElement> subHeaders = driver.findElements(By.xpath
                ("//div[@class='row who-we-serve-blocks']/div"));


        for (WebElement w : subHeaders) {
            actual.add(w.getAttribute("innerText"));
        }

        assertEquals(12, subHeaders.size());
        assertEquals(expected, actual);
        System.out.println(expected);
        System.out.println(actual);

    }

    @Test
    public void checkItemStudents(){
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        StudentsPage studentsPage = PageFactory.initElements(driver, StudentsPage.class);

        mainPage.openLinck();
        mainPage.setModalContent();
        waiting();
        mainPage.setClickStudentsItem();

        String urlStudents = driver.getCurrentUrl();
        System.out.println(urlStudents);
        waiting();
        if (urlStudents.equals("https://www.wiley.com/en-us/students")) {
            System.out.println("Login successful");
        } else {
            System.out.println("Incorrect details provided by the User");
        }
        waiting();
        studentsPage.setStudentsIsDisplay();
        studentsPage.setLearnClick();
        waiting();
        String urlWileyPlus = driver.getCurrentUrl();
        System.out.println(urlWileyPlus);
        waiting();
        if (urlWileyPlus.equals("https://www.wileyplus.com/")) {
            System.out.println("Login successful");
        } else {
            System.out.println("Incorrect details provided by the User");
        }

    }

    @Test
    public void clickSubjectsAndEducation(){

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);


        mainPage.openLinck();
        mainPage.setModalContent();
        waiting();
        WebElement linkEducation = driver.findElement(By.xpath
                ("/html[1]/body[1]/main[1]/header[1]/div[1]/div[1]/nav[1]/ul[1]/li[2]/div[1]/ul[1]/li[9]/a[1]")); //
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();" , linkEducation);

        Set<String> expected = new HashSet<String>();
        Set<String> actual = new HashSet<String>();
        expected.addAll(Arrays.asList("Information & Library Science",
                "Education & Public Policy",
               "K-12 General",
               "Higher Education General",
               "Vocational Technology",
               "Conflict Resolution & Mediation (School settings)",
                "Curriculum Tools- General",
                "Special Educational Needs",
                "Theory of Education",
                "Education Special Topics",
                "Educational Research & Statistics",
                "Literacy & Reading",
                "Classroom Management"));

        List<WebElement> subHeaders = driver.findElements(By.xpath
                ("//div[@class='side-panel']/ul/li/a"));


        for (WebElement w : subHeaders) {
            actual.add(w.getAttribute("innerText"));
        }


        assertEquals(13, subHeaders.size());
        assertEquals(expected, actual);
        System.out.println(expected);
        System.out.println(actual);

    }

    @Test
    public void  clickOnTheWileyLogoTest(){

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);

        driver.get("https://www.wiley.com/en-us/Education-c-ED00");

        mainPage.setModalContent();
        waiting();

        mainPage.setClickLogo();



        String urlWiley = driver.getCurrentUrl();
        System.out.println(urlWiley);
        waiting();
        if (urlWiley.equals("https://www.wiley.com/en-us")) {
            System.out.println("Login successful");
        } else {
            System.out.println("Incorrect details provided by the User");
        }




    }

    @Test
    public void emptySearch(){

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.openLinck();
        mainPage.setModalContent();
        waiting();
        mainPage.setSerchButtonClick();


        String urlWiley = driver.getCurrentUrl();
        System.out.println(urlWiley);
        waiting();
        if (urlWiley.equals("https://www.wiley.com/en-us")) {
            System.out.println("Login successful");
        } else {
            System.out.println("Incorrect details provided by the User");
        }

    }

    @Test
    public void putTextIntoSearchTextFieldNoSubmit()  {
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.openLinck();
        mainPage.setModalContent();
        waiting();

        mainPage.setSerchInput();

        waiting();
        mainPage.checkNumberOfItemsInSearchSuggetions(4);

        mainPage.checkNumberOfItemsInSearchProducts(4); //at task 5 headlines, actually 4

    }


    @Test
    public void clickSearchButtonTest(){

        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        SearchPage searchPage = PageFactory.initElements(driver, SearchPage.class);

        mainPage.openLinck();
        mainPage.setModalContent();
        waiting();

        mainPage.setSerchInput();
        waiting();
        mainPage.setSerchButtonClick();


        waiting();
        searchPage.checkTitles(); //по сути должно так работатать, но выдает ошибку [RemoteWebDriver: chrome on XP], к сожалению так и не смог разобраться.

        searchPage.checkNumberOfTitles(10);

        searchPage.checkAddToCartButton();
        searchPage.saveTitlesList();

        searchPage.compareTitles();// task 9




    }


   
}
