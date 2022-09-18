import static org.junit.Assert.assertTrue;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import model.User;
import model.UserGenerator;
import org.junit.Test;
import pages.MainPage;

public class RegisterWithIncorrectPasswordTest extends BaseUiTest{

  @Test
  @DisplayName("Проверка что пользователь не может зарегистрировать с паролем менее 6 символов")
  @Description("В конце проверяется, что возникает сообщение об ошибке")
  public void checkUserWithIncorrectPassCanNotRegister() {
    User user = UserGenerator.getRandomWithIncorrectPassword();
    boolean isIncorrectPasswordErrorDisplayed = new MainPage(driver)
        .open()
        .clickLoginButton()
        .clickRegisterLink()
        .setEmail(user.getEmail())
        .setPassword(user.getPassword())
        .setName(user.getName())
        .clickRegisterButtonWithIncorrectPassword()
        .isIncorrectPasswordErrorDisplayed();
    assertTrue("Error is not displayed", isIncorrectPasswordErrorDisplayed);
  }
}
