package elford.james.codegen.statements;

import elford.james.codegen.JavaCodeBlock;
import elford.james.codegen.RawJavaCodeBlock;

public class LocalAssignment extends RawJavaCodeBlock implements JavaCodeBlock {

	public LocalAssignment(StringBuilder sb) {
		this.from(sb);
	}

}
