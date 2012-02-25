package elford.james.codegen;

import elford.james.codegen.tinytypes.Identifier;

public class LocalAssignBuilder {
	private Identifier identifier;

	public LocalAssignBuilder(Identifier x) {
		this.identifier = x;
	}
	
	public TerminatingJavaCodeBlock to(UnterminatedJavacodeBlock value) {
		return new LocalAssignment(identifier, value);
	}
}
