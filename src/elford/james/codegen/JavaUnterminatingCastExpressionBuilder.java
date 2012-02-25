package elford.james.codegen;

import elford.james.codegen.tinytypes.ClassName;

public class JavaUnterminatingCastExpressionBuilder {

	private UnterminatedJavacodeBlock jcb;

	public JavaUnterminatingCastExpressionBuilder(UnterminatedJavacodeBlock jcb) {
		this.jcb = jcb;
	}

	
	public UnterminatedJavacodeBlock as(final ClassName newType) {
		return  new UnterminatedJavacodeBlock() {
			
			@Override
			public String representUnterminating() {
				StringBuilder sb = new StringBuilder();
				sb.append("(").append(newType).append(") ");
				sb.append(jcb.representUnterminating());
				return sb.toString();
			}
		};
	}
}
