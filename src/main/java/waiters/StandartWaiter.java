package waiters;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StandartWaiter implements WaiterInt {

  private WebDriver driver = null;

  public StandartWaiter(WebDriver driver) {
    this.driver = driver;
  }

  @Override
  public boolean waitForCondition(ExpectedCondition condition) {
    WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    try {
      webDriverWait.until(condition);
      return true;
    } catch (Exception ex) {
      return false;
    }
  }

  public boolean waitForElementVisible(WebElement element) {
    return waitForCondition(ExpectedConditions.visibilityOf(element));
  }

  public boolean waitForElementNotVisible(WebElement element) {
    return waitForCondition(ExpectedConditions.invisibilityOf(element));
  }
}
