import static org.junit.Assert.assertTrue;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.LoginPage;

public class TransferToProfileTest extends CreateAndDeleteUserTest {

  @Test
  @DisplayName("Проверка перехода в личный кабинет по кнопке «Личный кабинет»")
  @Description("В конце проверяется наличие текста «Профиль»")
  public void checkTransferToProfile() {
    boolean isProfileTextDisplayed = new LoginPage(driver)
        .open()
        .setEmail(user.getEmail())
        .setPassword(user.getPassword())
        .clickLoginButton()
        .clickProfileButtonAuth()
        .isProfileTextDisplayed();
    assertTrue("Profile text is not displayed", isProfileTextDisplayed);
  }
}
