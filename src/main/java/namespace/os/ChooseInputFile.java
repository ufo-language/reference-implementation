package main.java.namespace.os;

import java.nio.file.Path;

import main.java.data.D_List;
import main.java.data.D_Nil;
import main.java.data.D_PrimFunction;
import main.java.data.D_String;
import main.java.data.Obj;
import main.java.evaluator.Evaluator;
import main.java.util.UFOException;

public class ChooseInputFile extends D_PrimFunction {

  // Static variables ===============================================

  private static final String _NAME = "chooseInputFile";
  private static final D_List[] _PARAMS = new D_List[] {
      D_PrimFunction.params("options", null)
  };

  // Static methods =================================================

  public static Path chooseInputFile(Obj[] options) {
    String osName = System.getProperty("os.name");
    if(osName.equals("Mac OS X")) {
      Path path = main.java.namespace.os.mac.ChooseInputFile.chooseInputFile(options);
      return path;
    }
    else
      throw UFOException.unsupportedOS(osName, "OS:" + _NAME);
  }

  // Constructors ===================================================

  public ChooseInputFile() {
    super(_NAME);
  }

  // Instance methods ===============================================

  @Override
  public void apply(Evaluator etor, D_List args) {
    Path path = chooseInputFile(args.asRawArray());
    Obj res = D_Nil.NIL;
    if(path != null)
      res = D_String.create(path.toString());
    etor.pushObj(res);
  }

  @Override
  public D_List[] getParameters() {
    return _PARAMS;
  }

}
