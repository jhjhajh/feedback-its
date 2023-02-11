package sg.edu.nus.se.its.feedback.hint;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import sg.edu.nus.se.its.feedback.utils.TestUtils;
import sg.edu.nus.se.its.model.Program;
import sg.edu.nus.se.its.repair.RepairCandidate;

/**
 * Test collection for PartialHint class.
 */
public class PartialHintTest {
  @Test
  public void PartialHintTest_changeInConstantValue_1() {
    String repairFileName = "c1.c";
    String originalProgramFileName = "i1.c";
    System.out.println(">> testing: " + repairFileName);

    String
            repairCandidatePath =
            "./src/test/resources/repair/" + repairFileName + ".json";
    String
            originalProgramFilePath =
            "./src/test/resources/model/" + originalProgramFileName + ".json";

    RepairCandidate
            repairCandidate =
            TestUtils.loadRepairCandidateFromFile(repairCandidatePath);
    assert repairCandidate != null;

    Program originalProgram = TestUtils.loadProgramByFilePath(originalProgramFilePath);

    assertNotNull(repairCandidate,
            "["
                    + repairFileName
                    + "] "
                    + "The generated list of repair must not be null.");

    PartialHint hint = new PartialHint();
    String feedback = hint.getHint(repairCandidate, originalProgram);

    assertNotNull(feedback,
            "[" + repairFileName + "] The generated feedback must not be null.");
    assertTrue(feedback.length() > 0,
            "[" + repairFileName + "] The generated feedback must not be empty.");
    assertEquals("Location of error: at the beginning of the function 'main'\n"
            + "\n"
            + "The hints are as follows:\n"
            + "\n"
            + "Recheck left hand side of the \"+\" operation\n", feedback);

    System.out.println(feedback);
  }

  @Test
  public void PartialHintTest_changeInConstantValue_2() {
    String repairFileName = "c2.c";
    String originalProgramFileName = "i2.c";
    System.out.println(">> testing: " + repairFileName);

    String
            repairCandidatePath =
            "./src/test/resources/repair/" + repairFileName + ".json";
    String
            originalProgramFilePath =
            "./src/test/resources/model/" + originalProgramFileName + ".json";

    RepairCandidate
            repairCandidate =
            TestUtils.loadRepairCandidateFromFile(repairCandidatePath);
    assert repairCandidate != null;

    Program originalProgram = TestUtils.loadProgramByFilePath(originalProgramFilePath);

    assertNotNull(repairCandidate,
            "["
                    + repairFileName
                    + "] "
                    + "The generated list of repair must not be null.");

    PartialHint hint = new PartialHint();
    String feedback = hint.getHint(repairCandidate, originalProgram);

    assertNotNull(feedback,
            "[" + repairFileName + "] The generated feedback must not be null.");
    assertTrue(feedback.length() > 0,
            "[" + repairFileName + "] The generated feedback must not be empty.");
    assertEquals("Location of error: at the beginning of the function 'main'\n"
            + "\n"
            + "The hints are as follows:\n"
            + "\n"
            + "Recheck left hand side of the \"+\" operation\n", feedback);

    System.out.println(feedback);
  }

  @Test
  public void PartialHintTest_simpleIte() {
    String repairFileName = "c3.c";
    String originalProgramFileName = "i3.c";
    System.out.println(">> testing: " + repairFileName);

    String
            repairCandidatePath =
            "./src/test/resources/repair/" + repairFileName + ".json";
    String
            originalProgramFilePath =
            "./src/test/resources/model/" + originalProgramFileName + ".json";

    RepairCandidate
            repairCandidate =
            TestUtils.loadRepairCandidateFromFile(repairCandidatePath);
    assert repairCandidate != null;

    Program originalProgram = TestUtils.loadProgramByFilePath(originalProgramFilePath);

    assertNotNull(repairCandidate,
            "["
                    + repairFileName
                    + "] "
                    + "The generated list of repair must not be null.");

    PartialHint hint = new PartialHint();
    String feedback = hint.getHint(repairCandidate, originalProgram);

    assertNotNull(feedback,
            "[" + repairFileName + "] The generated feedback must not be null.");
    assertTrue(feedback.length() > 0,
            "[" + repairFileName + "] The generated feedback must not be empty.");
    assertEquals("Location of error: at the beginning of the function 'main'\n"
            + "\n"
            + "The hints are as follows:\n"
            + "\n"
            + "In the condition of the if then else statement:\n"
            + "\n"
            + "Recheck left hand side of the \"==\" operation\n"
            + "----------\n", feedback);

    System.out.println(feedback);
  }

  @Test
  public void PartialHintTest_listOfIte_1() {
    String repairFileName = "c4.c";
    String originalProgramFileName = "i4.c";
    System.out.println(">> testing: " + repairFileName);

    String
            repairCandidatePath =
            "./src/test/resources/repair/" + repairFileName + ".json";
    String
            originalProgramFilePath =
            "./src/test/resources/model/" + originalProgramFileName + ".json";

    RepairCandidate
            repairCandidate =
            TestUtils.loadRepairCandidateFromFile(repairCandidatePath);
    assert repairCandidate != null;

    Program originalProgram = TestUtils.loadProgramByFilePath(originalProgramFilePath);

    assertNotNull(repairCandidate,
            "["
                    + repairFileName
                    + "] "
                    + "The generated list of repair must not be null.");

    PartialHint hint = new PartialHint();
    String feedback = hint.getHint(repairCandidate, originalProgram);

    assertNotNull(feedback,
            "[" + repairFileName + "] The generated feedback must not be null.");
    assertTrue(feedback.length() > 0,
            "[" + repairFileName + "] The generated feedback must not be empty.");
    assertEquals("Location of error: at the beginning of the function 'main'\n"
            + "\n"
            + "The hints are as follows:\n"
            + "\n"
            + "In the condition of the if then else statement:\n"
            + "\n"
            + "Recheck left hand side of the \"==\" operation\n"
            + "Recheck right hand side of the \"==\" operation\n"
            + "----------\n", feedback);

    System.out.println(feedback);
  }

  @Test
  public void PartialHintTest_listOfIte_2() {
    String repairFileName = "c5.c";
    String originalProgramFileName = "i5.c";
    System.out.println(">> testing: " + repairFileName);

    String
            repairCandidatePath =
            "./src/test/resources/repair/" + repairFileName + ".json";
    String
            originalProgramFilePath =
            "./src/test/resources/model/" + originalProgramFileName + ".json";

    RepairCandidate
            repairCandidate =
            TestUtils.loadRepairCandidateFromFile(repairCandidatePath);
    assert repairCandidate != null;

    Program originalProgram = TestUtils.loadProgramByFilePath(originalProgramFilePath);

    assertNotNull(repairCandidate,
            "["
                    + repairFileName
                    + "] "
                    + "The generated list of repair must not be null.");

    PartialHint hint = new PartialHint();
    String feedback = hint.getHint(repairCandidate, originalProgram);

    assertNotNull(feedback,
            "[" + repairFileName + "] The generated feedback must not be null.");
    assertTrue(feedback.length() > 0,
            "[" + repairFileName + "] The generated feedback must not be empty.");
    assertEquals("Location of error: at the beginning of the function 'main'\n"
            + "\n"
            + "The hints are as follows:\n"
            + "\n"
            + "In the condition of the if then else statement:\n"
            + "\n"
            + "Please recheck the operation\n"
            + "----------\n"
            + "\n"
            + "Inside the if branch:\n"
            + "\n"
            + "Please recheck the statement being printed\n"
            + "----------\n"
            + "\n"
            + "Inside the else branch:\n"
            + "\n"
            + "Recheck whether the following is correct: \n"
            + "if(a < 0){\n"
            + "    Print \"%.4f\" with the value(s) of variable(s) a replacing the placeholder(s)\n"
            + "}\n"
            + "Print \" is negative\"\n"
            + "Print \"%.4f\" with the value(s) of variable(s) a replacing the placeholder(s)\n"
            + "Print \" is positive\"\n"
            + "\n"
            + "----------\n", feedback);

    System.out.println(feedback);
  }

  @Test
  public void PartialHintTest_rightHandSideOfOperation() {
    String repairFileName = "test2_b.c";
    String originalProgramFileName = "test2_c.c";
    System.out.println(">> testing: " + repairFileName);

    String
            repairCandidatePath =
            "./src/test/resources/repair/" + repairFileName + ".json";
    String
            originalProgramFilePath =
            "./src/test/resources/model/" + originalProgramFileName + ".json";

    RepairCandidate
            repairCandidate =
            TestUtils.loadRepairCandidateFromFile(repairCandidatePath);
    assert repairCandidate != null;

    Program originalProgram = TestUtils.loadProgramByFilePath(originalProgramFilePath);

    assertNotNull(repairCandidate,
            "["
                    + repairFileName
                    + "] "
                    + "The generated list of repair must not be null.");

    PartialHint hint = new PartialHint();
    String feedback = hint.getHint(repairCandidate, originalProgram);

    assertNotNull(feedback,
            "[" + repairFileName + "] The generated feedback must not be null.");
    assertTrue(feedback.length() > 0,
            "[" + repairFileName + "] The generated feedback must not be empty.");
    assertEquals("Location of error: the condition of the 'for' loop at line 8\n"
            + "\n"
            + "The hints are as follows:\n"
            + "\n"
            + "Recheck right hand side of the \"<=\" operation\n", feedback);

    System.out.println(feedback);
  }

  @Test
  public void PartialHintTest_nestedIte() {
    String repairFileName = "test6_b.c";
    String originalProgramFileName = "test6_c.c";
    System.out.println(">> testing: " + repairFileName);

    String
            repairCandidatePath =
            "./src/test/resources/repair/" + repairFileName + ".json";
    String
            originalProgramFilePath =
            "./src/test/resources/model/" + originalProgramFileName + ".json";

    RepairCandidate
            repairCandidate =
            TestUtils.loadRepairCandidateFromFile(repairCandidatePath);
    assert repairCandidate != null;

    Program originalProgram = TestUtils.loadProgramByFilePath(originalProgramFilePath);

    assertNotNull(repairCandidate,
            "["
                    + repairFileName
                    + "] "
                    + "The generated list of repair must not be null.");

    PartialHint hint = new PartialHint();
    String feedback = hint.getHint(repairCandidate, originalProgram);

    assertNotNull(feedback,
            "[" + repairFileName + "] The generated feedback must not be null.");
    assertTrue(feedback.length() > 0,
            "[" + repairFileName + "] The generated feedback must not be empty.");
    assertEquals("Location of error: at the beginning of the function 'main'\n"
            + "\n"
            + "The hints are as follows:\n"
            + "\n"
            + "In the condition of the if then else statement:\n"
            + "\n"
            + "Recheck left hand side of the \"==\" operation\n"
            + "----------\n"
            + "\n"
            + "Inside the if branch:\n"
            + "\n"
            + "-->In the condition of the if then else statement:\n"
            + "\n"
            + "Recheck left hand side of the \"==\" operation\n"
            + "\n"
            + "\n"
            + "-->Inside the if branch:\n"
            + "\n"
            + "Recheck whether the following is correct: \n"
            + "if(y % 400"
            + " == 0){\n"
            + "    Print \"Leap Year\"\n"
            + "} else {\n"
            + "    Print \"Not Leap Year\"\n"
            + "}\n"
            + "\n"
            + "\n"
            + "\n"
            + "-->Inside the else branch:\n"
            + "\n"
            + "Recheck whether the following is required: \n"
            + "Print \"Leap Year\"\n"
            + "\n"
            + "\n"
            + "\n"
            + "----------\n"
            + "\n"
            + "Inside the else branch:\n"
            + "\n"
            + "Recheck whether the following is correct: \n"
            + "Print \"Not Leap Year\"\n"
            + "\n"
            + "----------\n", feedback);

    System.out.println(feedback);
  }

  @Test
  public void PartialHintTest_emptyLocalRepair() {
    String repairFileName = "test7_b.c";
    String originalProgramFileName = "test7_c.c";
    System.out.println(">> testing: " + repairFileName);

    String
            repairCandidatePath =
            "./src/test/resources/repair/" + repairFileName + ".json";
    String
            originalProgramFilePath =
            "./src/test/resources/model/" + originalProgramFileName + ".json";

    RepairCandidate
            repairCandidate =
            TestUtils.loadRepairCandidateFromFile(repairCandidatePath);
    assert repairCandidate != null;

    Program originalProgram = TestUtils.loadProgramByFilePath(originalProgramFilePath);

    assertNotNull(repairCandidate,
            "["
                    + repairFileName
                    + "] "
                    + "The generated list of repair must not be null.");

    PartialHint hint = new PartialHint();
    String feedback = hint.getHint(repairCandidate, originalProgram);

    assertNotNull(feedback,
            "[" + repairFileName + "] The generated feedback must not be null.");
    assertTrue(feedback.length() > 0,
            "[" + repairFileName + "] The generated feedback must not be empty.");
    assertEquals("No repair required.", feedback);

    System.out.println(feedback);
  }
}
