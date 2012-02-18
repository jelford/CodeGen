package elford.james.codegen.statements;

import elford.james.codegen.JavaCodeBlock;
import elford.james.codegen.RawJavaCodeBlock;

public class MethodInvocationCodeBlock extends RawJavaCodeBlock implements JavaCodeBlock {

	public MethodInvocationCodeBlock(StringBuilder methodInvocation) {
		this.from(methodInvocation);
	}

}
