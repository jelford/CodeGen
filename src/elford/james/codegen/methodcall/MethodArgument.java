package elford.james.codegen.methodcall;


public interface MethodArgument {
	public String asArgument(MethodInvocationBuilder builder);
	public String toString();
}
