package pom.test;

import com.parabank.pom.BaseParaBankTest;
import com.parabank.pom.pages.HomePage;
import com.parabank.pom.pages.LoginPage;
import com.thedeanda.lorem.LoremIpsum;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseParaBankTest {
    public RegisterTest() {
        super();
    }

    @Test
    public void registerShouldSucceed() {
        String username = LoremIpsum.getInstance().getTitle(1);
        String password= LoremIpsum.getInstance().getTitle(1);
        // Login Page >> Register Page >> Home Page
//        LoginPage loginPage = new LoginPage();
//        RegisterPage registerPage = loginPage
//                .clickRegisterLinkBtn();
//
//        registerPage = registerPage
//                .fillFirstName(LoremIpsum.getInstance().getFirstName())
//                .fillLastName(LoremIpsum.getInstance().getLastName())
//                .fillAddress(LoremIpsum.getInstance().getTitle(3))
//                .fillCity(LoremIpsum.getInstance().getCity())
//                .fillState(LoremIpsum.getInstance().getStateFull())
//                .fillZipCode(LoremIpsum.getInstance().getZipCode())
//                .fillPhoneNumber(LoremIpsum.getInstance().getPhone())
//                .fillSsn(LoremIpsum.getInstance().getPhone())
//                .fillUsername(username)
//                .fillPassword(username)
//                .fillConfirm(username);
//
//        HomePage homePage = registerPage
//                .clickRegisterBtn();

        HomePage homePage = new LoginPage()
                .clickRegisterLinkBtn()
                .fillFirstName(LoremIpsum.getInstance().getFirstName())
                .fillLastName(LoremIpsum.getInstance().getLastName())
                .fillAddress(LoremIpsum.getInstance().getTitle(3))
                .fillCity(LoremIpsum.getInstance().getCity())
                .fillState(LoremIpsum.getInstance().getStateFull())
                .fillZipCode(LoremIpsum.getInstance().getZipCode())
                .fillPhoneNumber(LoremIpsum.getInstance().getPhone())
                .fillSsn(LoremIpsum.getInstance().getPhone())
                .fillUsername(username)
                .fillPassword(password)
                .fillConfirm(password)
                .clickRegisterBtn();
        Assert.assertTrue(homePage.isLogOutText());

//        ReadAndWriteProperties.writePropertyValue("username", username);
//        ReadAndWriteProperties.writePropertyValue("password", password);

    }
}
