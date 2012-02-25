package elford.james.codegen;

public class RawUnterminatedJavaCodeBlock implements UnterminatedJavacodeBlock {

	private String value;
	public RawUnterminatedJavaCodeBlock(String value) {
		this.value = value;
	}
	@Override
	public String representUnterminating() {
		return value;
	}

}
