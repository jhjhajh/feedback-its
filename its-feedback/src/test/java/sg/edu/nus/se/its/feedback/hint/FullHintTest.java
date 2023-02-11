package sg.edu.nus.se.its.feedback.hint;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import sg.edu.nus.se.its.feedback.utils.TestUtils;
import sg.edu.nus.se.its.model.Program;
import sg.edu.nus.se.its.repair.RepairCandidate;

/**
 * Test collection for FullHint class.
 */
public class FullHintTest {
  @Test
  public void FullHintTest_changeInConstantValue_1() {
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

    FullHint hint = new FullHint();
    String feedback = hint.getHint(repairCandidate, originalProgram);

    assertNotNull(feedback,
            "[" + repairFileName + "] The generated feedback must not be null.");
    assertTrue(feedback.length() > 0,
            "[" + repairFileName + "] The generated feedback must not be empty.");
    assertEquals("Location of error: at the beginning of the function 'main'\n"
                    + "\n"
                    + "The hints are as follows:\n"
                    + "\n"
                    + "Left hand side of the \"+\" operation should be 1 instead of 5\n",
            feedback);

    System.out.println(feedback);
  }

  @Test
  public void FullHintTest_changeInConstantValue_2() {
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

    FullHint hint = new FullHint();
    String feedback = hint.getHint(repairCandidate, originalProgram);

    assertNotNull(feedback,
            "[" + repairFileName + "] The generated feedback must not be null.");
    assertTrue(feedback.length() > 0,
            "[" + repairFileName + "] The generated feedback must not be empty.");
    assertEquals("Location of error: at the beginning of the function 'main'\n"
                    + "\n"
                    + "The hints are as follows:\n"
                    + "\n"
                    + "Left hand side of the \"+\" operation should be 1 instead of 5\n",
            feedback);

    System.out.println(feedback);
  }

  @Test
  public void FullHintTest_simpleIte() {
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

    FullHint hint = new FullHint();
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
            + "Left hand side of the \"==\" operation should be x instead of y\n"
            + "----------\n", feedback);

    System.out.println(feedback);
  }

  @Test
  public void FullHintTest_listOfIte_1() {
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

    FullHint hint = new FullHint();
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
            + "Left hand side of the \"==\" operation should be a1 * b2 - a2 * b1 instead of a1 / a2\n"
            + "Right hand side of the \"==\" operation should be 0 instead of b1 / b2\n"
            + "----------\n", feedback);

    System.out.println(feedback);
  }

  @Test
  public void FullHintTest_listOfIte_2() {
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

    FullHint hint = new FullHint();
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
            + "Change operation == to <\n"
            + "----------\n"
            + "\n"
            + "Inside the if branch:\n"
            + "\n"
            + "Print \"%.4f is negative\" with the value(s) of variable(s) a replacing the placeholder(s) instead of \"input is zero\"\n"
            + "----------\n"
            + "\n"
            + "Inside the else branch:\n"
            + "\n"
            + "Change the following: \n"
            + "if(a < 0){\n"
            + "    Print \"%.4f\" with the value(s) of variable(s) a replacing the placeholder(s)\n"
            + "}\n"
            + "Print \" is negative\"\n"
            + "Print \"%.4f\" with the value(s) of variable(s) a replacing the placeholder(s)\n"
            + "Print \" is positive\"\n"
            + "\n"
            + "to the following: \n"
            + "if(a > 0){\n"
            + "    Print \"%.4f is positive\" with the value(s) of variable(s) a replacing the placeholder(s)\n"
            + "} else {\n"
            + "    Print \"input is zero\"\n"
            + "}\n"
            + "\n"
            + "----------\n", feedback);

    System.out.println(feedback);
  }

  @Test
  public void FullHintTest_rightHandSideOfOperation() {
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

    FullHint hint = new FullHint();
    String feedback = hint.getHint(repairCandidate, originalProgram);

    assertNotNull(feedback,
            "[" + repairFileName + "] The generated feedback must not be null.");
    assertTrue(feedback.length() > 0,
            "[" + repairFileName + "] The generated feedback must not be empty.");
    assertEquals("Location of error: the condition of the 'for' loop at line 8\n"
                    + "\n"
                    + "The hints are as follows:\n"
                    + "\n"
                    + "Right hand side of the \"<=\" operation should be n instead of i\n",
            feedback);

    System.out.println(feedback);
  }

  @Test
  public void FullHintTest_nestedIte() {
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

    FullHint hint = new FullHint();
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
            + "Left hand side of the \"==\" operation should be y % 100 instead of y % 4\n"
            + "----------\n"
            + "\n"
            + "Inside the if branch:\n"
            + "\n"
            + "-->In the condition of the if then else statement:\n"
            + "\n"
            + "Left hand side of the \"==\" operation should be y % 400 instead of y % 100\n"
            + "\n"
            + "\n"
            + "-->Inside the if branch:\n"
            + "\n"
            + "Change the following: \n"
            + "if(y % 400 == 0){\n"
            + "    Print \"Leap Year\"\n"
            + "} else {\n"
            + "    Print \"Not Leap Year\"\n"
            + "}\n"
            + "\n"
            + "to the following: \n"
            + "Print \"Leap Year\"\n"
            + "\n"
            + "\n"
            + "\n"
            + "-->Inside the else branch:\n"
            + "\n"
            + "Delete the following: \n"
            + "Print \"Leap Year\"\n"
            + "\n"
            + "\n"
            + "\n"
            + "----------\n"
            + "\n"
            + "Inside the else branch:\n"
            + "\n"
            + "Change the following: \n"
            + "Print \"Not Leap Year\"\n"
            + "\n"
            + "to the following: \n"
            + "if(y % 4 == 0){\n"
            + "    Print \"Leap Year\"\n"
            + "} else {\n"
            + "    Print \"Not Leap Year\"\n"
            + "}\n"
            + "\n"
            + "----------\n", feedback);

    System.out.println(feedback);
  }

  @Test
  public void FullHintTest_emptyLocalRepair() {
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

    FullHint hint = new FullHint();
    String feedback = hint.getHint(repairCandidate, originalProgram);

    assertNotNull(feedback,
            "[" + repairFileName + "] The generated feedback must not be null.");
    assertTrue(feedback.length() > 0,
            "[" + repairFileName + "] The generated feedback must not be empty.");
    assertEquals("No repair required.", feedback);

    System.out.println(feedback);
  }

}
