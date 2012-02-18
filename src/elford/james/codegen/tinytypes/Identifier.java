package elford.james.codegen.tinytypes;

import elford.james.codegen.methodcall.MethodArgument;
import elford.james.codegen.methodcall.MethodInvocationBuilder;
import elford.james.codegen.statements.MethodInvocationCodeBlockBuilder;

public class Identifier implements MethodArgument {
	String token;

	public Identifier(String name) {
		this.token = name;
	}

	public MethodInvocationCodeBlockBuilder call(String methodName) {
		return new MethodInvocationCodeBlockBuilder(this, methodName);
	}

	@Override
	public String toString() {
		return this.token;
	}
	
	@Override
	public String asArgument(MethodInvocationBuilder builder) {
		return builder.representArgument(this);
	}
}
