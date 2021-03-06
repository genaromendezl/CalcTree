/*
  This program parses Calc programs and finds out if it is interactive, i.e.,
  if it contains any "ask user" expression.
  Calc programs should be entered as filename command line argument.
  The result ("Yes - the entered program is interactive" or
  "No - the entered program is not interactive") is printed on standard output.
  
  The program is implemented by relying on functionality added by a Visitor.
*/
import AST.*;
import java.io.*;

class ComputationByVisitor {

  public static void main(String args[]) {
    if(args.length != 1) {
      System.err.println("CalcInteractive2: missing file command line argument");
      System.exit(1);
    }
    try {
      CalcParser parser = new CalcParser(new FileReader(args[0]));
      
      // Start parsing from the nonterminal "Start".
      Start ast = parser.Start();
        
      // Check if the program is interactive.
      InteractiveComputationVisitor v = new InteractiveComputationVisitor();
      Boolean result = (Boolean) ast.jjtAccept(v, null);
      if (result.booleanValue()) {
        System.out.println("Yes - the entered program is interactive"); 
      }
      else {
        System.out.println("No - the entered program is not interactive");
      }
    }
    catch (FileNotFoundException e) {
      System.err.println("CalcInteractive2: file " + args[0] + " not found");
    }
    catch (ParseException e) {
      System.out.println(e.getMessage());
    }
  }
  
}