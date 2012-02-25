package elford.james.codegen;

import java.util.ArrayList;
import java.util.List;

public class CompositeJavaCodeBlock implements TerminatingJavaCodeBlock {
	List<TerminatingJavaCodeBlock> enclosedCode;

	public CompositeJavaCodeBlock(TerminatingJavaCodeBlock[] sequence) {
		enclosedCode = new ArrayList<TerminatingJavaCodeBlock>(sequence.length);
		for(TerminatingJavaCodeBlock tjcb : sequence)
			enclosedCode.add(tjcb);
	}

	@Override
	public String representTerminating() {
		StringBuilder sb = new StringBuilder();
		for (TerminatingJavaCodeBlock tjcb : enclosedCode)
			sb.append(tjcb.representTerminating()).append(" ");
		return sb.toString();
	}
	
	

}
