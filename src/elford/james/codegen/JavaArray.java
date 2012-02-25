package elford.james.codegen;

import elford.james.codegen.tinytypes.ClassName;

public class JavaArray implements UnterminatedJavacodeBlock {

	private UnterminatedJavacodeBlock[] elements;
	private ClassName type;
	
	

	public JavaArray(ClassName type, UnterminatedJavacodeBlock[] elements) {
		this.type = type;
		this.elements = elements;
	}



	@Override
	public String representUnterminating() {
		StringBuilder sb = new StringBuilder();
		sb.append("new ").append(this.type.toString()).append("[] { ");
		int i = 0;
		for (UnterminatedJavacodeBlock element : this.elements) {
			sb.append(element.representUnterminating());
			if (++i < this.elements.length)
				sb.append(", ");
		}
		sb.append(" }");
		return sb.toString();
	}

}
