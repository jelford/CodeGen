package elford.james.codegen;

import elford.james.codegen.tinytypes.ClassName;

public class JavaTerminatingCastExpressionBuilder {
	private TerminatingJavaCodeBlock jcb;

	public JavaTerminatingCastExpressionBuilder(TerminatingJavaCodeBlock jcb) {
		this.jcb = jcb;
	}

	public TerminatingJavaCodeBlock as(final ClassName newType) {
		return  new TerminatingJavaCodeBlock() {
			
			@Override
			public String representTerminating() {
				StringBuilder sb = new StringBuilder();
				sb.append("(").append(newType).append(") ");
				sb.append(jcb.representTerminating());
				return sb.toString();
			}
		};
	}
}
