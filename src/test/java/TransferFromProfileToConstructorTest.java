import static org.junit.Assert.assertTrue;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.LoginPage;

public class TransferFromProfileToConstructorTest extends CreateAndDeleteUserTest {

  @Test
  @DisplayName("Проверка перехода из личного кабинета в конструктор по клику на «Конструктор»")
  @Description("В конце проверяется, что отображается кнопка формирования заказа")
  public void checkTransferThroughConstructorButton(){
    boolean isCreateOrderButtonDisplayed = new LoginPage(driver)
        .open()
        .setEmail(user.getEmail())
        .setPassword(user.getPassword())
        .clickLoginButton()
        .clickProfileButtonAuth()
        .clickConstructorButton()
        .isCreateOrderButtonDisplayed();
    assertTrue("Button is not displayed", isCreateOrderButtonDisplayed);
  }

  @Test
  @DisplayName("Проверка перехода из личного кабинета в конструктор по клику на логотип «Stellar Burgers»")
  @Description("В конце проверяется, что отображается кнопка формирования заказа")
  public void checkTransferThroughLogo() {
    boolean isCreateOrderButtonDisplayed = new LoginPage(driver)
        .open()
        .setEmail(user.getEmail())
        .setPassword(user.getPassword())
        .clickLoginButton()
        .clickProfileButtonAuth()
        .clickLogoButton()
        .isCreateOrderButtonDisplayed();
    assertTrue("Button is not displayed", isCreateOrderButtonDisplayed);
  }
}
