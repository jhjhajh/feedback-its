package sg.edu.nus.se.its.feedback.hint;

import java.util.List;

import sg.edu.nus.se.its.model.Constant;
import sg.edu.nus.se.its.model.Expression;
import sg.edu.nus.se.its.model.Function;
import sg.edu.nus.se.its.model.Operation;
import sg.edu.nus.se.its.model.Program;
import sg.edu.nus.se.its.model.Variable;
import sg.edu.nus.se.its.repair.LocalRepair;

/**
 * Class for parsing hints.
 */
public abstract class HintParser {

  String prettyPrintOutputExpr(Operation expr) {
    List<Expression> args = expr.getArgs();
    StringBuilder prettyPrint = new StringBuilder();
    prettyPrint.append("Print ");
    prettyPrint.append(args.get(0));
    if (args.size() > 1) {
      prettyPrint.append(" with the value(s) of variable(s) ");
      for (int i = 1; i < args.size(); i++) {
        prettyPrint.append(prettyPrintExpr(args.get(i)));
        prettyPrint.append(", ");
      }
      prettyPrint.delete(prettyPrint.length() - 2, prettyPrint.length());
      prettyPrint.append(" replacing the placeholder(s)\n");
    } else {
      prettyPrint.append("\n");
    }
    return prettyPrint.toString();
  }

  String prettyPrintOutputExprAppend(Operation expr) {
    List<Expression> args = expr.getArgs();
    StringBuilder prettyPrint = new StringBuilder();
    for (Expression arg : args) {
      prettyPrint.append(prettyPrintExpr(arg));
    }
    return prettyPrint.toString();
  }

  String prettyPrintExpr(Expression expr) {
    if (expr instanceof Constant) {
      return ((Constant) expr).getValue();
    } else if (expr instanceof Variable) {
      String name = expr.toString();
      if (name.equals("$out")) {
        return "";
      }
      return Variable.isPrimedName(name) ? Variable.asUnprimedVariableName(name) : name;
    } else if (expr instanceof Operation) {
      if (((Operation) expr).getName().equals("ite")) {
        return prettyPrintIteExpr((Operation) expr).trim() + "\n";
      }
      if (((Operation) expr).getName().equals("StrAppend")) {
        return prettyPrintOutputExprAppend((Operation) expr);
      }
      if (((Operation) expr).getName().equals("StrFormat")) {
        return prettyPrintOutputExpr((Operation) expr);
      }
      List<Expression> args = ((Operation) expr).getArgs();
      StringBuilder prettyPrint = new StringBuilder();
      for (Expression arg : args) {
        prettyPrint.append(prettyPrintExpr(arg).trim());
        prettyPrint.append(" ").append(((Operation) expr).getName()).append(" ");
      }
      return prettyPrint.substring(0, prettyPrint.length() - 3) + "\n";
    }
    return " ";
  }

  abstract String getChangeStatement(Expression originalExpression,
                                     Expression correctExpression);

  private String prettyPrintIteExpr(Operation expr) {
    List<Expression> args = expr.getArgs();
    StringBuilder prettyPrint = new StringBuilder();
    prettyPrint.append("if(");
    int count = 0;
    for (Expression arg : args) {
      if (count == 0) {
        prettyPrint.append(prettyPrintExpr(arg).trim());
        prettyPrint.append(")\n");
        count++;
      } else if (count == 1) {
        prettyPrint.delete(prettyPrint.length() - 1, prettyPrint.length());
        prettyPrint.append("{\n");
        prettyPrint.append("    ").append(prettyPrintExpr(arg).trim());
        prettyPrint.append("\n}\n");
        count++;
      } else if (count == 2) {
        prettyPrint.delete(prettyPrint.length() - 1, prettyPrint.length());
        if (!prettyPrintExpr(arg).equals("")) {
          prettyPrint.append(" else {\n");
          prettyPrint.append("    ").append(prettyPrintExpr(arg).trim()).append("\n");
          prettyPrint.append("}\n");
        }
      }
    }
    return prettyPrint.toString();
  }

  protected String getDifferenceBetweenStringsIte(Operation originalExpression,
                                                  Operation correctExpression,
                                                  LocalRepair localRepair,
                                                  String append) {
    List<Expression> argsOriginal = originalExpression.getArgs();
    List<Expression> argsCorrected = correctExpression.getArgs();
    StringBuilder prettyPrint = new StringBuilder();
    int count = 0;
    for (int i = 0; i < argsOriginal.size(); i++) {
      if (!prettyPrintExpr(argsOriginal.get(i)).equals(prettyPrintExpr(argsCorrected
              .get(i)))) {
        if (count == 0) {
          prettyPrint.append(append)
                  .append("In the condition of the if then else statement:\n\n");
          count++;
        } else if (count == 1) {
          prettyPrint.append(append).append("Inside the if branch:\n\n");
          count++;
        } else if (count == 2) {
          prettyPrint.append(append).append("Inside the else branch:\n\n");
          count++;
        }
        prettyPrint.append(getDifferenceBetweenStrings(argsOriginal.get(i),
                argsCorrected.get(i),
                localRepair,
                append + "-->"));
        if (!append.equals("")) {
          prettyPrint.append("\n\n");
        } else {
          prettyPrint.append("----------\n\n");
        }
      }
    }
    return prettyPrint.toString();
  }

  protected String getDifferenceBetweenStrings(Expression originalExpression,
                                            Expression correctExpression,
                                            LocalRepair localRepair,
                                            String append) {
    if (originalExpression instanceof Constant) {
      return getConstantHint(originalExpression, correctExpression);
    } else if (originalExpression instanceof Variable) {
      return getVariableHint(originalExpression, correctExpression);
    } else if (originalExpression instanceof Operation) {
      return getOperationHint(originalExpression, correctExpression, localRepair, append);
    }
    return "";
  }

  private String getOperationHint(Expression originalExpression,
                                  Expression correctExpression,
                                  LocalRepair localRepair,
                                  String append) {
    if (correctExpression instanceof Operation) {
      return getOperationsDifference(originalExpression,
              correctExpression,
              localRepair,
              append);
    } else {
      return getChangeStatement(originalExpression, correctExpression);
    }
  }

  private String getOperationsDifference(Expression originalExpression,
                                         Expression correctExpression,
                                         LocalRepair localRepair,
                                         String append) {
    if (((Operation) originalExpression).getName().equals("ite")) {
      return getIteHint(originalExpression, correctExpression, localRepair, append);
    } else {
      return buildOperationsHint(originalExpression, correctExpression, localRepair);
    }
  }

  abstract String buildOperationsHint(Expression originalExpression,
                                      Expression correctExpression,
                                      LocalRepair localRepair);

  private String getIteHint(Expression originalExpression,
                            Expression correctExpression,
                            LocalRepair localRepair,
                            String append) {
    if (((Operation) correctExpression).getName().equals("ite")) {
      return getDifferenceBetweenStringsIte((Operation) originalExpression,
              (Operation) correctExpression,
              localRepair,
              append);
    } else {
      return getChangeStatement(originalExpression, correctExpression);
    }
  }

  private String getVariableHint(Expression originalExpression,
                                 Expression correctExpression) {
    if (correctExpression instanceof Variable) {
      return getVariableDifference(originalExpression, correctExpression);
    } else {
      return getChangeStatement(originalExpression, correctExpression);
    }
  }

  private String getConstantHint(Expression originalExpression,
                                 Expression correctExpression) {
    if (correctExpression instanceof Constant) {
      return getConstantDifference(originalExpression, correctExpression);
    } else {
      return getChangeStatement(originalExpression, correctExpression);
    }
  }

  abstract String getVariableDifference(Expression originalExpression,
                                        Expression correctExpression);

  abstract String getConstantDifference(Expression originalExpression,
                                        Expression correctExpression);


  private String getLocationDescriptionForRepairCandidate(LocalRepair localRepair,
                                                          Program originalProgram) {
    int originalProgramErrorLocation = localRepair.getErrorLocation().getValue0();
    String originalProgramFunctionName = localRepair.getFuncName();
    Function
            originalFunction =
            originalProgram.getFunctionForName(originalProgramFunctionName);
    return originalFunction.getLocationDesc(originalProgramErrorLocation);
  }

  /**
   * Extracts correct statement from local repair.
   *
   * @param localRepair string representation of a local repair
   */
  public String getHintWithErrorLocation(LocalRepair localRepair,
                                         Program originalProgram) {
    String
            originalProgramLocationDescription =
            getLocationDescriptionForRepairCandidate(localRepair, originalProgram);
    return "Location of error: "
            + originalProgramLocationDescription
            + "\n\nThe hints are as follows:\n\n"
            + getDifferenceBetweenStrings(getOriginalExpression(localRepair),
                    getCorrectExpression(localRepair),
                    localRepair,
                    "").trim();
  }

  Expression getCorrectExpression(LocalRepair localRepair) {
    return localRepair.getRepairedVariable().getValue2();
  }

  Expression getOriginalExpression(LocalRepair localRepair) {
    return localRepair.getRepairedVariable().getValue1();
  }
}
