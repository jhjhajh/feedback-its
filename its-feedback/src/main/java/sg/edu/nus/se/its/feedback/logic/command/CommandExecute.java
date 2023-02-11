package sg.edu.nus.se.its.feedback.logic.command;

/**
 * Represents the result of a command execution.
 */
public class CommandExecute{
  private String message;


  public CommandExecute(String userInput) {
    this.message = "Command: " + userInput + " has been executed.\n";
    System.out.println(message);
  }
}
