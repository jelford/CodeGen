package elford.james.codegen;


/**
 * Classes that can have bits of code appended to
 * them to create compound statements. This means
 * we can write one statement after another in a java
 * program.
 * 
 * @author james
 *
 */
public interface JavaCodeBuilder {
	JavaCodeBlock append(JavaCodeBlock j);
	JavaCodeBlock append(String s);
}
