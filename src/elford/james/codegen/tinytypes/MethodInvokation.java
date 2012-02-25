package elford.james.codegen.tinytypes;

import elford.james.codegen.EmptyMethodArgument;
import elford.james.codegen.TerminatingJavaCodeBlock;
import elford.james.codegen.UnterminatedJavacodeBlock;

public class MethodInvokation implements TerminatingJavaCodeBlock,
		UnterminatedJavacodeBlock {

	private Identifier identifier;
	private String methodName;
	private UnterminatedJavacodeBlock[] args;

	public MethodInvokation(Identifier identifier, String methodName,
			UnterminatedJavacodeBlock[] args) {
		this.identifier = identifier;
		this.methodName = methodName;
		this.args = args;
	}

	@Override
	public String representUnterminating() {
		StringBuilder sb = new StringBuilder(identifier.toString());
		sb.append(".");
		sb.append(methodName);
		sb.append("(");
		if (args != null) {
			int i = 0;
			for (UnterminatedJavacodeBlock ujcb : args) {
				sb.append(ujcb.representUnterminating());
				if (++i < args.length)
					sb.append(", ");
			}
		}
		sb.append(")");
		return sb.toString();
	}

	@Override
	public String representTerminating() {
		return this.representUnterminating() + ";";
	}

}
