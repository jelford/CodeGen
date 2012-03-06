package elford.james.codegen.test;

import static elford.james.codegen.JavaLanguage.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static elford.james.codegen.test.Matchers.*;

import org.junit.Test;

import elford.james.codegen.TerminatingJavaCodeBlock;
import elford.james.codegen.UnterminatedJavacodeBlock;
import elford.james.codegen.tinytypes.CClassName;
import elford.james.codegen.tinytypes.Identifier;

public class MethodBodyTests {

	@Test
	public void methodBodyWellFormed() {
		Identifier x = new Identifier("x");
		Identifier y = new Identifier("y");
		Identifier z = new Identifier("z");
		TerminatingJavaCodeBlock jcb2 = methodBody(
				declare(x).as(CClassName.from("Integer")),
				set(x).to(literal(5)),
				declare(y).as(CClassName.from("int")),
				set(y).to(literal(6)),
				declare(z).as(CClassName.from("boolean")),
				set(z).to(x.call("equals").withArguments(y))
		);
		assertThat(jcb2.representTerminating(), is(like("{ Integer x; x = 5; int y; y = 6; boolean z; z = x.equals(y);  }")));
	}
	
	@Test
	public void returnStatement() {
		Identifier x = new Identifier("x");
		Identifier y = new Identifier("y");
		
		TerminatingJavaCodeBlock jcb = methodBody(
				declare(x).as(CClassName.from("Foo")),
				set(x).to(literal("new Foo()")),
				_return(x.call("hello").withArguments(y, y).terminate())				
		);
		
		assertThat(jcb.representTerminating(), is(like("{ Foo x; x = new Foo(); return x.hello(y, y); }")));
	}
	
	@Test
	public void testCastStatements() {
		Identifier x = new Identifier("x");
		TerminatingJavaCodeBlock jcb = _return(cast(x).as(CClassName.from("String")));
		assertThat(jcb.representTerminating(), is(like("return (String) x;")));
	}
	
	@Test
	public void testCastStatementUnterminating() {
		Identifier x = new Identifier("x");
		TerminatingJavaCodeBlock jcb = x.call("method").withArguments(cast(x).as(CClassName.from("Object")));
		assertThat(jcb.representTerminating(), is(like("x.method((Object) x);")));
	}
	
	@Test
	public void testCastStatementWithTerminatingMethod() {
		Identifier x = new Identifier("x");
		TerminatingJavaCodeBlock jcb = cast(x.call("method").withArguments(cast(x).as(CClassName.from("Object"))).terminate())
											.as(CClassName.from("String"));
		assertThat(jcb.representTerminating(), is(like("(String) x.method((Object) x);")));
	}
	
	@Test
	public void testCanGetMethodArguments() {
		UnterminatedJavacodeBlock ujcb = array().ofType(CClassName.from("Object")).containing(methodArguments(1,2,3));
		assertThat(ujcb.representUnterminating(), is(like("new Object[] { #1, #2, #3 }")));
	}
	
	@Test
	public void testCanUseConvenienceMethodArgumentsHelper() {
		UnterminatedJavacodeBlock ujcb = array().ofType(CClassName.from("Object")).containing(_this(), methodArguments(from(2).to(5)));
		assertThat(ujcb.representUnterminating(), is(like("new Object[] { #0, #2, #3, #4 }")));
	}
	
	@Test
	public void testCanReturnNull() {
		TerminatingJavaCodeBlock jcb = _return(literal(null));
		assertThat(jcb.representTerminating(), is(like("return null;")));
	}
}
