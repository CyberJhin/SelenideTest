import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationWithPageObjectsTest extends BaseTest {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Alex")
                .setLastName("Egorov")
                .setEmail("alex@egorov.com")
                .setGender("Other")
                .setUserNumber("1234567890")
                .setDateOfBirth("030", "July", "2008")
                .setSubjects("Math")
                .setHobbies("Sports")
                .setPicture("slow_git.PNG")
                .setAddress("Some address 1")
                .setState("NCR")
                .setCity("Delhi")
                .submit();

        $(".modal-dialog").should(appear);
        registrationPage.checkResult("Student Name", "Alex Egorov")
                .checkResult("Student Email", "alex@egorov.com")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "1234567890")
                .checkResult("Date of Birth", "30 July,2008")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "slow_git.PNG")
                .checkResult("Address", "Some address 1")
                .checkResult("State and City", "NCR Delhi");
    }
    @Test
    void minimalRegistrationTest() {
        registrationPage.openPage()
                .setFirstName("Alex")
                .setLastName("Egorov")
                .setGender("Other")
                .setUserNumber("1234567890")
                .submit();

        $(".modal-dialog").should(appear);
        registrationPage.checkResult("Student Name", "Alex Egorov")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "1234567890");

    }
    @Test
    void negativeRegistrationTest() {
        registrationPage.openPage()
                .submit();

        registrationPage.checkValidation();
    }
}

