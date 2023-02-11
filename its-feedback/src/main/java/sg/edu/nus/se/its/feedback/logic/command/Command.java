package sg.edu.nus.se.its.feedback.logic.command;

/**
 * Represents a command with hidden internal logic and the ability to be executed.
 */
public abstract class Command {

  /**
   *
   * @return
   * @throws Exception
   */
  public abstract CommandExecute execute(/*Model model*/);
}
