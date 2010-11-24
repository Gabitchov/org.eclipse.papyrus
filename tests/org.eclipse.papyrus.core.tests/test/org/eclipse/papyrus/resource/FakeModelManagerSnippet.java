/**
 * 
 */
package org.eclipse.papyrus.resource;

import org.eclipse.papyrus.resource.IModelSetSnippet;
import org.eclipse.papyrus.resource.ModelSet;


/**
 * a fake {@link IModelSetSnippet} for test purpose.
 * 
 * @author cedric dumoulin
 * 
 */
public class FakeModelManagerSnippet implements IModelSetSnippet {

	private TestTrace trace;

	private String name;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param string
	 */
	public FakeModelManagerSnippet(String name) {
		this.trace = new TestTrace();
		this.name = name;
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param trace2
	 * @param string
	 */
	public FakeModelManagerSnippet(TestTrace trace, String name) {
		this.trace = trace;
		this.name = name;
	}

	/**
	 * @see org.eclipse.papyrus.resource.IModelSetSnippet#start(org.eclipse.papyrus.resource.ModelSet)
	 * 
	 * @param modelsManager
	 */
	public void start(ModelSet modelsManager) {
		trace.addTrace(name, "start");
	}

	/**
	 * @see org.eclipse.papyrus.resource.IModelSetSnippet#dispose(org.eclipse.papyrus.resource.ModelSet)
	 * 
	 * @param modelsManager
	 */
	public void dispose(ModelSet modelsManager) {
		trace.addTrace(name, "dispose");

	}

}
