/* Generated By:JJTree: Do not edit this line. FPLitExp.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package AST;

public
class FPLitExp extends SimpleNode {
  float  valor;
  String tipo = "flotante";
  public FPLitExp(int id) {
    super(id);
  }

  public FPLitExp(CalcParser p, int id) {
    super(p, id);
  }
  
  public void setFPLIT(String image){
      valor = Float.parseFloat(image);
      
  }
  
  @Override
  public void dump(String prefix){
      System.out.println("tipo: "+this.tipo+" valor: "+this.valor);
      super.dump(prefix);
  }

}
/* JavaCC - OriginalChecksum=e66b507abd1008a795022dc6caec3564 (do not edit this line) */
