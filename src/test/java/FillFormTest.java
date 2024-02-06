import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FillFormTest extends BaseTest {
    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Dinis");
        $("#lastName").setValue("Satvalov");
        $("#userEmail").setValue("test@mail.ru");
        $("#genterWrapper").$(byText("Male")).click();

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();

        $("#userNumber").setValue("8999777665");

        $("#subjectsInput").setValue("Eng");
        $("#subjectsWrapper").$(byText("English")).click();
        $("#subjectsInput").setValue("Ma");
        $("#subjectsWrapper").$(byText("Maths")).click();

        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();

        $("#uploadPicture").uploadFromClasspath("slow_git.PNG");

        $("#currentAddress").setValue("test address");

        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();


        $(".modal-content").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text("Dinis Satvalov"));
        $(".modal-body").shouldHave(text("test@mail.ru"));
        $(".modal-body").shouldHave(text("Male"));
        $(".modal-body").shouldHave(text("8999777665"));
        $(".modal-body").shouldHave(text("30 January,1990"));
        $(".modal-body").shouldHave(text("English, Maths"));
        $(".modal-body").shouldHave(text("Sports, Music"));
        $(".modal-body").shouldHave(text("slow_git.PNG"));
        $(".modal-body").shouldHave(text("test address"));
        $(".modal-body").shouldHave(text("NCR Delhi"));


    }
}
