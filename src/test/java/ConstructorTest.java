import static org.junit.Assert.assertTrue;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.MainPage;

public class ConstructorTest extends BaseUiTest {

  @Test
  @DisplayName("Проверка перехода к разделу \"Булки\"")
  @Description("Проверяется, что при нажатии на вкладку \"Булки\" изменяется наименование класса")
  public void checkBunsSectionButtonClick(){
    boolean isBunsSectionButtonSelectedDisplayed = new MainPage(driver)
        .open()
        .isBunsSectionButtonSelectedDisplayed();
    assertTrue("Button is not selected", isBunsSectionButtonSelectedDisplayed);
  }

  @Test
  @DisplayName("Проверка перехода к разделу \"Соусы\"")
  @Description("Проверяется, что при нажатии на вкладку \"Соусы\" изменяется наименование класса")
  public void checkSaucesSectionButton(){
    boolean isSaucesSectionButtonSelectedDisplayed = new MainPage(driver)
        .open()
        .isSaucesSectionButtonSelectedDisplayed();
    assertTrue("Button is not selected", isSaucesSectionButtonSelectedDisplayed);
  }

  @Test
  @DisplayName("Проверка перехода к разделу \"Начинки\"")
  @Description("Проверяется, что при нажатии на вкладку \"Начинки\" изменяется наименование класса")
  public void checkFillingsSectionButton(){
    boolean isFillingsSectionButtonSelectedDisplayed = new MainPage(driver)
        .open()
        .isFillingsSectionButtonSelectedDisplayed();
    assertTrue("Button is not selected", isFillingsSectionButtonSelectedDisplayed);
  }
}
