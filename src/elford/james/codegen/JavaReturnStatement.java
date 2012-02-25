package elford.james.codegen;

import elford.james.codegen.tinytypes.Identifier;

public class JavaReturnStatement implements TerminatingJavaCodeBlock {

	private TerminatingJavaCodeBlock expression;

	public JavaReturnStatement(TerminatingJavaCodeBlock expression) {
		this.expression = expression;
	}

	/* Allow a special case for identifiers, which can be trivially terminated */
	public JavaReturnStatement(final UnterminatedJavacodeBlock ujcb) {
		this.expression = new TerminatingJavaCodeBlock() {
			
			@Override
			public String representTerminating() {
				return ujcb.representUnterminating() + ";";
			}
		};
	}

	@Override
	public String representTerminating() {
		return "return " + expression.representTerminating();
	}

}
