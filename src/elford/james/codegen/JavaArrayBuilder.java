package elford.james.codegen;

import elford.james.codegen.tinytypes.ClassName;

public class JavaArrayBuilder {
	public JavaTypedArrayBuilder ofType(ClassName type) {
		return new JavaTypedArrayBuilder(type);
	}
}
