package elford.james.codegen.statements;

import elford.james.codegen.RawJavaCodeBlock;
import elford.james.codegen.methodcall.EmptyMethodArgument;
import elford.james.codegen.methodcall.MethodArgument;
import elford.james.codegen.methodcall.MethodInvocationBuilder;
import elford.james.codegen.tinytypes.Identifier;

public class JavaObjectInstantiation extends RawJavaCodeBlock implements MethodInvocationBuilder {
	public JavaObjectInstantiation(String type, MethodArgument[] arguments) {
		StringBuilder sb = new StringBuilder("new ").append(type);
		sb.append("(");
		int i=0;
		for (MethodArgument arg : arguments) {
			sb.append(arg.asArgument(this));
			if (++i < arguments.length) 
				sb.append(", ");
		}
		sb.append(")");
		this.from(sb);
	}

	@Override
	public String representArgument(Identifier identifier) {
		return identifier.toString();
	}

	@Override
	public String representArgument(EmptyMethodArgument _) {
		return null;
	}
}
