package sg.edu.nus.se.its.feedback.logic.command;

public class CheckTokenBalanceCommand extends Command {
  int tokenCount;
  public final String userInput;

  public CheckTokenBalanceCommand(String userInput) {
    super();
    this.userInput = userInput;
  }

  public int getTokenCount() {
    tokenCount = 1;
    return tokenCount;
  }

  @Override
  public CommandExecute execute() {
    return new CommandExecute(userInput);
  }
}
