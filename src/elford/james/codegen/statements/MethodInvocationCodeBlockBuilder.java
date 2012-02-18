package elford.james.codegen.statements;

import elford.james.codegen.methodcall.EmptyMethodArgument;
import elford.james.codegen.methodcall.MethodArgument;
import elford.james.codegen.methodcall.MethodInvocationBuilder;
import elford.james.codegen.tinytypes.Identifier;

public class MethodInvocationCodeBlockBuilder implements MethodInvocationBuilder {

	private StringBuilder code;

	public MethodInvocationCodeBlockBuilder(Identifier identifier,
			String methodName) {
		this.code = new StringBuilder(identifier.toString()).append(".").append(methodName).append("(");
	}
	
	public MethodInvocationCodeBlock with(MethodArgument ... args) {
		int i = 0;
		for (MethodArgument arg : args) {
			if (this.addArgument(arg) && ++i < args.length)
				this.code.append(", ");
		}
		return new MethodInvocationCodeBlock(this.code.append(")"));
	}

	private boolean addArgument(MethodArgument arg) {
		if (arg == null) {
			this.code.append("null");
			return true;
		}
		
		String argument = arg.asArgument(this);
		if (argument != null)
			this.code.append(argument);
		
		return argument != null;
	}

	@Override
	public String representArgument(EmptyMethodArgument _) {
		return null;
	}

	@Override
	public String representArgument(Identifier identifier) {
		return identifier.toString();
	}


}
