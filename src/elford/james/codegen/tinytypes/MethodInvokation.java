package elford.james.codegen.tinytypes;

import java.util.ArrayList;
import java.util.List;

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
		List<UnterminatedJavacodeBlock> strippedArgs = withoutNoArgEntries(args);
		int count = strippedArgs.size();
		StringBuilder sb = new StringBuilder(identifier.toString());
		sb.append(".");
		sb.append(methodName);
		sb.append("(");
		if (strippedArgs != null) {
			int i = 0;
			for (UnterminatedJavacodeBlock ujcb : strippedArgs) {				
				sb.append(ujcb.representUnterminating());
				if (++i < count)
					sb.append(", ");
			}
		}
		sb.append(")");
		return sb.toString();
	}
	
	private List<UnterminatedJavacodeBlock> withoutNoArgEntries(
			UnterminatedJavacodeBlock[] args) {
		List<UnterminatedJavacodeBlock> stripped = new ArrayList<UnterminatedJavacodeBlock>(args.length);
		for (int i=0; i<args.length; ++i) {
			if (args[i].getClass() != EmptyMethodArgument.class)
				stripped.add(args[i]);
		}
		return stripped;
	}

	@Override
	public String representTerminating() {
		return this.representUnterminating() + ";";
	}
	
	public TerminatingJavaCodeBlock terminate() {
		return this;
	}

}
