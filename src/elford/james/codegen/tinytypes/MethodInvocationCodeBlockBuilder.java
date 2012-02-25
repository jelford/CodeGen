package elford.james.codegen.tinytypes;

import elford.james.codegen.EmptyMethodArgument;
import elford.james.codegen.UnterminatedJavacodeBlock;

public class MethodInvocationCodeBlockBuilder {

	private Identifier identifier;
	private String methodName;

	public MethodInvocationCodeBlockBuilder(Identifier identifier,
			String methodName) {
		this.identifier = identifier; this.methodName = methodName;
	}
	
	public MethodInvokation withArguments(UnterminatedJavacodeBlock ... args) {
		return new MethodInvokation(identifier, methodName, args);
	}
	
	public MethodInvokation withArguments(EmptyMethodArgument noArg) {
		return new MethodInvokation(identifier, methodName, null);
	}

}
