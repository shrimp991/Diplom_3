package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

  public static final String URL = "https://stellarburgers.nomoreparties.site/register";
  private By nameField = By.xpath("//label[text()='Имя']/../input");
  private By emailField = By.xpath("//label[text()='Email']/../input");
  private By passwordField = By.xpath("//label[text()='Пароль']/../input");
  private By registerButton = By.xpath("//button[text()='Зарегистрироваться']");
  private By loginLink = By.xpath("//a[@href='/login']");
  private By incorrectPasswordError = By.xpath("//p[text()='Некорректный пароль']");

  public RegisterPage(WebDriver driver) {
    super(driver);
  }

  public RegisterPage setName(String name) {
    driver.findElement(nameField).sendKeys(name);
    return this;
  }

  public RegisterPage setEmail(String email) {
    driver.findElement(emailField).sendKeys(email);
    return this;
  }

  public RegisterPage setPassword(String password) {
    driver.findElement(passwordField).sendKeys(password);
    return this;
  }

  public LoginPage clickRegisterButtonWithCorrectPassword() {
    driver.findElement(registerButton).click();
    return new LoginPage(driver);
  }

  public RegisterPage clickRegisterButtonWithIncorrectPassword() {
    driver.findElement(registerButton).click();
    return new RegisterPage(driver);
  }

  public LoginPage clickLoginLink() {
    driver.findElement(loginLink).click();
    return new LoginPage(driver);
  }

  public boolean isIncorrectPasswordErrorDisplayed() {
    return driver.findElement(incorrectPasswordError).isDisplayed();
  }

  public RegisterPage open() {
    driver.get(URL);
    return this;
  }
}
