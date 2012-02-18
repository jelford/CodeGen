package elford.james.codegen;


public interface JavaCodeBlock extends JavaCodeBuilder {
	@Override
	public String toString();
	
	public String terminate();
}
