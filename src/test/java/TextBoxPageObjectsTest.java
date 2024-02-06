import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxPageObjectsTest extends BaseTest {

    @Test
    void textBoxPageTest() {
        TextBoxPage textBoxPage = new TextBoxPage();
        textBoxPage
                .openPage()
                .setUserName("Alex")
                .setUserEmail("alex@egorov.com")
                .setCurrentAddress("Some address 1")
                .setPermanentAddress("Some address 2")
                .submitForm();

        textBoxPage.checkResults("Name:Alex", "Email:alex@egorov.com", "Current Address :Some address 1", "Permananet Address :Some address 2");
    }
}
