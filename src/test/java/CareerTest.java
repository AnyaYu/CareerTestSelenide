import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.CareerFilterData;

import org.junit.Before;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import pages.*;


import static com.codeborne.selenide.Selenide.open;


public class CareerTest {

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        System.setProperty("selenide.browser", "Chrome");
    }

    @Test(dataProvider = "careerFilterData", dataProviderClass = CareerFilterData.class)
    public void careerTesting(String keyWord, String firstName, String lastName, String email, String country, String city, String message, String position) throws InterruptedException {

        MainPage mainPage = open("https://www.epam.com/", MainPage.class);
        ProductDevelopmentPage productDevelopmentPage = mainPage.goToProductDevelopmentPage();
        CareerPage careerPage = productDevelopmentPage.goToCareerPage();
        JobListingPage jobListingPage = careerPage.searchForJob(keyWord, country, city);
        JobDescriptionPage jobDescriptionPage = jobListingPage.choosingPosition(position);
        jobDescriptionPage.CVFormSubmit(firstName, lastName, email, country, city, message);
        jobDescriptionPage.captcha.should(Condition.cssClass("form-field-error"));

    }


}
