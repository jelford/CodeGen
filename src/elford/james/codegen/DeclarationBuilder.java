package elford.james.codegen;

import elford.james.codegen.tinytypes.ClassName;
import elford.james.codegen.tinytypes.Identifier;

public class DeclarationBuilder {
	private Identifier identifier;

	public DeclarationBuilder(Identifier x) {
		this.identifier = x;
	}
	
	public JavaDeclaration as(ClassName type) {
		return new JavaDeclaration(identifier, type);
	}
}
