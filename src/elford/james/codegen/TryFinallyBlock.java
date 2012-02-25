package elford.james.codegen;

public class TryFinallyBlock implements TerminatingJavaCodeBlock {

	private CatchFinallyBuilder tryBlock;
	private TerminatingJavaCodeBlock body;

	public TryFinallyBlock(CatchFinallyBuilder javaTryBlock,
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
