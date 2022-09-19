package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage extends BasePage {

  private static final String URL = "https://stellarburgers.nomoreparties.site/forgot-password";
  private By loginLink = By.xpath("//a[@href='/login']");

  public ForgotPasswordPage(WebDriver driver) {
    super(driver);
  }

  public LoginPage clickLoginLink() {
    driver.findElement(loginLink).click();
    return new LoginPage(driver);
  }

  public ForgotPasswordPage open() {
    driver.get(URL);
    return this;
  }
}
