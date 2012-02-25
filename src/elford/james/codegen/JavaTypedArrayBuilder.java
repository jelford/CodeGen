package elford.james.codegen;

import elford.james.codegen.tinytypes.ClassName;

public class JavaTypedArrayBuilder {

	private ClassName type;

	public JavaTypedArrayBuilder(ClassName type) {
		this.type = type;
	}
	
	public JavaArray containing(UnterminatedJavacodeBlock ... elements) {
		return new JavaArray(type, elements);
	}

}
