package sg.edu.nus.se.its.feedback;


import sg.edu.nus.se.its.model.Program;
import sg.edu.nus.se.its.repair.RepairCandidate;

/**
 * Class for student feedback.
 */
public class StudentFeedback implements Feedback {

  /**
   * Provide feedback based on repair candidates.
   *
   * @param repairCandidate   -- one set of consistent local repairs
   * @param submittedProgram  -- the submitted program
   * @return feedback in form of a String object
   */
  @Override
  public String provideFeedback(RepairCandidate repairCandidate,
                                Program submittedProgram) {
    String generatedFeedback = StudentFeedbackController.generateFeedback(repairCandidate,
            submittedProgram);
    return generatedFeedback;
  }

}
