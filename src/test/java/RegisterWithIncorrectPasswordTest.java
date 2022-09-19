import static org.junit.Assert.assertTrue;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import model.User;
import model.UserClient;
import model.UserCredentials;
import model.UserGenerator;
import org.junit.After;
import org.junit.Test;
import pages.MainPage;

public class RegisterWithIncorrectPasswordTest extends BaseUiTest {

  private User user;
  private String accessToken;

  @Test
  @DisplayName("Проверка что пользователь не может зарегистрировать с паролем менее 6 символов")
  @Description("В конце проверяется, что возникает сообщение об ошибке")
  public void checkUserWithIncorrectPassCanNotRegister() {
    user = UserGenerator.getRandomWithIncorrectPassword();
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

  @After
  public void deleteUserOfTokenIsNotNull() {
    UserClient userClient = new UserClient();
    accessToken = userClient
        .login(UserCredentials.from(user))
        .extract()
        .path("accessToken");
    if (accessToken != null) {
      userClient.delete(accessToken);
    }
  }
}
