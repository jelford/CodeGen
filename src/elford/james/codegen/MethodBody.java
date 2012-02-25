package elford.james.codegen;

public class MethodBody implements TerminatingJavaCodeBlock {

	private CompositeJavaCodeBlock enclosed;

	public MethodBody(CompositeJavaCodeBlock compositeJavaCodeBlock) {
		this.enclosed = compositeJavaCodeBlock;
	}

	@Override
	public String representTerminating() {
		StringBuilder sb = new StringBuilder("{ ");
		sb.append(enclosed.representTerminating());
		sb.append(" }");
		return sb.toString();
	}

}
