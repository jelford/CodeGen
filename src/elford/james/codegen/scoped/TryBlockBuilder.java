package elford.james.codegen.scoped;

import elford.james.codegen.JavaCodeBlock;
import elford.james.codegen.RawJavaCodeBlock;
import elford.james.codegen.tinytypes.ClassName;
import elford.james.codegen.tinytypes.Identifier;

public class TryBlockBuilder {
	JavaCodeBlock codeBlock;
	
	public TryBlockBuilder(JavaCodeBlock jcb) {
		this.codeBlock = new RawJavaCodeBlock().from("try {").append(jcb).appendRaw("; }");
	}

	public CatchBlockBuilder _catch(ClassName exceptionType, Identifier label) {
		return new CatchBlockBuilder(this, exceptionType, label);
	}

}
