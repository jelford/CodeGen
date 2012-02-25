package elford.james.codegen.test;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

public class Matchers {
	public static <T> StringLikeMatcher<T> like(T original) {
		return new StringLikeMatcher<T>(original);
	}
	
	public static class StringLikeMatcher<T> extends BaseMatcher<T> {
		
		private String original;

		public StringLikeMatcher(T original) {
			this.original = truncateWhitespace(original.toString());
		}
		
		public String truncateWhitespace(String original) {
			StringBuilder sb = new StringBuilder();
			char last = ' ';
			int index = 0;
			for (int i=0; index < original.length(); ++index) {
				char next = original.charAt(index);
				if (next == ' ' && last == ' ')
					continue;
				else {
					sb.append(next);
					last = next;
				}
			}
			
			return sb.toString().trim();
		}

		@Override
		public boolean matches(Object item) {
			if (!(item instanceof String))
				return false;
			else {
				String target = truncateWhitespace((String) item);
				return original.equals(target);
			}
			
		}

		@Override
		public void describeTo(Description description) {
			description.appendText("like \"");
			description.appendText(original);
			description.appendText("\"");
		}
		
	}
}
