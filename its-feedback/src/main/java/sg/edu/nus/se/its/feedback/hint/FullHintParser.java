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
public class FullHintParser extends HintParser {


  protected String getChangeStatement(Expression originalExpression,
                                      Expression correctExpression) {
    String originalPrinted = prettyPrintExpr(originalExpression);
    String correctPrinted = prettyPrintExpr(correctExpression);
    if (originalPrinted.equals("") && !correctPrinted.equals("")) {
      return "Add the following: \n"
              + correctPrinted
              + "\n";
    } else if (!originalPrinted.equals("") && correctPrinted.equals("")) {
      return "Delete the following: \n"
              + originalPrinted
              + "\n";
    }
    return "Change the following: \n"
            + originalPrinted
            + "\nto the following: \n"
            + correctPrinted
            + "\n";

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
        prettyPrint.append("Change operation " + originalOperation + " to "
                + correctOperation + "\n");
        for (int i = 0; i < argsOriginal.size(); i++) {
          prettyPrint.append(getDifferenceBetweenStrings(argsOriginal.get(i),
                  argsCorrected.get(i), localRepair, ""));
        }
      } else {
        if (originalOperation.equals("StrAppend")) {
          String originalMessage = prettyPrintExpr(argsOriginal.get(1)).trim();
          String originalExtracted = originalMessage.substring(6);
          prettyPrint.append(prettyPrintExpr(argsCorrected.get(1)).trim() + " instead of "
                  + originalExtracted + "\n");
        } else {
          if (!prettyPrintExpr(argsOriginal.get(0))
                  .equals(prettyPrintExpr(argsCorrected.get(0)))) {
            prettyPrint.append("Left hand side of the \""
                    + originalOperation
                    + "\" operation should be "
                    + prettyPrintExpr(argsCorrected.get(0)).trim()
                    + " instead of "
                    + prettyPrintExpr(argsOriginal.get(0)).trim()
                    + "\n");
          }
          if (!prettyPrintExpr(argsOriginal.get(1))
                  .equals(prettyPrintExpr(argsCorrected.get(1)))) {
            prettyPrint.append("Right hand side of the \""
                    + originalOperation + "\" operation should be "
                    + prettyPrintExpr(argsCorrected.get(1)).trim()
                    + " instead of "
                    + prettyPrintExpr(argsOriginal.get(1)).trim()
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
    originalName = Variable.isPrimedName(originalName)
            ? Variable.asUnprimedVariableName(originalName) : originalName;
    String correctName = correctExpression.toString();
    correctName = Variable.isPrimedName(correctName)
            ? Variable.asUnprimedVariableName(correctName) : correctName;
    if (!correctName.equals(originalName)) {
      return "Error with variable used. The variable " + originalName
              + " should be replaced with the variable " + correctName + " ";
    } else {
      return "";
    }
  }

  protected String getConstantDifference(Expression originalExpression,
                                         Expression correctExpression) {
    String originalExpressionConstant = ((Constant) originalExpression).getValue();
    String correctExpressionConstant = ((Constant) correctExpression).getValue();
    if (!originalExpressionConstant.equals(correctExpressionConstant)) {
      return "Error with value of constant. The constant " + originalExpressionConstant
              + " should have the value " + correctExpressionConstant;
    } else {
      return "";
    }
  }
}
