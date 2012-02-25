package elford.james.codegen;

import elford.james.codegen.tinytypes.Identifier;

public class LocalAssignment implements TerminatingJavaCodeBlock {

	private Identifier identifier;
	private UnterminatedJavacodeBlock value;

	public LocalAssignment(Identifier x, UnterminatedJavacodeBlock value) {
		this.identifier = x; this.value = value;
	}
	
	@Override
	public String representTerminating() {
		StringBuilder sb = new StringBuilder(identifier.toString());
		sb.append(" = ");
		sb.append(value.representUnterminating());
		return sb.append(";").toString();
	}

}
