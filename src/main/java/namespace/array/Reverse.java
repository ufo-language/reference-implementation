package main.java.namespace.array;

import main.java.data.D_Array;
import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class Reverse extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "reverse!";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("a", D_Array.class)
  };

  // Constructors ===================================================

  public Reverse() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    D_Array ary = (D_Array)args.first();
    ary.reverse();
    etor.pushObj(ary);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}
