package elford.james.codegen.scoped;

import elford.james.codegen.JavaCodeBlock;
import elford.james.codegen.RawJavaCodeBlock;
import elford.james.codegen.tinytypes.ClassName;
import elford.james.codegen.tinytypes.Identifier;

public class TryBlockBuilder implements CatchBlock {
	JavaScopedBlock codeBlock;
	
	public TryBlockBuilder(JavaCodeBlock jcb) {
		this.codeBlock = new RawJavaCodeBlock().from("try {").append(jcb).appendRaw("; }");
	}

	public CatchBlockBuilder _catch(ClassName exceptionType, Identifier label) {
		return new CatchBlockBuilder(this, exceptionType, label);
	}

	@Override
	public JavaCodeBlock append(JavaCodeBlock j) {
		codeBlock.append(j);
		return this;
	}

	@Override
	public JavaScopedBlock _finally(JavaCodeBlock jcb) {
		this.codeBlock.append(new RawJavaCodeBlock().from(" finally { ").append(jcb).appendRaw(" }"));
		return this.codeBlock;
	}
}
