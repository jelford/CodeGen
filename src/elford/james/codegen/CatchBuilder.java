package elford.james.codegen;

import elford.james.codegen.tinytypes.ClassName;
import elford.james.codegen.tinytypes.Identifier;

public class CatchBuilder {
	ClassName exceptionType;
	Identifier alias;
	private CatchFinallyBuilder tryBlock;

	public CatchBuilder(CatchFinallyBuilder tryBlock, ClassName from, Identifier x) {
		exceptionType = from; alias = x;
		this.tryBlock = tryBlock;
	}

	public CatchFinallyBuilder then(final TerminatingJavaCodeBlock jcb) {
		return new CatchFinallyBuilder() {

			@Override
			public String representTerminating() {
				StringBuilder sb = new StringBuilder(tryBlock.representTerminating());
				sb.append(" catch (");
				sb.append(exceptionType.toString());
				sb.append(" ");
				sb.append(alias);
				sb.append(") { ");
				sb.append(jcb.representTerminating());
				sb.append(" } ");
				return sb.toString();
			}

			@Override
			public CatchBuilder _catch(ClassName exceptionType, Identifier as) {
				return new CatchBuilder(this, exceptionType, as);
			}

			@Override
			public TerminatingJavaCodeBlock _finally(
					TerminatingJavaCodeBlock jcb) {
				return new TryFinallyBlock(this, jcb);
			}
			
		};
	}
}
