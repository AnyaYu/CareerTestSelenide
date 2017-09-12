package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;

public class JobListingPage {

    public JobDescriptionPage choosingPosition(String position){
        $$(By.cssSelector(".search-result-item")).findBy(Condition.text(position)).$(By.cssSelector(".button-apply")).click();
                return page(JobDescriptionPage.class);
    }

}
