package elford.james.codegen;

import elford.james.codegen.tinytypes.ClassName;
import elford.james.codegen.tinytypes.Identifier;

public class JavaTryBlock implements TerminatingJavaCodeBlock, CatchFinallyBuilder {
	TerminatingJavaCodeBlock enclosedCode;

	public JavaTryBlock(TerminatingJavaCodeBlock jcb) {
		this.enclosedCode = jcb;
	}

	@Override
	public String representTerminating() {
		StringBuilder sb = new StringBuilder("try { ");
		sb.append(enclosedCode.representTerminating());
		sb.append(" } ");
		return sb.toString();
	}
	
	@Override
	public TerminatingJavaCodeBlock _finally(TerminatingJavaCodeBlock jcb) {
		return new TryFinallyBlock(this, jcb);
	}

	@Override
	public CatchBuilder _catch(ClassName from, Identifier x) {
		return new CatchBuilder(this, from, x);
	}

}
