package main.java.namespace.io;

import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.D_String;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;

public class DispString extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "dispString";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("...", null)
  };

  // Constructors ===================================================

  public DispString() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Obj[] argAry = args.asRawArray();
    String s = main.java.show.Show.displayString((Object[])argAry);
    D_String str = D_String.create(s);
    etor.pushObj(str);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}
