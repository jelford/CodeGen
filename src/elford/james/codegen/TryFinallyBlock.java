package elford.james.codegen;

public class TryFinallyBlock implements TerminatingJavaCodeBlock {

	private JavaTryBlock tryBlock;
	private TerminatingJavaCodeBlock body;

	public TryFinallyBlock(JavaTryBlock javaTryBlock,
			TerminatingJavaCodeBlock jcb) {
		this.tryBlock = javaTryBlock; this.body = jcb;
	}

	@Override
	public String representTerminating() {
		StringBuilder sb = new StringBuilder(this.tryBlock.representTerminating());
		sb.append(" finally { ");
		sb.append(this.body.representTerminating());
		sb.append(" } ");
		return sb.toString();
	}

}
