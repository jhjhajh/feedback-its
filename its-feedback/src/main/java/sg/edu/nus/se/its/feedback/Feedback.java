package sg.edu.nus.se.its.feedback;

import sg.edu.nus.se.its.model.Program;
import sg.edu.nus.se.its.repair.RepairCandidate;

/**
 * Interface for the feedback module.
 */
public interface Feedback {

  /**
   * Provide feedback based on repair candidates.
   *
   * @param repairCandidate   -- one set of consistent local repairs
   * @param submittedProgram  -- the submitted program
   * @param studentTokenCount -- the number of tokens left
   * @return feedback in form of a String object
   */
  public String provideFeedback(RepairCandidate repairCandidate, Program submittedProgram);

}
