package sg.edu.nus.se.its.feedback.ui;

import static sg.edu.nus.se.its.feedback.utils.Constants.EXIT_MESSAGE;
import static sg.edu.nus.se.its.feedback.utils.Constants.OPTIONS_MESSAGE;
import static sg.edu.nus.se.its.feedback.utils.Constants.WELCOME_MESSAGE;
import static sg.edu.nus.se.its.feedback.utils.TestUtils.loadProgramByFilePath;
import static sg.edu.nus.se.its.feedback.utils.TestUtils.loadRepairCandidateFromFile;
import sg.edu.nus.se.its.feedback.logic.UiController;

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
import sg.edu.nus.se.its.repair.RepairCandidate;


/**
 * Class for handling user interaction (outputs).
 */
public class Ui {

  public static void main(String[] args) {
    UiController.welcomeMessage();
    UiController.setRepairCandidates();
    UiController.setOriginalProgram();
    String result = "";
    while (!UiController.checkIfExit(result)) {
      UiController.displayOptions();
      result = UiController.processUserInput();
      UiController.printResult(result);
    }
    UiController.exitUi();
  }
}
