package pages;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class MainPage  {


    public ProductDevelopmentPage goToProductDevelopmentPage(){

        SelenideElement solutionButton = $(By.cssSelector("nav>ul>li:nth-child(1)>a"));
        solutionButton.hover();
        $(By.linkText("Product Development")).click();
        return page(ProductDevelopmentPage.class);
    }



}

