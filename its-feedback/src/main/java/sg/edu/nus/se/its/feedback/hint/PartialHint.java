package sg.edu.nus.se.its.feedback.hint;

import sg.edu.nus.se.its.model.Expression;
import sg.edu.nus.se.its.model.Program;
import sg.edu.nus.se.its.repair.LocalRepair;

/**
 * Class for getting the partial hint from repair candidates.
 */
public class PartialHint extends Hint {
  /**
   * Class for getting partial hints from repair candidates.
   */
  public PartialHint() {
  }

  /**
   * Get hints for an individual local repair.
   *
   * @param extractedFeedback string representation of local repair
   */
  public String getIndividualHint(LocalRepair extractedFeedback, Program originalProgram) {
    HintParser partialHintParser = new PartialHintParser();
    String individualHint = partialHintParser.getHintWithErrorLocation(extractedFeedback, 
        originalProgram);
    return individualHint;
  }
  }
