package elford.james.codegen.test;

import static elford.james.codegen.JavaLanguage.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static elford.james.codegen.test.Matchers.*;

import org.junit.Test;

import elford.james.codegen.TerminatingJavaCodeBlock;
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
				_return(x.call("hello").withArguments(y, y))				
		);
		
		assertThat(jcb.representTerminating(), is(like("{ Foo x; x = new Foo(); return x.hello(y, y); }")));
	}
}
