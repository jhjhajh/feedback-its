package sg.edu.nus.se.its.feedback.hint;

import sg.edu.nus.se.its.model.Program;
import sg.edu.nus.se.its.repair.LocalRepair;

/**
 * Class for getting the full hint from repair candidates.
 */
public class FullHint extends Hint {
  public FullHint() {
  }

  /**
   * Get hints for an individual local repair.
   *
   * @param extractedFeedback string representation of local repair
   */
  public String getIndividualHint(LocalRepair extractedFeedback, Program originalProgram) {
    HintParser fullHintParser = new FullHintParser();
    String individualHint = fullHintParser.getHintWithErrorLocation(extractedFeedback,
            originalProgram);
    return individualHint;
  }
}
