package sg.edu.nus.se.its.feedback.logic;

import static sg.edu.nus.se.its.feedback.utils.Constants.EXIT_MESSAGE;
import static sg.edu.nus.se.its.feedback.utils.Constants.OPTIONS_MESSAGE;
import static sg.edu.nus.se.its.feedback.utils.Constants.WELCOME_MESSAGE;
import static sg.edu.nus.se.its.feedback.utils.TestUtils.loadRepairCandidateFromFile;
import static sg.edu.nus.se.its.feedback.utils.TestUtils.loadProgramByFilePath;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import sg.edu.nus.se.its.feedback.hint.FullHint;
import sg.edu.nus.se.its.feedback.hint.LineNumberHint;
import sg.edu.nus.se.its.feedback.hint.PartialHint;
import sg.edu.nus.se.its.feedback.token.Token;
import sg.edu.nus.se.its.model.Program;
import sg.edu.nus.se.its.repair.LocalRepair;
import sg.edu.nus.se.its.repair.Repair;
import sg.edu.nus.se.its.repair.RepairCandidate;

/**
 * Class for handling user interaction (outputs).
 */
public class UiController {

  public static Token token = new Token(1000);

  public static Set<String> partialHintLineNumber = new HashSet<>();

  public static Set<String> fullHintLineNumber = new HashSet<>();

  public static void welcomeMessage() {
    System.out.println(WELCOME_MESSAGE);
  }

  private static final LineNumberHint lineNumberHint = new LineNumberHint();

  private static final PartialHint partialHint = new PartialHint();

  private static final FullHint fullHint = new FullHint();


  // TODO: remove later!
  private static RepairCandidate repairs;

  private static Program originalProgram;

  private static Set<String> lineNumberHintSet;

  public static Map<String, List<LocalRepair>> hintHashMap;


  public static void setRepairCandidates() {
    System.out.println("Please enter file path for repair candidate model:");
    Scanner scanner = new Scanner(System.in);
    String filePath = scanner.nextLine();
    repairs = loadRepairCandidateFromFile(filePath);
  }

  public static void setOriginalProgram() {
    System.out.println("Please enter file path for submitted program model:");
    Scanner scanner = new Scanner(System.in);
    String filePath = scanner.nextLine();
    originalProgram = loadProgramByFilePath(filePath);
    lineNumberHintSet = lineNumberHint.getHintSet(repairs, originalProgram);
    hintHashMap = lineNumberHint.getHintHashMap(repairs, originalProgram);
  }

  public static String getUserInput() {
    Scanner scanner = new Scanner(System.in);
    return scanner.nextLine();
  }

  public static void exitUi() {
    System.out.println(EXIT_MESSAGE);
    System.exit(0);
  }

  public static String getPartialHintAndDeductBalance() {
    System.out.println("Please enter line number:");
    String lineNumber = getUserInput();
    if (checkValidityLineNumber(lineNumber)) {
      if (!partialHintLineNumber.contains(lineNumber)) {
        partialHintLineNumber.add(lineNumber);
        token.deductForPartialHint();
      }
      return getPartialHint(lineNumber);
    }
    return "This line is correct.";
  }

  private static boolean checkValidityLineNumber(String lineNumber) {
    return lineNumberHintSet.contains(lineNumber);
  }

  private static String getExitReply() {
    return "exit";
  }

  private static String getLineNumberHint() {
    return lineNumberHint.getHint(repairs, originalProgram);
  }

  private static String getToken() {
    return "Your token balance is: " + token.getBalance();
  }

  private static String getResult(String userInput) {
    switch (userInput) {
    case "1":
      return getToken();
    case "2":
      return getLineNumberHint();
    case "3":
      return getPartialHintAndDeductBalance();
    case "4":
      return getFullHintAndDeductBalance();
    case "-1":
      return getExitReply();
    default:
      return "This option does not exist.";
    }
  }

  private static String getFullHintAndDeductBalance() {
    System.out.println("Please enter line number:");
    String lineNumber = getUserInput();
    if (checkValidityLineNumber(lineNumber)) {
      if (!fullHintLineNumber.contains(lineNumber)) {
        fullHintLineNumber.add(lineNumber);
        token.deductForFullHint();
      }
      return getFullHint(lineNumber);
    } else {
      return "This line is correct.";
    }
  }

  private static String getFullHint(String lineNumber) {
    String hints = "";
    Set<String> extractedHints = new HashSet<>();
    List<LocalRepair> repairsList = hintHashMap.get(lineNumber);
    for (int i = 0; i < repairsList.size(); i++) {
      String hint = fullHint.getIndividualHint(repairsList.get(i), originalProgram) + "\n";
      if (!extractedHints.contains(hint)) {
        hints += hint;
        extractedHints.add(hint);
      }
    }
    return hints;
  }

  private static String getPartialHint(String lineNumber) {
    String hints = "";
    Set<String> extractedHints = new HashSet<>();
    List<LocalRepair> repairsList = hintHashMap.get(lineNumber);
    for (int i = 0; i < repairsList.size(); i++) {
      String hint = partialHint.getIndividualHint(repairsList.get(i), originalProgram) + "\n";
      if (!extractedHints.contains(hint)) {
        hints += hint;
        extractedHints.add(hint);
      }
    }
    return hints;
  }

  public static void printResult(String result) {
    System.out.println(result);
  }

  public static String processUserInput() {
    String userInput = getUserInput();
    return getResult(userInput);
  }

  public static void displayOptions() {
    System.out.println(OPTIONS_MESSAGE);
  }

  public static boolean checkIfExit(String result) {
    return result.equals("exit");
  }
}
