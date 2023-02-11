package sg.edu.nus.se.its.feedback.hint;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static sg.edu.nus.se.its.feedback.utils.TestUtils.loadRepairCandidateFromFile;
import static sg.edu.nus.se.its.feedback.utils.TestUtils.loadProgramByFilePath;

import org.junit.jupiter.api.Test;
import sg.edu.nus.se.its.model.Program;
import sg.edu.nus.se.its.repair.RepairCandidate;


/**
 * Test for Line Number feedback.
 */
public class LineNumberHintTest {

  @Test
  public void lineNumberHintTest_changeInConstantValue_1() {
    String repairFileName = "c1.c";
    String originalProgramFileName = "i1.c";
    System.out.println(">> testing: " + repairFileName);

    String repairCandidatePath = "./src/test/resources/repair/" + repairFileName + ".json";
    String originalProgramFilePath = "./src/test/resources/model/" + originalProgramFileName + ".json";

    RepairCandidate repairCandidate = loadRepairCandidateFromFile(repairCandidatePath);
    assert repairCandidate != null;
    Program originalProgram = loadProgramByFilePath(originalProgramFilePath);

    assertNotNull(repairCandidate,
        "[" + repairFileName + "] " + "The generated list of repair must not be null.");

    LineNumberHint hint = new LineNumberHint();
    String feedback = hint.getHint(repairCandidate, originalProgram);

    assertNotNull(feedback, "[" + repairFileName + "] The generated feedback must not be null.");
    assertTrue(feedback.length() > 0, "["
            + repairFileName
            + "] The generated feedback must not be empty.");
    assertEquals("Error found in line 5. Difficulty of repair: Easy.\n", feedback);

    System.out.println(feedback);
  }

  @Test
  public void lineNumberHintTest_changeInConstantValue_2() {
    String repairFileName = "c2.c";
    String originalProgramFileName = "i2.c";
    System.out.println(">> testing: " + repairFileName);

    String repairCandidatePath = "./src/test/resources/repair/" + repairFileName + ".json";
    String originalProgramFilePath = "./src/test/resources/model/" + originalProgramFileName + ".json";

    RepairCandidate repairCandidate = loadRepairCandidateFromFile(repairCandidatePath);

    assert repairCandidate != null;

    Program originalProgram = loadProgramByFilePath(originalProgramFilePath);

    assertNotNull(repairCandidate,
        "[" + repairFileName + "] " + "The generated list of repair must not be null.");

    LineNumberHint hint = new LineNumberHint();
    String feedback = hint.getHint(repairCandidate, originalProgram);

    assertNotNull(feedback, "[" + repairFileName + "] The generated feedback must not be null.");
    assertTrue(feedback.length() > 0, "["
            + repairFileName
            + "] The generated feedback must not be empty.");
    assertEquals("Error found in line 4. Difficulty of repair: Easy.\n", feedback);

    System.out.println(feedback);
  }

  @Test
  public void lineNumberHintTest_simpleIte() {
    String repairFileName = "c3.c";
    String originalProgramFileName = "i3.c";
    System.out.println(">> testing: " + repairFileName);

    String repairCandidatePath = "./src/test/resources/repair/" + repairFileName + ".json";
    String originalProgramFilePath = "./src/test/resources/model/" + originalProgramFileName + ".json";

    RepairCandidate repairCandidate = loadRepairCandidateFromFile(repairCandidatePath);
    assert repairCandidate != null;

    Program originalProgram = loadProgramByFilePath(originalProgramFilePath);

    assertNotNull(repairCandidate,
        "[" + repairFileName + "] " + "The generated list of repair must not be null.");

    LineNumberHint hint = new LineNumberHint();
    String feedback = hint.getHint(repairCandidate, originalProgram);

    assertNotNull(feedback, "[" + repairFileName + "] The generated feedback must not be null.");
    assertTrue(feedback.length() > 0, "["
            + repairFileName
            + "] The generated feedback must not be empty.");
    assertEquals("Error found between lines 5 and 7. Difficulty of repair: Easy.\n", feedback);

    System.out.println(feedback);
  }

  @Test
  public void lineNumberHintTest_listOfIte_1() {
    String repairFileName = "c4.c";

    String originalProgramFileName = "i4.c";
    System.out.println(">> testing: " + repairFileName);

    String repairCandidatePath = "./src/test/resources/repair/" + repairFileName + ".json";
    String originalProgramFilePath = "./src/test/resources/model/" + originalProgramFileName + ".json";

    RepairCandidate repairCandidate = loadRepairCandidateFromFile(repairCandidatePath);

    assert repairCandidate != null;

    Program originalProgram = loadProgramByFilePath(originalProgramFilePath);

    assertNotNull(repairCandidate,
        "[" + repairFileName + "] " + "The generated list of repair must not be null.");

    LineNumberHint hint = new LineNumberHint();
    String feedback = hint.getHint(repairCandidate, originalProgram);

    assertNotNull(feedback, "[" + repairFileName + "] The generated feedback must not be null.");
    assertTrue(feedback.length() > 0, "["
            + repairFileName
            + "] The generated feedback must not be empty.");
    assertEquals("Error found between lines 6 and 13. Difficulty of repair: Medium.\n"
            + "Error found between lines 6 and 12. Difficulty of repair: Medium.\n"
            + "Error found between lines 6 and 14. Difficulty of repair: Medium.\n", feedback);

    System.out.println(feedback);
  }

  @Test
  public void lineNumberHintTest_listOfIte_2() {
    String repairFileName = "c5.c";
    String originalProgramFileName = "i5.c";
    System.out.println(">> testing: " + repairFileName);

    String repairCandidatePath = "./src/test/resources/repair/" + repairFileName + ".json";
    String originalProgramFilePath = "./src/test/resources/model/" + originalProgramFileName + ".json";

    RepairCandidate repairCandidate = loadRepairCandidateFromFile(repairCandidatePath);

    assert repairCandidate != null;

    Program originalProgram = loadProgramByFilePath(originalProgramFilePath);
    assertNotNull(repairCandidate,
        "[" + repairFileName + "] " + "The generated list of repair must not be null.");

    LineNumberHint hint = new LineNumberHint();
    String feedback = hint.getHint(repairCandidate, originalProgram);

    assertNotNull(feedback, "[" + repairFileName + "] The generated feedback must not be null.");
    assertTrue(feedback.length() > 0, "["
            + repairFileName
            + "] The generated feedback must not be empty.");
    assertEquals("Error found between lines 6 and 15. "
            + "Difficulty of repair: Hard.\n", feedback);
    System.out.println(feedback);
  }

  @Test
  public void simpleTest_2_b() {
    String repairFileName = "test2_b.c";
    String originalProgramFileName = "test2_c.c";
    System.out.println(">> testing: " + repairFileName);

    String repairCandidatePath = "./src/test/resources/repair/" + repairFileName + ".json";
    String originalProgramFilePath = "./src/test/resources/model/" + originalProgramFileName + ".json";

    RepairCandidate repairCandidate = loadRepairCandidateFromFile(repairCandidatePath);
    assert repairCandidate != null;

    Program originalProgram = loadProgramByFilePath(originalProgramFilePath);

    assertNotNull(repairCandidate,
        "[" + repairFileName + "] " + "The generated list of repair must not be null.");

    LineNumberHint hint = new LineNumberHint();
    String feedback = hint.getHint(repairCandidate, originalProgram);

    assertNotNull(feedback, "[" + repairFileName + "] The generated feedback must not be null.");
    assertTrue(feedback.length() > 0, "["
            + repairFileName
            + "] The generated feedback must not be empty.");
    assertEquals("Error found in line 8. Difficulty of repair: Easy.\n", feedback);
    System.out.println(feedback);
  }

  @Test
  public void test5_b() {
    String repairFileName = "test5_b.c";
    String originalProgramFileName = "test5_c.c";
    System.out.println(">> testing: " + repairFileName);

    String repairCandidatePath = "./src/test/resources/repair/" + repairFileName + ".json";
    String originalProgramFilePath = "./src/test/resources/model/" + originalProgramFileName + ".json";

    RepairCandidate repairCandidate = loadRepairCandidateFromFile(repairCandidatePath);
    assert repairCandidate != null;

    Program originalProgram = loadProgramByFilePath(originalProgramFilePath);

    assertNotNull(repairCandidate,
        "[" + repairFileName + "] " + "The generated list of repair must not be null.");

    LineNumberHint hint = new LineNumberHint();
    String feedback = hint.getHint(repairCandidate, originalProgram);

    assertNotNull(feedback, "[" + repairFileName + "] The generated feedback must not be null.");
    assertTrue(feedback.length() > 0, "["
            + repairFileName
            + "] The generated feedback must not be empty.");
            assertEquals("Error found in line 7. Difficulty of repair: Easy.\n"
            + "Error found in line 10. Difficulty of repair: Hard.\n"
            + "Error found in line 11. Difficulty of repair: Medium.\n"
            + "Error found in line 7. Difficulty of repair: Medium.\n"
            + "Error found in line 15. Difficulty of repair: Hard.\n", feedback);
    System.out.println(feedback);
  }

  @Test
  public void test6_b() {
    String repairFileName = "test6_b.c";
    String originalProgramFileName = "test6_c.c";
    System.out.println(">> testing: " + repairFileName);

    String repairCandidatePath = "./src/test/resources/repair/" + repairFileName + ".json";
    String originalProgramFilePath = "./src/test/resources/model/" + originalProgramFileName + ".json";

    RepairCandidate repairCandidate = loadRepairCandidateFromFile(repairCandidatePath);
    assert repairCandidate != null;

    Program originalProgram = loadProgramByFilePath(originalProgramFilePath);
    assertNotNull(repairCandidate,
        "[" + repairFileName + "] " + "The generated list of repair must not be null.");

    LineNumberHint hint = new LineNumberHint();
    String feedback = hint.getHint(repairCandidate, originalProgram);

    assertNotNull(feedback, "[" + repairFileName + "] The generated feedback must not be null.");
    assertTrue(feedback.length() > 0, "["
            + repairFileName
            + "] The generated feedback must not be empty.");
    assertEquals("Error found in line 7. Difficulty of repair: Hard.\n", feedback);
    System.out.println(feedback);
  }

  @Test
  public void test_null_repairProgram_7_b() {
    String repairFileName = "test7_b.c";

    String originalProgramFileName = "test7_c.c";
    System.out.println(">> testing: " + repairFileName);

    String repairCandidatePath = "./src/test/resources/repair/" + repairFileName + ".json";
    String originalProgramFilePath = "./src/test/resources/model/" + originalProgramFileName + ".json";

    RepairCandidate repairCandidate = loadRepairCandidateFromFile(repairCandidatePath);

    assert repairCandidate != null;

    Program originalProgram = loadProgramByFilePath(originalProgramFilePath);

    assertNotNull(repairCandidate,
        "[" + repairFileName + "] " + "The generated list of repair must not be null.");

    LineNumberHint hint = new LineNumberHint();
    String feedback = hint.getHint(repairCandidate, originalProgram);

    assertNotNull(feedback, "[" + repairFileName + "] The generated feedback must not be null.");
    assertTrue(feedback.length() > 0, "["
             + repairFileName
             + "] The generated feedback must not be empty.");
    assertEquals("No repairs required.\n", feedback);
    System.out.println(feedback);

  }

}
