package elford.james.codegen.statements;

import elford.james.codegen.JavaCodeBlock;
import elford.james.codegen.RawJavaCodeBlock;
import elford.james.codegen.tinytypes.ClassName;

public class JavaReturnStatement extends RawJavaCodeBlock implements
		JavaCodeBlock {

	public JavaReturnStatement(ClassName type, JavaCodeBlock expression) {
		StringBuilder rStatement = new StringBuilder();
		rStatement.append("return ");

		rStatement.append("(");
		rStatement.append(type.toString());
		rStatement.append(") ");
		this.from(rStatement);
		this.append(expression);
	}
	
	public JavaReturnStatement(Object _) {
		this.from("return null");
	}

}
