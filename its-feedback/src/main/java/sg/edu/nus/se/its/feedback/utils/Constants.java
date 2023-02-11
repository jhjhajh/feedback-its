package sg.edu.nus.se.its.feedback.utils;

/**
 * Constant values used in the intermediate representation of the Feedback module of
 * Intelligent Tutoring System (ITS).
 */
public class Constants {
  /**
  * Constant integer to represent the integer hint level of partial hints.
  */
  public static final int PARTIAL_HINT_LEVEL = 2;

  /**
  * Constant integer to represent the integer hint level of full hints.
  */
  public static final int FULL_HINT_LEVEL = 3;

  /**
  * Constant integer to represent the default token count to be deducted for partial hints.
  */
  public static final int PARTIAL_HINT_TOKEN_COUNT = 5;

  /**
  * Constant integer to represent the default token count to be deducted for full hints.
  */
  public static final int FULL_HINT_TOKEN_COUNT = 10;

  /**
   * Constant string to output for submissions without mistakes.
   */
  public static final String NO_MISTAKES_FEEDBACK = "Congratulations! Your programme is correct. "
      + "Keep up the good work!";

  /**
   * Constant string to output for submissions without mistakes.
   */
  public static final String WELCOME_MESSAGE = "Hello! Welcome\n";

  public static final String OPTIONS_MESSAGE =
          "Please choose one of the following options by typing in the corresponding number:\n"
          + "[1]  View Token Balance\n"
          + "[2]  View Line Numbers which have errors\n"
          + "[3]  View Partial Hint\n"
          + "[4]  View Full Hint\n"
          + "[-1] Exit\n";

  public static final String EXIT_MESSAGE = "Bye bye!\n";

}

