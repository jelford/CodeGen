package elford.james.codegen.methodcall;


public class EmptyMethodArgument implements MethodArgument {


	@Override
	public String asArgument(MethodInvocationBuilder builder) {
		return builder.representArgument(this);
	}

}
