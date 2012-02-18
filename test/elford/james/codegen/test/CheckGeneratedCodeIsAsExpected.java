package elford.james.codegen.test;

import static elford.james.codegen.JavaLanguage.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import elford.james.codegen.JavaCodeBlock;
import elford.james.codegen.RawJavaCodeBlock;
import elford.james.codegen.tinytypes.CClassName;
import elford.james.codegen.tinytypes.Identifier;

public class CheckGeneratedCodeIsAsExpected {

	@Test
	public void methodCallLooksHowWeThink() {
		Identifier x = new Identifier("x");
		Identifier sysOut = new Identifier("System.out");
		JavaCodeBlock jcb = methodBody(
				_try(
						set(x).to(CClassName.from("String"), stringLiteral("hello, world")),
						sysOut.call("println").with(x)
					)
				._finally(doNothing())
				
		);
		assertThat(jcb.toString(), is(equalTo("{ try { String x = \"hello, world\"; System.out.println(x); } finally { } }")));
		System.out.println(jcb.toString());
		
		Identifier y = new Identifier("y");
		Identifier z = new Identifier("z");
		JavaCodeBlock jcb2 = methodBody(
				set(x).to(CClassName.from("Integer"), new RawJavaCodeBlock().from("5")),
				set(y).to(CClassName.from("int"), new RawJavaCodeBlock().from("6")),
				set(z).to(CClassName.from("boolean"), x.call("equals").with(y))
		);
		assertThat(jcb2.toString(), is(equalTo("{ Integer x = 5; int y = 6; boolean z = x.equals(y);  }")));
		

		
		System.out.println(jcb2.toString());
	}
	
	
}
