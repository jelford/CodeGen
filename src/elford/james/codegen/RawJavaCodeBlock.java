package elford.james.codegen;

import elford.james.codegen.scoped.JavaScopedBlock;


/**
 * Concrete implementation of a JavaCodeBlock. Provides
 * convenience methods for manipulating the underlying raw
 * code.
 * 
 * @author james
 *
 */
public class RawJavaCodeBlock implements JavaCodeBlock, JavaCodeBuilder, JavaScopedBlock {
	StringBuilder code;

	@Override
	public RawJavaCodeBlock append(JavaCodeBlock j) {
		this.code.append(j);
		return this;
	}

	public RawJavaCodeBlock() {
		this.code = new StringBuilder();
	}

	public RawJavaCodeBlock(JavaCodeBlock... expressions) {
		this.code = new StringBuilder();
		int i = 0;
		for (JavaCodeBlock jcb : expressions) {
			this.append(jcb);
			if (++i < expressions.length)
				this.code.append(jcb.terminate());
		}
	}

	@Override
	public String toString() {
		return this.code.toString();
	}

	public RawJavaCodeBlock from(String raw) {
		this.code = new StringBuilder(raw);
		return this;
	}

	public RawJavaCodeBlock from(StringBuilder sb) {
		this.code = sb;
		return this;
	}

	public RawJavaCodeBlock appendRaw(String string) {
		this.code.append(string);
		return this;
	}

	public RawJavaCodeBlock prependRaw(String string) {
		this.code = new StringBuilder(string).append(this.code);
		return this;
	}

	@Override
	public String terminate() {
		return "; ";
	}

	@Override
	public JavaCodeBlock append(String s) {
		return this.appendRaw(s);
	}
}
