package main.java.namespace.stack;

import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.D_Stack;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class Contains extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "contains?";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("s", D_Stack.class, "value", null)
  };

  // Constructors ===================================================

  public Contains() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    D_Stack s = (D_Stack)args.first();
    Obj other = args.getSecond();
    etor.pushObj(s.contains(other));
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}
