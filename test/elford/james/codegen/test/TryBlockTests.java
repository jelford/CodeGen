package elford.james.codegen.test;

import static elford.james.codegen.JavaLanguage.*;
import static elford.james.codegen.JavaLanguage.declare;
import static elford.james.codegen.JavaLanguage.doNothing;
import static elford.james.codegen.JavaLanguage.literal;
import static elford.james.codegen.JavaLanguage.methodBody;
import static elford.james.codegen.JavaLanguage.noArgument;
import static elford.james.codegen.JavaLanguage.set;
import static elford.james.codegen.JavaLanguage.stringLiteral;
import static elford.james.codegen.test.Matchers.like;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import elford.james.codegen.TerminatingJavaCodeBlock;
import elford.james.codegen.tinytypes.CClassName;
import elford.james.codegen.tinytypes.Identifier;

public class TryBlockTests {
	@Test
	public void tryFinallyBlock() {
		Identifier x = new Identifier("x");
		Identifier sysOut = new Identifier("System.out");
		TerminatingJavaCodeBlock jcb = methodBody(
				_try(
						declare(x).as(CClassName.from("String")),
						set(x).to(stringLiteral("hello, world")),
						sysOut.call("println").withArguments(x)
					)
				._finally(doNothing())
				
		);
		assertThat(jcb.representTerminating(), is(like("{ try { String x; x = \"hello, world\"; System.out.println(x); } finally {  } }")));
	}
	
	@Test
	public void tryEmptyFinally() {
		Identifier x = new Identifier("x");
		TerminatingJavaCodeBlock jcb = _try(
									x.call("method").withArguments(noArgument())
								)._finally(doNothing());
		
		assertThat(jcb.representTerminating(), is(like("try { x.method(); } finally { }")));
	}
	
	@Test
	public void canCorrectlyWriteATryBlockWithoutFinally() {
		Identifier x = new Identifier("x");
		
		TerminatingJavaCodeBlock jcb1 = _try(doNothing());
		assertThat(jcb1.representTerminating(), is(like("try { }")));
		
		TerminatingJavaCodeBlock jcb2 = _try(declare(x).as(CClassName.from("Integer")), set(x).to(literal(5)));
		assertThat(jcb2.representTerminating(), is(like("try { Integer x; x = 5; }")));
	}
	
	@Test
	public void canCatchAndThrowIdentifier() {
		Identifier x = new Identifier("x");
		TerminatingJavaCodeBlock jcb = _try(doNothing())._catch(CClassName.from("Exception"), x).then(_throw(x));
		assertThat(jcb.representTerminating(), is(like("try { } catch (Exception x) { throw x; }")));
	}
	
	@Test
	public void canThrowNewException() {
		TerminatingJavaCodeBlock jcb = _try(_throw(CClassName.from("ArrayException")));
		assertThat(jcb.representTerminating(), is(like("try { throw new ArrayException(); }")));
	}
	
	@Test
	public void canCatchMoreThanOneException() {
		Identifier x = new Identifier("x"); Identifier e = new Identifier("e");
		TerminatingJavaCodeBlock jcb = _try(_throw(CClassName.from("ArrayException"), x, e))
				._catch(CClassName.from("IndexException"), e).then(doNothing())
				._catch(CClassName.from("ArrayException"), e).then(doNothing())
				._finally(doNothing());
		assertThat(jcb.representTerminating(), is(like(
				"try { throw new ArrayException(x, e); } catch (IndexException e) { } catch (ArrayException e) { } finally { }")));
	}
}
