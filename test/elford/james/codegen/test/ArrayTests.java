package elford.james.codegen.test;

import static elford.james.codegen.JavaLanguage.*;

import org.junit.Test;
import static elford.james.codegen.test.Matchers.like;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import elford.james.codegen.UnterminatedJavacodeBlock;
import elford.james.codegen.test.Matchers.StringLikeMatcher;
import elford.james.codegen.tinytypes.CClassName;
import elford.james.codegen.tinytypes.Identifier;

public class ArrayTests {

	@Test
	public void arraysCanBeDeclared() {
		Identifier x = new Identifier("x");
		Identifier y = new Identifier("y");
		UnterminatedJavacodeBlock array = array().ofType(CClassName.from("String")).containing(x, y, stringLiteral("z"));
		assertThat(array.representUnterminating(), is(like("new String[] { x, y, \"z\" }")));
		
		Identifier a = new Identifier("a");
		assertThat(methodBody(
				declare(a).as(CClassName.from("String[]")),
				set(a).to(array().ofType(CClassName.from("String")).containing(x, y, stringLiteral("z"))),
				_return(a)
		).representTerminating(), is(like("{ String[] a; a = new String[] { x, y, \"z\" }; return a; }")));
	}

}
