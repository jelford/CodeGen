package elford.james.codegen.statements;

import elford.james.codegen.JavaCodeBlock;
import elford.james.codegen.RawJavaCodeBlock;
import elford.james.codegen.tinytypes.ClassName;
import elford.james.codegen.tinytypes.Identifier;
import elford.james.codegen.tinytypes.TypedJavaCodeBlock;

public class LocalAssignBuilder extends RawJavaCodeBlock {

	StringBuilder identifier;
	public LocalAssignBuilder(Identifier i) {
		this.identifier = new StringBuilder().append(i);
	}
	
	public LocalAssignment to(TypedJavaCodeBlock value) {
		StringBuilder sb = new StringBuilder(value.getType())
			.append(" ")
			.append(this.identifier)
			.append(" = ")
			.append(value)
			.append("; ");
		
		return new LocalAssignment(sb);
	}
	
	public LocalAssignment to(ClassName type, JavaCodeBlock value) {
		return this.to(new TypedJavaCodeBlock(type, value));
	}
}
