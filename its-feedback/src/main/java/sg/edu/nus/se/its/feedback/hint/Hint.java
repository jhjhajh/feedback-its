package sg.edu.nus.se.its.feedback.hint;

import java.util.HashSet;
import java.util.List;
import sg.edu.nus.se.its.model.Program;
import sg.edu.nus.se.its.repair.LocalRepair;
import sg.edu.nus.se.its.repair.RepairCandidate;

/**
 * Abstract class for getting hints from repair candidates.
 */
public abstract class Hint {
  /**
   * Converts the repair candidates to a string.
   *
   * @param repairs repair candidates
   * @return string representation of repair candidate
   */
  public static List<LocalRepair> getLocalRepairsArray(RepairCandidate repairs) {
    List<LocalRepair> localRepairList = repairs.getLocalRepairs();
    return localRepairList;
  }

  public abstract String getIndividualHint(LocalRepair repair, Program originalProgram);

  /**
   * Process the repair candidate and get the required hint.
   *
   * @param repairs the repair candidate
   * @param originalProgram the student's submitted program
   * @return generated hint
   */
  public  String getHint(RepairCandidate repairs, Program originalProgram) {
    List<LocalRepair> localRepairList = getLocalRepairsArray(repairs);
    HashSet<String> includedFeedback = new HashSet<>();
    String compiledFeedback = "";
    for (LocalRepair repair : localRepairList) {
      String individualHint = getIndividualHint(repair, originalProgram) + "\n";
      if (!includedFeedback.contains(individualHint)) {
        includedFeedback.add(individualHint);
        compiledFeedback += getIndividualHint(repair, originalProgram) + "\n";
      }
    }
    if (localRepairList.size() == 0) {
      return "No repair required.";
    }
    return compiledFeedback;
  }
}
