/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author macpro1
 */
/*
  This program parses Calc programs and prints the resulting AST.
  Calc programs should be entered on standard input.
  The resulting AST is printed on standard output.
*/
import AST.*;
import java.io.*;

class DumpCalcExpression {

  public static void main(String args[]) {
      
    /*  
    if(args.length != 1) {
      System.err.println("DumpCalcExpression: missing file command line argument");
      System.exit(1);
    }
    archivo = args[0];
    */
    
    String archivo = "fuente.src";
          
    try {
      CalcParser parser = new CalcParser(new FileReader(archivo));

      // Start parsing from the nonterminal "Start".
      Start ast = parser.Start();
    
      // Print the resulting AST on standard output.
  
      System.out.println(ast.jjtGetNumChildren());
      
      Node n = ast.jjtGetChild(0);
      
      System.out.println(n);
      
      System.out.println(n.jjtGetNumChildren());
      
    }
    catch (FileNotFoundException e) {
      System.err.println("DumpCalcExpression: file " + archivo + " not found");
    }
    catch (ParseException e) {
      System.out.println(e.getMessage());
    }
  }
  
}