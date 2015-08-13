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
    String expValue = "You should receive 3 quarters, 2 dimes, 0 nickels, 2 pennies.";
    assertEquals(expValue, coin.coinCount("97"));
  }

  @Test
  public void coinCount_singularCoin_true() {
    Coin coin = new Coin();
    String expValue = "You should receive 3 quarters, 1 dime, 0 nickels, 2 pennies.";
    assertEquals(expValue, coin.coinCount("87"));
  }

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Change Calculator");
  }

  @Test
  public void results_displaysCorrectCoins() {
   goTo("http://localhost:4567/");
   fill("#cents").with("87");
   submit(".btn");
   assertThat(pageSource()).contains("3 quarters, 1 dime, 0 nickels, 2 pennies.");
 }

 @Test
 public void results_displaysErrorOnBadInput() {
  goTo("http://localhost:4567/");
  fill("#cents").with("banana");
  submit(".btn");
  assertThat(pageSource()).contains("That is not a valid number.");
}


}
