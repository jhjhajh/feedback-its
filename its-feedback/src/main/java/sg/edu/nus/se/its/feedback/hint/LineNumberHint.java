package sg.edu.nus.se.its.feedback.hint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import sg.edu.nus.se.its.model.*;
import sg.edu.nus.se.its.repair.LocalRepair;
import sg.edu.nus.se.its.repair.RepairCandidate;

public class LineNumberHint extends Hint {
  List<LocalRepair> localRepairs;

  public LineNumberHint() {
  }

  /**
   * Return line number given repair candidate.
   *
   * @param repair local repair
   */
  private String getLineNumber(LocalRepair repair) {
    return "" + repair.getRepairedVariable().getValue1().getLineNumber();
  }

  public String getHintSetLineNumberRange(LocalRepair repair, Program originalProgram) {
    try {
      String errorLoc;
      if (repair.getRepairedVariable().getValue1().getLineNumber() == 0) {
        ArrayList<Integer> lines = getLineNum(repair);
        int max = findMax(lines);
        int min = findMin(lines);
        if (max == min) {
          errorLoc = "" + max;
        } else {
          errorLoc = "between lines " + min + " and " + max;
        }
      } else {
        errorLoc = getLineNumber(repair);
      }
      return errorLoc;
    } catch (NullPointerException e) {
      return "";
    }
  }

  public Map<String, List<LocalRepair>> getHintHashMap(RepairCandidate repairs,
                                                       Program originalProgram) {
    this.localRepairs = repairs.getLocalRepairs();
    Map<String, List<LocalRepair>> hintHashMap = new HashMap<>();
    for(LocalRepair repair: localRepairs) {
      String lineNumber = getHintSetLineNumberRange(repair, originalProgram);
      List<LocalRepair> list;
      if(hintHashMap.containsKey(lineNumber)) {
        list = hintHashMap.get(lineNumber);
      } else {
        list = new ArrayList<>();
      }
      list.add(repair);
      hintHashMap.put(lineNumber, list);
    }
    return hintHashMap;
  }

  public Set<String> getHintSet(RepairCandidate repairs, Program originalProgram) {
    this.localRepairs = repairs.getLocalRepairs();
    Set<String> lineNumbers = new HashSet<>();
    for(LocalRepair repair: localRepairs) {
      lineNumbers.add(getHintSetLineNumberRange(repair, originalProgram));
    }
    return lineNumbers;
  }

  private static int findMax(ArrayList<Integer> lines) {
    int maximum = lines.get(0);
    for (int i = 1; i < lines.size(); i++) {
      if (maximum < lines.get(i))
        maximum = lines.get(i);
    }
    return maximum;
  }

  private static int findMin(ArrayList<Integer> lines) {
    int minimum = lines.get(0);
    for (int i = 1; i < lines.size(); i++) {
      if (minimum > lines.get(i) & lines.get(i) != 0)
        minimum = lines.get(i);
    }
    return minimum;
  }

  private static ArrayList<String> removeDuplicates(ArrayList<String> feedbacks)
  {
    ArrayList<String> newFeedbacks = new ArrayList<>();
    for (String feedback : feedbacks) {
      if (!newFeedbacks.contains(feedback)) {
        newFeedbacks.add(feedback);
      }
    }
    return newFeedbacks;
  }

  /**
   * Get a numerical list of line numbers for an individual local repair.
   *
   * @param repair local repair
   */
  private ArrayList<Integer> getLineNum(LocalRepair repair) {
    Expression expr = repair.getRepairedVariable().getValue1();
    ArrayList<Integer> lines = new ArrayList<>();
    if (expr instanceof Operation) {
      List<Expression> args;
      if (((Operation) expr).getName().equals("ite") || ((Operation) expr).getName().equals("StrAppend") || ((Operation) expr).getName().equals("StrFormat")) {
        args = ((Operation) expr).getArgs();
        for (Expression arg : args) {
          lines.add(arg.getLineNumber());
        }
      }
    } else {
      lines.add(repair.getRepairedVariable().getValue1().getLineNumber());
    }
    return lines;
  }

  /**
   * Get line number hints for an individual local repair.
   *
   * @param repair local repair
   */
  public String getIndividualHint(LocalRepair repair, Program originalProgram) {
    try {
      String errorLoc;
      if (repair.getRepairedVariable().getValue1().getLineNumber() == 0) {
        ArrayList<Integer> lines = getLineNum(repair);
        int max = findMax(lines);
        int min = findMin(lines);
        if (max == min) {
          errorLoc = "Error found in line " + max + ". ";
        } else {
          errorLoc = "Error found between lines " + min + " and " + max + ". ";
        }
      } else {
        errorLoc = "Error found in line " + getLineNumber(repair) + ". ";
      }
      String hintMsg = errorLoc + "Difficulty of repair: " + getDifficulty(repair.getCost()) + ".";
      return hintMsg;
    } catch (NullPointerException e) {
      return "";
    }
  }

  /**
   * Prints out a list of non-duplicated line number hints.
   *
   * @param repairs repair candidates
   */
  public String getHint(RepairCandidate repairs, Program originalProgram) {
    this.localRepairs = repairs.getLocalRepairs();
    ArrayList<String> feedbackList = new ArrayList<>();

    String compiledFeedback = "";
    if(localRepairs.size() == 0) {
      compiledFeedback += "No repairs required.\n";
    }
    for (LocalRepair repair : localRepairs) {
      String currentFeedback = getIndividualHint(repair, originalProgram);
      if (currentFeedback != "") {
        feedbackList.add(currentFeedback);
      }
    }
    ArrayList<String> noDuplicates = removeDuplicates(feedbackList);
    for (String feedback: noDuplicates) {
      compiledFeedback += feedback + "\n";
    }
    return compiledFeedback;
  }

  /**
   * Returns level of difficulty based on cost.
   *
   * @param cost cost
   */
  private String getDifficulty(Float cost) {
    if (cost <= 10.00) {
      return "Easy";
    } else if (cost <= 50.00) {
      return "Medium";
    }
    return "Hard";
  }
}
