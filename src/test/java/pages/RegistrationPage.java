package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ModalWindowComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private final SelenideElement userForm = $("#userForm"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbyWrapper = $("#hobbiesWrapper"),
            pictureInput = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submitButton = $("#submit");


    CalendarComponent calendarComponent = new CalendarComponent();
    ModalWindowComponent modalWindowComponent = new ModalWindowComponent();


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbyWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setPicture(String value) {
        pictureInput.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value) {
        stateInput.click();
        $("#stateCity-wrapper").$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value) {
        cityInput.click();
        $("#stateCity-wrapper").$(byText(value)).click();

        return this;
    }

    public RegistrationPage submit() {
        submitButton.click();
        return this;
    }
    public RegistrationPage checkResult(String fieldName, String value) {

        modalWindowComponent.checkSubmitForm(fieldName, value);
        return this;
    }
    public RegistrationPage checkValidation() {
        String valueName = "border-color";
        String colorRed = "rgb(220, 53, 69)";
        userForm.shouldHave(cssClass("was-validated"));
        firstNameInput.shouldHave(cssValue(valueName,colorRed));
        lastNameInput.shouldHave(cssValue(valueName,colorRed));
        genderWrapper.$("label[for='gender-radio-1']").shouldHave(cssValue(valueName,colorRed)); //Male
        genderWrapper.$("label[for='gender-radio-2']").shouldHave(cssValue(valueName,colorRed)); //Female
        genderWrapper.$("label[for='gender-radio-3']").shouldHave(cssValue(valueName,colorRed)); //Other
        userNumberInput.shouldHave(cssValue(valueName,colorRed));
        return this;
    }
}