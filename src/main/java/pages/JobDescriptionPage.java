package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class JobDescriptionPage {
    public SelenideElement captcha = $(By.name("captcha"));
    public void CVFormSubmit(String firstName, String lastName, String email, String country, String city, String message){
        $(By.cssSelector("input[ placeholder=\"First Name\"]")).setValue(firstName);
        $(By.cssSelector("input[ placeholder=\"Last Name\"]")).setValue(lastName);
        $(By.cssSelector("input[ placeholder=\"Email\"]")).setValue(email);

        $(By.cssSelector(".country-wrapper")).click();
        $$(By.cssSelector(".select-box-results > ul > li")).findBy(Condition.text(country)).click();

        $(By.cssSelector(".city-wrapper")).click();
        $$(By.cssSelector("div > div.select-box-results > ul > li")).findBy(Condition.text(city)).click();

        $(By.cssSelector(".comment-input")).setValue(email);

        $(By.xpath("//*[.='Submit']")).click();


    }
}
