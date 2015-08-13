import org.fluentlenium.adapter.FluentTest;
import static org.junit.Assert.*;
import org.junit.*;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class CoinTest extends FluentTest {

  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void countQuarters_givesCorrectQuarters_true() {
    Coin coin = new Coin();
    Integer expValue = 2;
    assertEquals(expValue, coin.countQuarters(52));
  }

  @Test
  public void countDimes_givesCorrectDimes_true() {
    Coin coin = new Coin();
    Integer expValue = 5;
    assertEquals(expValue, coin.countDimes(52));
  }

  @Test
  public void countNickels_givesCorrectNickels_true() {
    Coin coin = new Coin();
    Integer expValue = 10;
    assertEquals(expValue, coin.countNickels(52));
  }

  @Test
  public void countPennies_givesCorrectPennies_true() {
    Coin coin = new Coin();
    Integer expValue = 52;
    assertEquals(expValue, coin.countPennies(52));
  }

  @Test
  public void coinCount_givesCoins_true() {
    Coin coin = new Coin();
    String expValue = "3 quarters, 1 dimes, 0 nickels, 2 pennies.";
    assertEquals(expValue, coin.coinCount(87));
  }


}
