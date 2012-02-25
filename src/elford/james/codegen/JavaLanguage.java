package elford.james.codegen;

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
	
	public static TerminatingJavaCodeBlock methodBody(TerminatingJavaCodeBlock ... expressions) {
		return new MethodBody(new CompositeJavaCodeBlock(expressions));
	}
	
	public static JavaTryBlock _try(TerminatingJavaCodeBlock jcb) {
		return new JavaTryBlock(jcb);
	}
	
	public static DeclarationBuilder declare(Identifier x) {
		return new DeclarationBuilder(x);
	}
	
	public static JavaTryBlock _try(TerminatingJavaCodeBlock ... sequence) {
		TerminatingJavaCodeBlock jcb = new CompositeJavaCodeBlock(sequence);
		return _try(jcb);
	}
	
	public static UnterminatedJavacodeBlock stringLiteral(String value) {
		return new RawUnterminatedJavaCodeBlock("\""+value+"\"");
	}
	
	public static UnterminatedJavacodeBlock literal(Object value) {
		return new RawUnterminatedJavaCodeBlock(value.toString());
	}
	
	
	public static JavaArrayBuilder array() {
		return new JavaArrayBuilder();
	}
	
	//public static MethodArgumentLookupBuilder first(int howMany) {
	//	return new MethodArgumentLookupBuilder(howMany);
	//}
	
	//public static TerminatingJavaCodeBlock[] valuesFrom(MethodArgument[] args) {
	//	
	//	TerminatingJavaCodeBlock[] jcbArray = new TerminatingJavaCodeBlock[args.length];
	//	for (int i = 0; i < args.length; i++) {
	//		jcbArray[i] = new RawJavaCodeBlock().from(args[i].toString());
	//	}
	//	return jcbArray;
	//}
	
	//public static JavaReturnStatement _return(ClassName type, TerminatingJavaCodeBlock expression) {
	//	return new JavaReturnStatement(type, expression);
	//}
	public static JavaReturnStatement _return(TerminatingJavaCodeBlock expression) {
		return new JavaReturnStatement(expression);
	}
	
	public static JavaReturnStatement _return(Identifier identifier) {
		return new JavaReturnStatement(identifier);
	}
	
	//public static JavaReturnStatement _return(Object _) {
	//	return new JavaReturnStatement(null);
	//}
	
	public static LocalAssignBuilder set(Identifier i) {
		return new LocalAssignBuilder(i);
	}
	
	//public static JavaObjectInstantiation _new(String type, MethodArgument ... arguments) {
	//	return new JavaObjectInstantiation(type, arguments);
	//}
	
	//public static TerminatingJavaCodeBlock _throw(JavaObjectInstantiation jcb) {
	//	return new RawJavaCodeBlock().from("throw ").append(jcb).appendRaw(";");
	//}
	
	public static TerminatingJavaCodeBlock doNothing() {
		return new TerminatingJavaCodeBlock() {
			
			@Override
			public String representTerminating() {
				return "";
			}
		};
	}
	
	public static EmptyMethodArgument noArgument() {
		return new EmptyMethodArgument();
	}
	
	public final static String javaReflectedMethodType = 
								"java.lang.reflect.Method";
}
