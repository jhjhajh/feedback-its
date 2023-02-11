package sg.edu.nus.se.its.feedback.logic.command;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.jupiter.api.Test;


public class CheckTokenBalanceCommandTest {

  @Test
  public void checkTokenBalanceCommandTest_1() {
    System.out.println(">> testing: " + "get token");
    String userInput = "check token";
    int tokenCount = 1; //change to whatever is in student feedback when implemented
    assertTrue(EqualsBuilder.reflectionEquals(tokenCount, 
      new CheckTokenBalanceCommand(userInput).getTokenCount()));
  }

  @Test
  public void checkTokenBalanceCommandTest_2() throws Exception {
    System.out.println(">> testing: " + "command execute");
    String userInput = "check token";
    CommandExecute commandExecute = new CommandExecute(userInput);
    assertTrue(EqualsBuilder.reflectionEquals(commandExecute, 
      new CheckTokenBalanceCommand(userInput).execute()));
    
  }
}
