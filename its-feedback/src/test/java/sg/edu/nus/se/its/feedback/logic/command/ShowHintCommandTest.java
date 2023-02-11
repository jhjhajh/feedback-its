package sg.edu.nus.se.its.feedback.logic.command;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.jupiter.api.Test;


public class ShowHintCommandTest {

  @Test
  public void showHintCommandTest_2() throws Exception {
    System.out.println(">> testing: " + "command execute");
    String userInput = "show hint";
    CommandExecute commandExecute = new CommandExecute(userInput);
//    assertTrue(EqualsBuilder.reflectionEquals(commandExecute,
//      new ShowHintCommand(userInput).execute()));

  }

}
