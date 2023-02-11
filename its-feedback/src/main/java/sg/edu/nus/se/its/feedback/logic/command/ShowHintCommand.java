package sg.edu.nus.se.its.feedback.logic.command;

import sg.edu.nus.se.its.feedback.StudentFeedback;
import sg.edu.nus.se.its.feedback.hint.FullHint;
import sg.edu.nus.se.its.feedback.hint.LineNumberHint;
import sg.edu.nus.se.its.feedback.hint.PartialHint;
import sg.edu.nus.se.its.feedback.token.Token;
import sg.edu.nus.se.its.feedback.utils.Constants;
import sg.edu.nus.se.its.model.Program;
import sg.edu.nus.se.its.repair.Repair;
import sg.edu.nus.se.its.repair.RepairCandidate;

public class ShowHintCommand extends Command{

  public final String userInput;
  public Token token;
  RepairCandidate repairCandidate;
  int hintLevel = 0;
  String generatedFeedback = "";
  Program originalProgram;


  /**
   * @param userInput
   */
  public ShowHintCommand(String userInput, Token token, RepairCandidate repairCandidate
          , Program originalProgram) {
    this.userInput = userInput;
    this.token = token;
    this.repairCandidate = repairCandidate;
    this.originalProgram = originalProgram;
  }

  /**
   *
   */
  @Override
  public CommandExecute execute(/*Model model*/){
    switch(hintLevel) {
      case 0:
        LineNumberHint lineNumberHint = new LineNumberHint();
        generatedFeedback =
                "Line number hint\n" + lineNumberHint.getHint(this.repairCandidate, originalProgram);
        hintLevel+=1;
        break;
      case 1:
        if (token.isEnoughPoints(Constants.PARTIAL_HINT_LEVEL)) {
          PartialHint partialHint = new PartialHint();
          generatedFeedback = "Partial hints\n" + partialHint.getHint(repairCandidate,
                  originalProgram);
        }
        break;
      case 2:
        if (token.isEnoughPoints(Constants.FULL_HINT_LEVEL)) {
          FullHint fullHint = new FullHint();
          generatedFeedback = "Full hints\n" + fullHint.getHint(repairCandidate, originalProgram);
        }
      default:
        throw new IllegalStateException("Unexpected value: " + hintLevel);
    }
    return new CommandExecute(userInput);
  }

  public String getGeneratedFeedback() {
    return generatedFeedback;
  }
}
