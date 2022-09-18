package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

  public static final String URL = "https://stellarburgers.nomoreparties.site/login";
  private By emailField = By.xpath("//label[text()='Email']/../input");
  private By passwordField = By.xpath("//label[text()='Пароль']/../input");
  private By loginButton = By.xpath("//button[text()='Войти']");
  private By registerLink = By.xpath("//a[@href='/register']");

  public LoginPage(WebDriver driver) {
    super(driver);
  }

  public RegisterPage clickRegisterLink() {
    driver.findElement(registerLink).click();
    return new RegisterPage(driver);
  }

  public String getPageUrl() {
    WebElement webElement = new WebDriverWait(driver, Duration.ofSeconds(2))
        .until(ExpectedConditions.visibilityOfElementLocated(loginButton));
    return driver.getCurrentUrl();
  }

  public LoginPage setEmail(String email) {
    driver.findElement(emailField).sendKeys(email);
    return this;
  }

  public LoginPage setPassword(String password) {
    driver.findElement(passwordField).sendKeys(password);
    return this;
  }

  public LoginPage open() {
    driver.get(URL);
    return this;
  }

  public MainPage clickLoginButton() {
    driver.findElement(loginButton).click();
    return new MainPage(driver);
  }
}
