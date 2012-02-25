package elford.james.codegen;

import elford.james.codegen.tinytypes.ClassName;
import elford.james.codegen.tinytypes.Identifier;

public interface CatchFinallyBuilder extends TerminatingJavaCodeBlock {
	public CatchBuilder _catch(ClassName exceptionType, Identifier as);
	public TerminatingJavaCodeBlock _finally(TerminatingJavaCodeBlock jcb);
}
