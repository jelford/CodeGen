package elford.james.codegen;

import elford.james.codegen.Range.RangeBuilder;
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
		return new RawUnterminatedJavaCodeBlock((value != null) ? value.toString() : "null");
	}
	
	
	public static JavaArrayBuilder array() {
		return new JavaArrayBuilder();
	}
	
	public static JavaReturnStatement _return(TerminatingJavaCodeBlock expression) {
		return new JavaReturnStatement(expression);
	}
	
	public static JavaReturnStatement _return(UnterminatedJavacodeBlock ujcb) {
		return new JavaReturnStatement(ujcb);
	}
	
	public static LocalAssignBuilder set(Identifier i) {
		return new LocalAssignBuilder(i);
	}
	
	public static TerminatingJavaCodeBlock _throw(final ClassName exceptionType, final UnterminatedJavacodeBlock ... args) {
		return new TerminatingJavaCodeBlock() {
			
			@Override
			public String representTerminating() {
				StringBuilder sb = new StringBuilder("throw ");
				sb.append("new ");
				sb.append(exceptionType.toString());
				sb.append("(");
				
				int i = 0;
				for (UnterminatedJavacodeBlock tjcb : args) {
					sb.append(tjcb.representUnterminating());
					if (++i < args.length)
						sb.append(", ");
				}
				
				sb.append(");");
				return sb.toString();
			}
		};
	}
	
	public static TerminatingJavaCodeBlock _throw(final Identifier x) {
		return new TerminatingJavaCodeBlock() {
			
			@Override
			public String representTerminating() {
				return "throw " + x.toString() + "; ";
			}
		};
	}
	
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
	
	public static UnterminatedJavacodeBlock methodArguments(int ... arguments) {
		StringBuilder sb = new StringBuilder();
		int i=0;
		while (i<arguments.length) {
			sb.append("$");
			sb.append(Integer.toString(arguments[i]));
			if (++i < arguments.length)
				sb.append(", ");
		}
		
		final String argsList = sb.toString();
		return new UnterminatedJavacodeBlock() {
			
			@Override
			public String representUnterminating() {
				return argsList;
			}
		};
	}
	
	public static UnterminatedJavacodeBlock methodArguments(Range range) {
		int size = range.to - range.from;
		int[] args = new int[size];
		for (int i=0; i < size; ++i) {
			args[i] = i+range.from;
		}
		return methodArguments(args);
	}
	
	public static UnterminatedJavacodeBlock _this() {
		return new UnterminatedJavacodeBlock() {
			
			@Override
			public String representUnterminating() {
				return "$0";
			}
		};
	}
	
	public static RangeBuilder from(int from) {
		return Range.from(from);
	}
	
	public static JavaTerminatingCastExpressionBuilder cast(TerminatingJavaCodeBlock jcb) {
		return new JavaTerminatingCastExpressionBuilder(jcb);
	}
	
	public static JavaUnterminatingCastExpressionBuilder cast(UnterminatedJavacodeBlock ujcb) {
		return new JavaUnterminatingCastExpressionBuilder(ujcb);
	}
	
	public final static String javaReflectedMethodType = 
								"java.lang.reflect.Method";
}
