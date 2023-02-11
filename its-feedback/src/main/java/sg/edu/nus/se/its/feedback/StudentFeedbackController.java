package sg.edu.nus.se.its.feedback;

import sg.edu.nus.se.its.feedback.hint.FullHint;
import sg.edu.nus.se.its.feedback.hint.LineNumberHint;
import sg.edu.nus.se.its.feedback.hint.PartialHint;
import sg.edu.nus.se.its.model.Program;
import sg.edu.nus.se.its.repair.RepairCandidate;

/**
 * Controller class for Student Feedback view.
 */
public class StudentFeedbackController {
  /**
   * Generates and compiles all the different feedback types.
   *
   * @param repairCandidate repair candidate for which to generate feedback
   * @param submittedProgram erroneous program submitted by the student
   * @return compilation of feedback
   */
  public static String generateFeedback(RepairCandidate repairCandidate,
                                        Program submittedProgram) {
    StringBuilder generatedFeedback = new StringBuilder();
    LineNumberHint lineNumberHint = new LineNumberHint();
    generatedFeedback.append("Line numbers with errors are as follows: \n")
            .append(lineNumberHint.getHint(repairCandidate, submittedProgram))
            .append("\n");
    PartialHint partialHint = new PartialHint();
    generatedFeedback.append("Partial hints are as follows: \n")
            .append(partialHint.getHint(repairCandidate, submittedProgram));
    FullHint fullHint = new FullHint();
    generatedFeedback.append("Full hints are as follows: \n")
            .append(fullHint.getHint(repairCandidate, submittedProgram));
    return generatedFeedback.toString();
  }
}
