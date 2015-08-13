import java.util.Random;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;
import static spark.Spark.*;
import spark.ModelAndView;
//import spark.template.velocity.VelocityTemplateEngine;
import java.util.Map;

public class Coin {

  public static void main(String[] args) {}

  public static String coinCount(Integer cents){

    Integer quarters = countQuarters(cents);
    cents -= (quarters * 25);
    Integer dimes = countDimes(cents);
    cents -= (dimes * 10);
    Integer nickels = countNickels(cents);
    cents -= (nickels * 5);
    Integer pennies = countPennies(cents);

    String result = String.format("%d quarters, %d dimes, %d nickels, %d pennies.",
                                  quarters, dimes, nickels, pennies);
    return result;

  }

  public static Integer countQuarters(Integer cents) {

    Integer quarters = 0;
    while (cents  >= 25) {
      quarters += 1;
      cents -= 25;
    }
    return quarters;
  }

  public static Integer countDimes(Integer cents) {

    Integer dimes = 0;
    while (cents  >= 10) {
      dimes += 1;
      cents -= 10;
    }
    return dimes;
  }

  public static Integer countNickels(Integer cents) {

    Integer nickels = 0;
    while (cents  >= 5) {
      nickels += 1;
      cents -= 5;
    }
    return nickels;
  }

  public static Integer countPennies(Integer cents) {

    Integer pennies = 0;
    while (cents  >= 1) {
      pennies += 1;
      cents -= 1;
    }
    return pennies;
  }
}
