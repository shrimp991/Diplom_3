import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.MainPage;

public class ConstructorTest extends BaseUiTest {

  @Test
  @DisplayName("Проверка перехода к разделу \"Булки\"")
  @Description("Проверяется, что при нажатии на вкладку \"Булки\" изменяется наименование класса")
  public void checkBunsSectionButtonClick() {
    String actualClassNameAfterClickSection = new MainPage(driver)
        .open()
        .getClassNameAfterClickBunsSection();
    assertEquals("Incorrect value", MainPage.expectedClassName, actualClassNameAfterClickSection);
  }

  @Test
  @DisplayName("Проверка перехода к разделу \"Соусы\"")
  @Description("Проверяется, что при нажатии на вкладку \"Соусы\" изменяется наименование класса")
  public void checkSaucesSectionButton() {
    String actualClassNameAfterClickSection = new MainPage(driver)
        .open()
        .getClassNameAfterClickSaucesSection();
    assertEquals("Incorrect value", MainPage.expectedClassName, actualClassNameAfterClickSection);
  }

  @Test
  @DisplayName("Проверка перехода к разделу \"Начинки\"")
  @Description("Проверяется, что при нажатии на вкладку \"Начинки\" изменяется наименование класса")
  public void checkFillingsSectionButton() {
    String actualClassNameAfterClickSection = new MainPage(driver)
        .open()
        .getClassNameAfterClickFillingsSection();
    assertEquals("Incorrect value", MainPage.expectedClassName, actualClassNameAfterClickSection);
  }
}
