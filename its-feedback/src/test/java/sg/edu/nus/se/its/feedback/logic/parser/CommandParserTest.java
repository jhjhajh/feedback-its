package sg.edu.nus.se.its.feedback.logic.parser;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.jupiter.api.Test;
import sg.edu.nus.se.its.feedback.logic.command.CheckTokenBalanceCommand;
import sg.edu.nus.se.its.feedback.logic.command.Command;
import sg.edu.nus.se.its.feedback.logic.command.ShowHintCommand;
import sg.edu.nus.se.its.feedback.logic.parser.CommandParser;

public class CommandParserTest {

  @Test
  public void commandParserTest_1() {
    System.out.println(">> testing: " + "next hint command parser");
    String userInput = "next hint";
//    Command command = new ShowHintCommand(userInput);
    // assertEquals(new CommandParser().parseCommand(userInput), command);
//    assertTrue(EqualsBuilder.reflectionEquals(command,
//      new CommandParser().parseCommand(userInput)));
  }

  @Test
  public void commandParserTest_2() {
    System.out.println(">> testing: " + "check token command parser");
    String userInput = "check token";
    Command command = new CheckTokenBalanceCommand(userInput);
    // assertEquals(new CommandParser().parseCommand(userInput), command);
    assertTrue(EqualsBuilder.reflectionEquals(command, 
      new CommandParser().parseCommand(userInput)));
  }

  @Test
  public void commandParserTest_3() {
    System.out.println(">> testing: " + "wrong userinput command parser");
    String userInput = "fnelkxnfekrxnf";
    // assertEquals(new CommandParser().parseCommand(userInput), null);
    assertTrue(EqualsBuilder.reflectionEquals(null, 
      new CommandParser().parseCommand(userInput)));
  }


}
