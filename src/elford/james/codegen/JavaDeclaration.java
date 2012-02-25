package elford.james.codegen;

import elford.james.codegen.tinytypes.ClassName;
import elford.james.codegen.tinytypes.Identifier;

public class JavaDeclaration implements TerminatingJavaCodeBlock {

	private Identifier identifier;
	private ClassName type;

	public JavaDeclaration(Identifier identifier, ClassName type) {
		this.identifier = identifier; this.type = type;
	}

	@Override
	public String representTerminating() {
		StringBuilder sb = new StringBuilder(type.toString());
		sb.append(" ");
		sb.append(identifier.toString());
		sb.append(";");
		return sb.toString();
	}

}
