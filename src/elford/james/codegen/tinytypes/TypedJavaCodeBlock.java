package elford.james.codegen.tinytypes;

import elford.james.codegen.JavaCodeBlock;
import elford.james.codegen.RawJavaCodeBlock;

public class TypedJavaCodeBlock implements JavaCodeBlock {
	private ClassName type;
	private JavaCodeBlock wrappedJcb;
	
	public TypedJavaCodeBlock(ClassName type, JavaCodeBlock value) {
		this.wrappedJcb = value;
		this.type = type;
	}

	public String getType() {
		return this.type.toString();
	}
	
	@Override
	public String toString() {
		return this.wrappedJcb.toString();
	}

	@Override
	public TypedJavaCodeBlock append(JavaCodeBlock j) {
		this.wrappedJcb.append(j);
		return this;
	}

}
