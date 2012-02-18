package elford.james.codegen.methodcall;

import elford.james.codegen.tinytypes.Identifier;

public interface MethodInvocationBuilder {
	String representArgument(EmptyMethodArgument ema);
	String representArgument(Identifier identifier);
}
