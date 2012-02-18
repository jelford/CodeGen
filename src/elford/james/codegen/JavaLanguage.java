package elford.james.codegen;

import elford.james.codegen.arrays.JavaArrayBuilder;
import elford.james.codegen.methodcall.EmptyMethodArgument;
import elford.james.codegen.methodcall.MethodArgument;
import elford.james.codegen.methodcall.MethodArgumentLookupBuilder;
import elford.james.codegen.scoped.TryBlockBuilder;
import elford.james.codegen.statements.JavaObjectInstantiation;
import elford.james.codegen.statements.JavaReturnStatement;
import elford.james.codegen.statements.LocalAssignBuilder;
import elford.james.codegen.tinytypes.ClassName;
import elford.james.codegen.tinytypes.Identifier;

/**
 * Provides convenience methods for most things you might
 * want to write. Method bodies, try blocks, ...
 * 
 * @author james
 *
 */
public class JavaLanguage {
	
	public static JavaCodeBlock methodBody(JavaCodeBlock ... expressions) {
		return new RawJavaCodeBlock(expressions).prependRaw("{").appendRaw("; }");
	}
	
	public static TryBlockBuilder _try(JavaCodeBlock jcb) {
		return new TryBlockBuilder(jcb);
	}
	
	public static TryBlockBuilder _try(JavaCodeBlock ... sequence) {
		JavaCodeBlock jcb = new RawJavaCodeBlock();
		for(JavaCodeBlock j : sequence) {
			if (jcb != null)
				jcb.append(j);
		}
		return _try(jcb);
	}
	
	public static JavaArrayBuilder array() {
		return new JavaArrayBuilder();
	}
	
	public static MethodArgumentLookupBuilder first(int howMany) {
		return new MethodArgumentLookupBuilder(howMany);
	}
	
	public static JavaCodeBlock[] valuesFrom(MethodArgument[] args) {
		
		JavaCodeBlock[] jcbArray = new JavaCodeBlock[args.length];
		for (int i = 0; i < args.length; i++) {
			jcbArray[i] = new RawJavaCodeBlock().from(args[i].toString());
		}
		return jcbArray;
	}
	
	public static JavaReturnStatement _return(ClassName type, JavaCodeBlock expression) {
		return new JavaReturnStatement(type, expression);
	}
	
	public static JavaReturnStatement _return(Object _) {
		return new JavaReturnStatement(null);
	}
	
	public static LocalAssignBuilder set(Identifier i) {
		return new LocalAssignBuilder(i);
	}
	
	public static JavaObjectInstantiation _new(String type, MethodArgument ... arguments) {
		return new JavaObjectInstantiation(type, arguments);
	}
	
	public static JavaCodeBlock _throw(JavaObjectInstantiation jcb) {
		return new RawJavaCodeBlock().from("throw " + jcb);
	}
	
	public static JavaCodeBlock doNothing() {
		return new RawJavaCodeBlock();
	}
	
	public static EmptyMethodArgument noArgument() {
		return new EmptyMethodArgument();
	}
	
	public final static String javaReflectedMethodType = 
								"java.lang.reflect.Method";
}