import java.util.Random;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;
import static spark.Spark.*;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import java.util.Map;

public class Coin {

  public static void main(String[] args) {
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      HashMap model = new HashMap();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/results", (request, response) -> {
      HashMap model = new HashMap();
      model.put("template", "templates/results.vtl");

      String cents = request.queryParams("cents");
      model.put("cents", cents);
      String result = coinCount(cents);
      model.put("result", result);

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }

  public static Boolean testInput (String centsStr){

    try {
      Integer cents = Integer.parseInt(centsStr);
      if(cents < 0) {
        return false;
      }
    } catch(NumberFormatException e) {
         return false;
      }
    return true;
  }

  public static String coinCount(String centsStr) {

    Boolean goodInput = testInput(centsStr);

    if(goodInput) {
      Integer cents = Integer.parseInt(centsStr);
      Integer quarters = countQuarters(cents);
      cents -= (quarters * 25);
      Integer dimes = countDimes(cents);
      cents -= (dimes * 10);
      Integer nickels = countNickels(cents);
      cents -= (nickels * 5);
      Integer pennies = countPennies(cents);

      String q;
      if (quarters == 1) {
        q = "quarter";
      } else {
        q = "quarters";
      }

      String d;
      if (dimes == 1) {
        d = "dime";
      } else {
        d = "dimes";
      }

      String n;
      if (nickels == 1) {
        n = "nickel";
      } else {
        n = "nickels";
      }

      String p;
      if (pennies == 1) {
        p = "penny";
      } else {
        p = "pennies";
      }

      String result = String.format("You should receive %d %s, %d %s, %d %s, %d %s.",
                                    quarters, q, dimes, d, nickels, n, pennies, p);
      return result;
    } else {
      return "That is not a valid number.";
    }
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
