package pom.pages;

import com.parabank.pom.BaseParaBankTest;
import com.parabank.pom.pages.OpenAccountPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseParaBankTest {
    @FindBy(linkText = "Log Out")
    WebElement logoutText;

    @FindBy(linkText = "Open New Account")
    WebElement openAccountLink;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public OpenAccountPage clickOpenAccountLink() {
        openAccountLink.isDisplayed();
        openAccountLink.click();
        return new OpenAccountPage();
    }

    public boolean isLogOutText() {
        return logoutText.isDisplayed();
    }
}
