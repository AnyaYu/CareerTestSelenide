package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class CareerPage {

    public JobListingPage searchForJob(String keyWord, String country, String city){
        $(By.cssSelector(".job-search-input")).setValue(keyWord);
        selectLocation(country, city);
        $(By.cssSelector("div.career-apply-box.career-apply-box-desktop > button")).click();
        return page(JobListingPage.class);
    }

    public void selectLocation(String country, String city){
        $(By.cssSelector("#select-box-location-select-container")).click();

        ElementsCollection countrySide = $$(By.cssSelector("#select-box-location-select-results > li"));

        SelenideElement ChosenCountry = countrySide.findBy(Condition.text(country));
        if (!ChosenCountry.getAttribute("class").contains("dropdown-invisible-group")) {
            ChosenCountry.click();
        }

        ChosenCountry.$$(By.cssSelector("li")).find(Condition.text(city)).click();



    }
}
