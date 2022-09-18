import static org.junit.Assert.assertEquals;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import model.User;
import model.UserClient;
import model.UserCredentials;
import model.UserGenerator;
import org.junit.After;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;

public class RegisterTest extends BaseUiTest {
  private User user;
  private UserClient userClient;
  private String accessToken;

  @After
  public void deleteUser() {
    accessToken = userClient.login(UserCredentials.from(user))
        .extract()
        .path("accessToken");
    userClient.delete(accessToken);
  }

  @Test
  @DisplayName("Проверка, что пользователь может зарегистрироваться")
  @Description("В конце проверяется, что осуществлен редирект на страницу авторизации по URL")
  public void checkUserCanRegister(){
    userClient = new UserClient();
    user = UserGenerator.getRandom();
    String currentUrl = new MainPage(driver)
        .open()
        .clickLoginButton()
        .clickRegisterLink()
        .setEmail(user.getEmail())
        .setPassword(user.getPassword())
        .setName(user.getName())
        .clickRegisterButtonWithCorrectPassword()
        .getPageUrl();
    assertEquals("Incorrect page", LoginPage.URL, currentUrl);
  }
}
