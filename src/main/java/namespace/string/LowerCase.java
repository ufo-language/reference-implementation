package main.java.namespace.string;

import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.D_String;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class LowerCase extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "lowerCase";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("s", D_String.class)
  };

  // Constructors ===================================================

  public LowerCase() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    D_String string = (D_String)args.first();
    etor.pushObj(D_String.create(string.getStr().toLowerCase()));
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}
