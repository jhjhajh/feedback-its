package sg.edu.nus.se.its.feedback.hint;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.jupiter.api.Test;
import sg.edu.nus.se.its.feedback.hint.HintParser;
import sg.edu.nus.se.its.feedback.hint.FullHintParser;
import sg.edu.nus.se.its.feedback.utils.TestUtils;
import sg.edu.nus.se.its.model.Expression;
import sg.edu.nus.se.its.repair.LocalRepair;
import sg.edu.nus.se.its.repair.RepairCandidate;

/**
 * Test collection for HintParser class.
 */
public class HintParserTest {
  @Test
  public void hintParserTest_changeInConstantCorrectedStatement() {
    String repairCandidateFileName = "c1.c";
    RepairCandidate repairCandidate = TestUtils
        .loadRepairCandidateFromFile("./src/test/resources/repair/"
            + repairCandidateFileName + ".json");
    LocalRepair localRepair = repairCandidate.getLocalRepairs().get(0);
    Expression expectedOutcome = localRepair.getRepairedVariable().getValue2();
    HintParser hintParser = new FullHintParser();
    Expression actualOutcome = hintParser.getCorrectExpression(localRepair);
    assertTrue(EqualsBuilder.reflectionEquals(expectedOutcome, actualOutcome));
  }

  @Test
  public void hintParserTest_changeInIteCorrectedStatement() {
    String repairCandidateFileName = "c3.c";
    RepairCandidate repairCandidate = TestUtils
        .loadRepairCandidateFromFile("./src/test/resources/repair/"
            + repairCandidateFileName + ".json");
    LocalRepair localRepair = repairCandidate.getLocalRepairs().get(0);
    Expression expectedOutcome = localRepair.getRepairedVariable().getValue2();
    HintParser hintParser = new FullHintParser();
    Expression actualOutcome = hintParser.getCorrectExpression(localRepair);
    assertTrue(EqualsBuilder.reflectionEquals(expectedOutcome, actualOutcome));
  }

  @Test
  public void hintParserTest_changeInConstantOriginalStatement() {
    String repairCandidateFileName = "c1.c";
    RepairCandidate repairCandidate = TestUtils
        .loadRepairCandidateFromFile("./src/test/resources/repair/"
            + repairCandidateFileName + ".json");
    LocalRepair localRepair = repairCandidate.getLocalRepairs().get(0);
    Expression expectedOutcome = localRepair.getRepairedVariable().getValue1();
    HintParser hintParser = new FullHintParser();
    Expression actualOutcome = hintParser.getOriginalExpression(localRepair);
    assertTrue(EqualsBuilder.reflectionEquals(expectedOutcome, actualOutcome));
  }
  
  @Test
  public void hintParserTest_changeInIteOriginalStatement() {
  String repairCandidateFileName = "c3.c";
  RepairCandidate repairCandidate = TestUtils
  .loadRepairCandidateFromFile("./src/test/resources/repair/"
  + repairCandidateFileName + ".json");
  LocalRepair localRepair = repairCandidate.getLocalRepairs().get(0);
  Expression expectedOutcome = localRepair.getRepairedVariable().getValue1();
  HintParser hintParser = new FullHintParser();
  Expression actualOutcome = hintParser.getOriginalExpression(localRepair);
  assertTrue(EqualsBuilder.reflectionEquals(expectedOutcome, actualOutcome));
  }
}
