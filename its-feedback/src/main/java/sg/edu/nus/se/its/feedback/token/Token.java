package sg.edu.nus.se.its.feedback.token;

import static sg.edu.nus.se.its.feedback.utils.Constants.FULL_HINT_LEVEL;
import static sg.edu.nus.se.its.feedback.utils.Constants.FULL_HINT_TOKEN_COUNT;
import static sg.edu.nus.se.its.feedback.utils.Constants.PARTIAL_HINT_LEVEL;
import static sg.edu.nus.se.its.feedback.utils.Constants.PARTIAL_HINT_TOKEN_COUNT;

/**
 * Class for token count deduction.
 */
public class Token {

  private int balance;

  public Token(int balance) {
    this.balance = balance;
  }

  /**
  * Checks if there is enough token count to be deducted.
  *
  * @param hintLevel  hint level selected by student
  * @return true if there is enough tokens, false if there are not enough tokens
  */
  public boolean isEnoughPoints(int hintLevel) {
    int hintTokenCount;
    if (hintLevel == PARTIAL_HINT_LEVEL) {
      hintTokenCount = PARTIAL_HINT_TOKEN_COUNT;
    } else if (hintLevel == FULL_HINT_LEVEL) {
      hintTokenCount = FULL_HINT_TOKEN_COUNT;
    } else {
      return false;
    }
    return getBalance() - hintTokenCount >= 0;
  }

//  public boolean isEnoughPoints(int tokenCount, int hintLevel) {
//    int hintTokenCount;
//    if (hintLevel == PARTIAL_HINT_LEVEL) {
//      hintTokenCount = PARTIAL_HINT_TOKEN_COUNT;
//    } else if (hintLevel == FULL_HINT_LEVEL) {
//      hintTokenCount = FULL_HINT_TOKEN_COUNT;
//    } else {
//      return false;
//    }
//    return tokenCount - hintTokenCount >= 0;
//  }

  /**
  * Deducts token count required for partial hint and returns new token count after deduction.
  *
  * @return tokenCount final token count of student
  */
  public int deductForPartialHint() {
    this.balance -= PARTIAL_HINT_TOKEN_COUNT;
    return this.getBalance();
  }

  /**
  * Deducts token count required for full hint and returns new token count after deduction.
  *
  * @return tokenCount final token count of student
  */
  public int deductForFullHint() {
    this.balance -= FULL_HINT_TOKEN_COUNT;
    return this.balance;
  }

  public int getBalance() {
    return this.balance;
  }
}
