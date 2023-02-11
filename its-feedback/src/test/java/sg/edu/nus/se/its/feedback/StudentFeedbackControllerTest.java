package sg.edu.nus.se.its.feedback;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import sg.edu.nus.se.its.feedback.utils.TestUtils;
import sg.edu.nus.se.its.model.Program;
import sg.edu.nus.se.its.repair.RepairCandidate;

/**
 * Test collection for Student Feedback class.
 */
public class StudentFeedbackControllerTest {
  @Test
  public void studentFeedbackTest_provideFeedback() {
    String repairCandidateFileName = "c1.c";
    RepairCandidate
            repairCandidate =
            TestUtils.loadRepairCandidateFromFile("./src/test/resources/repair/"
                    + repairCandidateFileName
                    + ".json");
    Program submittedProgram =
            TestUtils.loadProgramByFilePath("./src/test/resources/model/c1.c" + ".json");
    String expectedOutcome =
            "Line numbers with errors are as follows: \n"
                    + "Error found in line 5. Difficulty of repair: Easy.\n"
                    + "\n"
                    + "Partial hints are as follows: \n"
                    + "Location of error: at the beginning of the function 'main'\n"
                    + "\n"
                    + "The hints are as follows:\n"
                    + "\n"
                    + "Recheck left hand side of the \"+\" operation\n"
                    + "Full hints are as follows: \n"
                    + "Location of error: at the beginning of the function 'main'\n"
                    + "\n"
                    + "The hints are as follows:\n"
                    + "\n"
                    + "Left hand side of the \"+\" operation should be 1 instead of 5\n";
    String actualOutcome =
            StudentFeedbackController.generateFeedback(repairCandidate, submittedProgram);
    assertEquals(expectedOutcome, actualOutcome);
  }
}
