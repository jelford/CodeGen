package elford.james.codegen;

public class JavaTryBlock implements TerminatingJavaCodeBlock{
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
	
	public TerminatingJavaCodeBlock _finally(TerminatingJavaCodeBlock jcb) {
		return new TryFinallyBlock(this, jcb);
	}

}
