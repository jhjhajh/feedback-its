 package sg.edu.nus.se.its.feedback.hint;

 import static org.junit.jupiter.api.Assertions.assertEquals;

 import java.util.List;
 import org.junit.jupiter.api.Test;
 import sg.edu.nus.se.its.feedback.hint.FullHint;
 import sg.edu.nus.se.its.feedback.hint.Hint;
 import sg.edu.nus.se.its.feedback.utils.TestUtils;
 import sg.edu.nus.se.its.repair.LocalRepair;
 import sg.edu.nus.se.its.repair.RepairCandidate;

 /**
  * Test collection for Hint class.
  */
 public class HintTest {
   @Test
   public void hintTest_singleLocalRepairTest() {
     String repairCandidateFileName = "c1.c";
     RepairCandidate repairCandidate = TestUtils
         .loadRepairCandidateFromFile("./src/test/resources/repair/"
             + repairCandidateFileName + ".json");
     List<LocalRepair> expectedOutcome = repairCandidate.getLocalRepairs();
     List<LocalRepair> actualOutcome = Hint.getLocalRepairsArray(repairCandidate);
     assertEquals(expectedOutcome, actualOutcome);
   }

   @Test
   public void hintTest_listOfLocalRepairsTest() {
     String repairCandidateFileName = "c4.c";
     RepairCandidate repairCandidate = TestUtils
         .loadRepairCandidateFromFile("./src/test/resources/repair/"
             + repairCandidateFileName + ".json");
     List<LocalRepair> expectedOutcome = repairCandidate.getLocalRepairs();
     List<LocalRepair> actualOutcome = Hint.getLocalRepairsArray(repairCandidate);
     assertEquals(expectedOutcome, actualOutcome);
   }
 }

