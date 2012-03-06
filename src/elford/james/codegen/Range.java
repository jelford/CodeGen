package elford.james.codegen;

public class Range {
	public int from;
	public int to;

	public Range(int from, int to) {
		this.from = from; this.to = to;
	}

	public static RangeBuilder from(final int from) {
		return new RangeBuilder() {
			
			@Override
			public Range to(int to) {
				return new Range(from, to);
			}
		};
	}
	
	public static interface RangeBuilder {
		public Range to(int to);
	}
}
