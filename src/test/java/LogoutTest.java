import static org.junit.Assert.assertEquals;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.LoginPage;

public class LogoutTest extends CreateAndDeleteUserTest {

  @Test
  @DisplayName("Проверка выхода по кнопке «Выйти» в личном кабинете")
  @Description("В конце проверяется, что осуществлен редирект на страницу входа по URL")
  public void checkLogout() {
    String currentUrl = new LoginPage(driver)
        .open()
        .setEmail(user.getEmail())
        .setPassword(user.getPassword())
        .clickLoginButton()
        .clickProfileButtonAuth()
        .clickLogoutButton()
        .getPageUrl();
    assertEquals("Incorrect page", LoginPage.URL, currentUrl);
  }
}
