package sg.edu.nus.se.its.feedback.logic.parser;

import sg.edu.nus.se.its.feedback.logic.command.*;
import sg.edu.nus.se.its.feedback.logic.command.ShowHintCommand;

/**
 * Parses user input.
 */
public class CommandParser {
  /**
   *
   * @param userInput
   * @return
   */
  public static Command parseCommand(String userInput) {
    switch (userInput.toLowerCase()) {
      case ("next hint"):
        System.out.println("Input is next hint.\n");
//        return new ShowHintCommand(userInput.toLowerCase());
      case ("check token"):
        System.out.println("Input is check token.\n");
        return new CheckTokenBalanceCommand(userInput.toLowerCase());
      default: //maybe can throw exception
        System.out.println("This command is not recognized! Please try again.\n");
        return null;
    }
  }
}
