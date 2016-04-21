import java.util.ArrayList;
import java.util.Arrays;
import org.junit.*;
import static org.junit.Assert.*;
import org.fluentlenium.adapter.FluentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class CoinCombinationsTest extends FluentTest{
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void CoinCombination() {
    goTo("http://localhost:4567/");
    fill("#cents").with("36");
    submit(".btn");
    assertThat(pageSource()).contains(" 1 Quarter 1 Dime 1 Penny");
  }

  @Test
  public void coinCombination_makesChangeFor25cents_1Quarter() {
    CoinCombinations testCoinCombinations = new CoinCombinations();
    String expected = " 1 Quarter";
    assertEquals(expected, testCoinCombinations.change(25));
  }

  @Test
  public void coinCombination_makesChangeFor75cents_3Quarters() {
    CoinCombinations testCoinCombinations = new CoinCombinations();
    String expected = " 3 Quarters";
    assertEquals(expected, testCoinCombinations.change(75));
  }

  @Test
  public void coinCombination_makesChangeFor20cents_2Dimes() {
    CoinCombinations testCoinCombinations = new CoinCombinations();
    String expected = " 2 Dimes";
    assertEquals(expected, testCoinCombinations.change(20));
  }
  @Test
  public void coinCombination_makesChangeFor35cents_1Quarter1Dime() {
    CoinCombinations testCoinCombinations = new CoinCombinations();
    String expected = " 1 Quarter 1 Dime";
    assertEquals(expected, testCoinCombinations.change(35));
  }
  @Test
  public void coinCombination_makesChangeFor5cents_1Nickel() {
    CoinCombinations testCoinCombinations = new CoinCombinations();
    String expected = " 1 Nickel";
    assertEquals(expected, testCoinCombinations.change(5));
  }

  @Test
  public void coinCombination_makesChangeFor1cent_1Penny() {
    CoinCombinations testCoinCombinations = new CoinCombinations();
    String expected = " 1 Penny";
    assertEquals(expected, testCoinCombinations.change(1));
  }
  @Test
  public void coinCombination_makesChangeFor44cents_1Quarter1Dime1Nickel4Pennies() {
    CoinCombinations testCoinCombinations = new CoinCombinations();
    String expected = " 1 Quarter 1 Dime 1 Nickel 4 Pennies";
    assertEquals(expected, testCoinCombinations.change(44));
  }
  @Test
  public void coinCombination_makesChangeFor0cent_NoChange() {
    CoinCombinations testCoinCombinations = new CoinCombinations();
    String expected = "No change";
    assertEquals(expected, testCoinCombinations.change(0));
  }


}
