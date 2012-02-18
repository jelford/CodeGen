package elford.james.codegen.test;

import static elford.james.codegen.JavaLanguage.*;

import org.junit.Test;

import elford.james.codegen.JavaCodeBlock;
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
		System.out.println(jcb.toString());
	}
}
