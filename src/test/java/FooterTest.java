import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FooterTest {
    private WebDriver driver;
    private MainPage mainPage;

    @Rule
   public DriverRule factory = new DriverRule();
    @Test
    public void testFooterVK() {
      WebDriver driver = factory.getDriver();
        mainPage = new MainPage(driver);
        mainPage.open();
       assertTrue(mainPage.footerVK());

}
@Test
public void testFooterStartPr(){
    WebDriver driver = factory.getDriver();
        mainPage = new MainPage(driver);
    mainPage.open();
    String ex = "Начать проект";
    assertEquals(ex,mainPage.getTextStartProject() );
}
}
