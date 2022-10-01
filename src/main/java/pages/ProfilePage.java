package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasePage {

  private By logoutButton = By.xpath("//button[text()='Выход']");
  private By constructorButton = By.xpath("(//a[@href='/'])[1]");
  private By logoButton = By.xpath("(//a[@href='/'])[2]");
  private By profileText = By.xpath("//a[text()='Профиль']");

  public ProfilePage(WebDriver driver) {
    super(driver);
  }

  public MainPage clickConstructorButton() {
    driver.findElement(constructorButton).click();
    return new MainPage(driver);
  }

  public MainPage clickLogoButton() {
    driver.findElement(logoButton).click();
    return new MainPage(driver);
  }

  public LoginPage clickLogoutButton() {
    WebElement webElement = new WebDriverWait(driver, Duration.ofSeconds(2))
        .until(ExpectedConditions.elementToBeClickable(logoutButton));
    driver.findElement(logoutButton).click();
    return new LoginPage(driver);
  }

  public boolean isProfileTextDisplayed() {
    WebElement webElement = new WebDriverWait(driver, Duration.ofSeconds(2))
        .until(ExpectedConditions.visibilityOfElementLocated(profileText));
    return driver.findElement(profileText).isDisplayed();
  }
}
