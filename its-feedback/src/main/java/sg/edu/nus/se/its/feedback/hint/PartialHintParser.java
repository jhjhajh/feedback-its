package sg.edu.nus.se.its.feedback.hint;

import java.util.List;
import sg.edu.nus.se.its.model.Constant;
import sg.edu.nus.se.its.model.Expression;
import sg.edu.nus.se.its.model.Operation;
import sg.edu.nus.se.its.model.Variable;
import sg.edu.nus.se.its.repair.LocalRepair;

/**
 * Class for parsing hints.
 */
public class PartialHintParser extends HintParser {

  protected String getChangeStatement(Expression originalExpression,
                                      Expression correctExpression) {
    String originalPrinted = prettyPrintExpr(originalExpression);
    String correctPrinted = prettyPrintExpr(correctExpression);
    if (originalPrinted.equals("") && !correctPrinted.equals("")) {
      return "There's a missing statement here!" + "\n";
    } else if (!originalPrinted.equals("") && correctPrinted.equals("")) {
      return "Recheck whether the following is required: \n" + originalPrinted + "\n";
    }
    return "Recheck whether the following is correct: \n" + originalPrinted + "\n";

  }

  protected String buildOperationsHint(Expression originalExpression,
                                       Expression correctExpression,
                                       LocalRepair localRepair) {
    List<Expression> argsOriginal = ((Operation) originalExpression).getArgs();
    List<Expression> argsCorrected = ((Operation) correctExpression).getArgs();
    StringBuilder prettyPrint = new StringBuilder();
    if (argsOriginal.size() != argsCorrected.size()) {
      prettyPrint.append(getChangeStatement(originalExpression, correctExpression));
    } else {
      String originalOperation = ((Operation) originalExpression).getName();
      String correctOperation = ((Operation) correctExpression).getName();
      if (!originalOperation.equals(correctOperation)) {
        prettyPrint.append("Please recheck the operation\n");
        for (int i = 0; i < argsOriginal.size(); i++) {
          prettyPrint.append(getDifferenceBetweenStrings(argsOriginal.get(i),
                  argsCorrected.get(i),
                  localRepair,
                  ""));
        }
      } else {
        if (originalOperation.equals("StrAppend")) {
          prettyPrint.append("Please recheck the statement being printed\n");
        } else {
          if (!prettyPrintExpr(argsOriginal.get(0)).equals(prettyPrintExpr(argsCorrected.get(
                  0)))) {
            prettyPrint.append("Recheck left hand side of the \""
                    + originalOperation
                    + "\" operation\n");
          }
          if (!prettyPrintExpr(argsOriginal.get(1)).equals(prettyPrintExpr(argsCorrected.get(
                  1)))) {
            prettyPrint.append("Recheck right hand side of the \""
                    + originalOperation
                    + "\" operation"
                    + "\n");
          }
        }
      }
    }
    return prettyPrint.substring(0, prettyPrint.length());
  }


  protected String getVariableDifference(Expression originalExpression,
                                         Expression correctExpression) {
    String originalName = originalExpression.toString();
    originalName =
            Variable.isPrimedName(originalName)
                    ? Variable.asUnprimedVariableName(originalName) :
                    originalName;
    String correctName = correctExpression.toString();
    correctName =
            Variable.isPrimedName(correctName)
                    ? Variable.asUnprimedVariableName(correctName) :
                    correctName;
    if (!correctName.equals(originalName)) {
      return "Error with variable used. Please recheck the variable.";
    } else {
      return "";
    }
  }

  protected String getConstantDifference(Expression originalExpression,
                                         Expression correctExpression) {
    String originalExpressionConstant = ((Constant) originalExpression).getValue();
    String correctExpressionConstant = ((Constant) correctExpression).getValue();
    if (!originalExpressionConstant.equals(correctExpressionConstant)) {
      return "Error with value of constant. Please recheck the value";
    } else {
      return "";
    }
  }


}
