package main.java.namespace.evaluator;

import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class CurrentContin extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "currentContin";
  private static final D_List[] _PARAMS = new D_List[] {
      D_List.EMPTY
  };

  // Constructors ===================================================

  public CurrentContin() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    D_List eStack = etor.getExprStack();
    etor.pushObj(eStack);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}
