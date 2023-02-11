package utils;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.jupiter.api.Test;
import sg.edu.nus.se.its.feedback.utils.TestUtils;
import sg.edu.nus.se.its.model.Expression;
import sg.edu.nus.se.its.model.Program;
import sg.edu.nus.se.its.repair.RepairCandidate;
import sg.edu.nus.se.its.util.JsonSerializerWithInheritance;

public class TestUtilsTest {
  @Test
  public void testUtilsTest_loadProgramByFilePath() {
    Program actualProgram = TestUtils.loadProgramByFilePath("./src/test/resources/model/test5_b.c"
        + ".json");
    GsonBuilder builder = new GsonBuilder();
    builder.registerTypeAdapter(Expression.class,
        new JsonSerializerWithInheritance<Expression>());
    Gson gson = builder.create();
    File modelFile = new File("./src/test/resources/model/test5_b.c");
    try {
      Program expectedProgram = gson.fromJson(new FileReader(modelFile), Program.class);
      assertTrue(EqualsBuilder.reflectionEquals(expectedProgram, actualProgram));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testUtilsTest_loadRepairCandidateFromFile() {
    RepairCandidate actual = TestUtils
        .loadRepairCandidateFromFile("./src/test/resources/model/test5_b.c"
            + ".json");
    GsonBuilder builder = new GsonBuilder().enableComplexMapKeySerialization();
    builder.registerTypeAdapter(Expression.class, new JsonSerializerWithInheritance<Expression>());
    Gson gson = builder.create();
    File modelFile = new File("./src/test/resources/mdoel/test5_b.c"
        + ".json");
    try {
      RepairCandidate expected = gson.fromJson(new FileReader(modelFile), RepairCandidate.class);
      assertTrue(EqualsBuilder.reflectionEquals(expected, actual));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

  }
}
