package sg.edu.nus.se.its.feedback.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import sg.edu.nus.se.its.model.Expression;
import sg.edu.nus.se.its.model.Program;
import sg.edu.nus.se.its.repair.RepairCandidate;
import sg.edu.nus.se.its.util.JsonSerializerWithInheritance;

public class TestUtils {

  /**
   * Load RepairCandidate from file.
   *
   * @param filePath the file path
   * @return the variable mapping
   */
  public static RepairCandidate loadRepairCandidateFromFile(String filePath) {
    GsonBuilder builder = new GsonBuilder().enableComplexMapKeySerialization();
    builder.registerTypeAdapter(Expression.class, new JsonSerializerWithInheritance<Expression>());
    Gson gson = builder.create();
    File modelFile = new File(filePath);
    try {
      return gson.fromJson(new FileReader(modelFile), RepairCandidate.class);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Loads the Program model from the JSON format into the Program object.
   *
   * @param filePath - String
   * @return Program object
   */
  public static Program loadProgramByFilePath(String filePath) {
    GsonBuilder builder = new GsonBuilder();
    builder.registerTypeAdapter(Expression.class,
        new JsonSerializerWithInheritance<Expression>());
    Gson gson = builder.create();
    File modelFile = new File(filePath);
    try {
      return gson.fromJson(new FileReader(modelFile), Program.class);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      return null;
    }
  }
}
