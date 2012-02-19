package elford.james.codegen.test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import static elford.james.codegen.JavaLanguage.*;

public class TestHelperFunctions {

	@Test
	public void test() {
		assertThat(literal(5).toString(), is(equalTo("5")));
	}

}
