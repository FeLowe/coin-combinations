
public class CoinCombinations{
  public static String change(Integer cents) {
    String combination = new String();
if (cents == 0){
  return combination += "No change";
}
    while (cents / 25 >= 1) {
      if (cents / 25 > 1){
        combination += " " + (cents / 25) + " Quarters";
        cents %= 25;
      }else {
        combination += " " + (cents / 25) + " Quarter";
        cents %= 25;
      }
    }

    while (cents / 10 >= 1) {
      if (cents / 10 > 1){
        combination += " " + (cents / 10) + " Dimes";
        cents %= 10;
      }else {
        combination += " " + (cents / 10) + " Dime";
        cents %= 10;
      }
    }

    while (cents / 5 >= 1) {
      if (cents / 5 > 1){
        combination += " " + (cents / 5) + " Nickels";
        cents %= 5;
      }else {
        combination += " " + (cents / 5) + " Nickel";
        cents %= 5;
      }
    }
    if (cents > 0) {
      if (cents > 1){
        combination += " " +cents + " Pennies";
      }else {
        combination += " " +cents + " Penny";
      }
    }


    return combination;
  }
}
