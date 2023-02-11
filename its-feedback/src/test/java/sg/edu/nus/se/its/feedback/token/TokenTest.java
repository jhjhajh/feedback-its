package sg.edu.nus.se.its.feedback.token;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Simple test collection for token functions unit test.
 */


public class TokenTest {


  int partialHintLevel = 2;
  int fullHintLevel = 3;
  int invalidHintLevel = 0;
  int sufficientTokenCount = 30;
  int insufficientTokenCount = 4;
    
  @Test
  public void isEnoughPointsTest_partialHintSufficient() {
    Token token = new Token(sufficientTokenCount);
    assertTrue(token.isEnoughPoints(partialHintLevel));
  } 

  @Test
  public void isEnoughPointsTest_partialHintInsufficient() {
    Token token = new Token(insufficientTokenCount);
    assertFalse(token.isEnoughPoints(partialHintLevel));
  } 

  @Test
  public void isEnoughPointsTest_FullHintSufficient() {
    Token token = new Token(sufficientTokenCount);
    assertTrue(token.isEnoughPoints(fullHintLevel));
  } 

  @Test
  public void isEnoughPointsTest_fullHintInsufficient() {
    Token token = new Token(insufficientTokenCount);
    assertFalse(token.isEnoughPoints(fullHintLevel));
  }

  @Test
  public void isEnoughPointsTest_invalidHintLevel() {
    Token token = new Token(sufficientTokenCount);
    assertFalse(token.isEnoughPoints(invalidHintLevel));
  }

  @Test
  public void partialHintDeduction_test() {
    Token token = new Token(sufficientTokenCount);
    assertEquals(25, token.deductForPartialHint());
  }

  @Test
  public void fullHintDeduction_test() {
    Token token = new Token(sufficientTokenCount);
    assertEquals(20, token.deductForFullHint());
  }


}
