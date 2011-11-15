/**
 * 
 */
package org.eclipse.papyrus.infra.core.lifecycleevents;

import org.eclipse.papyrus.infra.core.lifecycleevents.DoSaveEvent;


/**
 * @author dumoulin
 *
 */
public class FakeSaveEvent extends DoSaveEvent {

	/**
	 * Constructor.
	 *
	 * @param serviceRegistry
	 * @param multiDiagramEditor
	 */
	public FakeSaveEvent() {
		super(null, null);
		// TODO Auto-generated constructor stub
	}

}
