package elford.james.codegen.tinytypes;

import elford.james.codegen.UnterminatedJavacodeBlock;


public class Identifier implements UnterminatedJavacodeBlock {
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
	public String representUnterminating() {
		return this.toString();
	}
	
}
