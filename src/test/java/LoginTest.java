import static org.junit.Assert.assertTrue;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.ForgotPasswordPage;
import pages.MainPage;
import pages.RegisterPage;

public class LoginTest extends CreateAndDeleteUserTest {

  @Test
  @DisplayName("Проверка входа по кнопке «Войти в аккаунт»")
  @Description("В конце теста проверяется отображение кнопки создания заказа на главной странице")
  public void checkLoginThroughButtonLogin() {
    boolean isCreateOrderButtonDisplayed = new MainPage(driver)
        .open()
        .clickLoginButton()
        .setEmail(user.getEmail())
        .setPassword(user.getPassword())
        .clickLoginButton()
        .isCreateOrderButtonDisplayed();
    assertTrue("Button is not displayed", isCreateOrderButtonDisplayed);
  }

  @Test
  @DisplayName("Проверка входа через кнопку «Личный кабинет»)")
  @Description("В конце теста проверяется отображение кнопки создания заказа на главной странице")
  public void checkLoginThroughProfileButton() {
    boolean isCreateOrderButtonDisplayed = new MainPage(driver)
        .open()
        .clickProfileButtonNonAuth()
        .setEmail(user.getEmail())
        .setPassword(user.getPassword())
        .clickLoginButton()
        .isCreateOrderButtonDisplayed();
    assertTrue("Button is not displayed", isCreateOrderButtonDisplayed);
  }

  @Test
  @DisplayName("Проверка входа через кнопку в форме регистрации")
  @Description("В конце теста проверяется отображение кнопки создания заказа на главной странице")
  public void checkLoginThroughRegisterForm() {
    boolean isCreateOrderButtonDisplayed = new RegisterPage(driver)
        .open()
        .clickLoginLink()
        .setEmail(user.getEmail())
        .setPassword(user.getPassword())
        .clickLoginButton()
        .isCreateOrderButtonDisplayed();
    assertTrue("Button is not displayed", isCreateOrderButtonDisplayed);
  }

  @Test
  @DisplayName("Проверка входа через кнопку в форме восстановления пароля")
  @Description("В конце теста проверяется отображение кнопки создания заказа на главной странице")
  public void checkLoginThroughForgotPasswordForm() {
    boolean isCreateOrderButtonDisplayed = new ForgotPasswordPage(driver)
        .open()
        .clickLoginLink()
        .setEmail(user.getEmail())
        .setPassword(user.getPassword())
        .clickLoginButton()
        .isCreateOrderButtonDisplayed();
    assertTrue("Button is not displayed", isCreateOrderButtonDisplayed);
  }
}
