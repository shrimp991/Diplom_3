package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage{

  public static final String URL = "https://stellarburgers.nomoreparties.site/";
  private By loginButton = By.xpath("//button[text()='Войти в аккаунт']");
  private By profileButton = By.xpath("//a[@href='/account']");
  private By bunsSectionButton = By.xpath("//span[text()='Булки']");
  private By saucesSectionButton = By.xpath("//span[text()='Соусы']");
  private By fillingsSectionButton = By.xpath("//span[text()='Начинки']");

  private By bunsSectionButtonSelected = By.xpath("//div[@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']");
  private By saucesSectionButtonSelected = By.xpath("//div[@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']");
  private By fillingsSectionButtonSelected = By.xpath("//div[@class = 'tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']");

  private By createOrderButton = By.xpath("//button[text()='Оформить заказ']");

  public MainPage(WebDriver driver) {
    super(driver);
  }

  public boolean isBunsSectionButtonSelectedDisplayed(){
    driver.findElement(saucesSectionButton).click();
    return clickAndCheckIsDisplayed(bunsSectionButton, bunsSectionButtonSelected);
  }
  public boolean isSaucesSectionButtonSelectedDisplayed(){
    return clickAndCheckIsDisplayed(saucesSectionButton, saucesSectionButtonSelected);
  }
  public boolean isFillingsSectionButtonSelectedDisplayed(){
    return clickAndCheckIsDisplayed(fillingsSectionButton, fillingsSectionButtonSelected);
  }

  private boolean clickAndCheckIsDisplayed(By click, By isDisplayed) {
    driver.findElement(click).click();
    WebElement webElement = new WebDriverWait(driver, Duration.ofSeconds(2))
        .until(ExpectedConditions.visibilityOfElementLocated(isDisplayed));
    return driver.findElement(isDisplayed).isDisplayed();
  }

  public LoginPage clickLoginButton() {
    driver.findElement(loginButton).click();
    return new LoginPage(driver);
  }

  public LoginPage clickProfileButtonNonAuth() {
    driver.findElement(profileButton).click();
    return new LoginPage(driver);
  }

  public ProfilePage clickProfileButtonAuth() {
    WebElement webElement = new WebDriverWait(driver, Duration.ofSeconds(2))
        .until(ExpectedConditions.visibilityOfElementLocated(profileButton));
    driver.findElement(profileButton).click();
    return new ProfilePage(driver);
  }

  public MainPage open() {
    driver.get(URL);
    return this;
  }

  public boolean isCreateOrderButtonDisplayed() {
    WebElement webElement = new WebDriverWait(driver, Duration.ofSeconds(2))
        .until(ExpectedConditions.visibilityOfElementLocated(createOrderButton));
    return driver.findElement(createOrderButton).isDisplayed();
  }
}
