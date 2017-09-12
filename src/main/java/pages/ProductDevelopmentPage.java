package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class ProductDevelopmentPage extends BasePage {

public CareerPage goToCareerPage(){
    $(By.cssSelector("nav > ul > li:nth-child(5) > a")).click();
    return page(CareerPage.class);
}

}
