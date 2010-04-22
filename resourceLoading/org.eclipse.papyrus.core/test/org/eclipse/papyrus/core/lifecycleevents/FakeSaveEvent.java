/**
 * 
 */
package org.eclipse.papyrus.core.lifecycleevents;

import javax.imageio.spi.ServiceRegistry;

import org.eclipse.papyrus.core.editor.IMultiDiagramEditor;


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
