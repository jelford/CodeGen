package elford.james.codegen.scoped;

import elford.james.codegen.JavaCodeBlock;

public interface CatchBlock extends JavaScopedBlock {

	JavaScopedBlock _finally(JavaCodeBlock doNothing);

}
