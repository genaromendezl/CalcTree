import AST.*;

class InteractiveComputationVisitor implements CalcParserVisitor {


  /*
    SimpleNode is an implementation class generated by JJTree.
    It serves as a superclass of all the AST classes.
    This method will never be called in our applications, but since
    this is an abstract method, we need to implement it nevertheless.
  */
  public Object visit(SimpleNode node, Object data) {
    return null;
  }
  
  /*
    List and Opt are generic nodes generated by JastAdd2.
    The describe lists and optionals in a generic way.
    This method will never be called in our applications, but since
    this is an abstract method, we need to implement it nevertheless.
  */
  public Object visit(List node, Object data) {
    return null;
  }
  public Object visit(Opt node, Object data) {
    return null;
  }
  
  
  public Object visit(Start node, Object data) {
    return node.getExp().jjtAccept(this, data);
  }
  
  public Object visit(MulExp node, Object data) {
    Boolean v1 = (Boolean) node.getLeftExp().jjtAccept(this, data);
    Boolean v2 = (Boolean) node.getRightExp().jjtAccept(this, data);
    return new Boolean(v1.booleanValue() || v2.booleanValue());
  }
  
  public Object visit(DivExp node, Object data) {
    Boolean v1 = (Boolean) node.getLeftExp().jjtAccept(this, data);
    Boolean v2 = (Boolean) node.getRightExp().jjtAccept(this, data);
    return new Boolean(v1.booleanValue() || v2.booleanValue());
  }
  
  public Object visit(LetExp node, Object data) {
    boolean soFar = false;
    Boolean v;
    for (int k=0; k< node.getNumBinding(); k++) {
      v = (Boolean) node.getBinding(k).jjtAccept(this, data);
      soFar = soFar || v.booleanValue();
    }
    Boolean v2 = (Boolean) node.getExp().jjtAccept(this, data);
    return new Boolean(soFar || v2.booleanValue());
  }
  
  public Object visit(Binding node, Object data) {
    return node.getExp().jjtAccept(this, data);
  }
  
  public Object visit(FPLitExp node, Object data) {
    return new Boolean(false);
  }
  
  public Object visit(IdExp node, Object data) {
    return new Boolean(false);
  }
  
  public Object visit(AskUserExp node, Object data) {
    return new Boolean(true);
  }

}