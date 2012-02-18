package elford.james.codegen.scoped;

import elford.james.codegen.JavaCodeBlock;
import elford.james.codegen.RawJavaCodeBlock;
import elford.james.codegen.tinytypes.ClassName;
import elford.james.codegen.tinytypes.Identifier;

public class TryBlockBuilder implements CatchBlock {
	JavaScopedBlock codeBlock;
	
	public TryBlockBuilder(JavaCodeBlock jcb) {
		this.codeBlock = new RawJavaCodeBlock().from("try { ").append(jcb).appendRaw(jcb.terminate()).appendRaw("}");
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
	public JavaScopedBlock _finally(final JavaCodeBlock jcb) {
		return new JavaScopedBlock() {
			StringBuilder code = new StringBuilder(codeBlock.toString()).append(" finally { ").append(jcb).append("}");

			@Override
			public String terminate() {
				return "";
			}

			@Override
			public JavaCodeBlock append(JavaCodeBlock j) {
				code.append(j);
				return this;
			}
			
			@Override
			public String toString() {
				return code.toString();
			}

			@Override
			public JavaCodeBlock append(String s) {
				code.append(s);
				return this;
			}
			
		};
	}

	@Override
	public String terminate() {
		System.out.println("Terminating a try-block");
		return "";
	}

	@Override
	public TryBlockBuilder append(String s) {
		codeBlock.append(s);
		return this;
	}
}
