package main.java.namespace.term;

import main.java.data.D_List;
import main.java.data.D_PrimFunction;
import main.java.data.D_Term;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.namespace.Params;

public class SetAttrib extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "setAttrib!";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("t", D_Term.class, "a", null)
  };

  // Constructors ===================================================

  public SetAttrib() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Params.check(_NAME, _PARAMS, args);
    D_Term trm = (D_Term)args.first();
    Obj attr = args.getSecond();
    trm.attrib(attr);
    etor.pushObj(trm);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}
