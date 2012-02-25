package elford.james.codegen.test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import static elford.james.codegen.test.Matchers.*;

import org.junit.Test;

public class TestMatchers {

	@Test
	public void testLike() {
		assertThat("hello  world", is(like("hello world")));
		assertThat("helll  world", is(not(like("hello world"))));
		assertThat(null, is(not(like("Hello world"))));
	}
	
	@Test
	public void testLikeNonTrivial() {
		assertThat("try { x.method(); } finally { }", is(like("try { x.method(); }  finally {  } ")));
	}

}
