package behavioral.templatemethod;

public class IPhoneCompiler extends CrossCompiler {

	protected void collectSources() {
		System.out.println("Collect IPhone specific sources");
	}

	protected void compileToTarget() {
		System.out.println("IPhone compilation");
	}

}
