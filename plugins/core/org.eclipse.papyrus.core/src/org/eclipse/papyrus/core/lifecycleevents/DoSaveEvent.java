/**
 * 
 */
package org.eclipse.papyrus.core.lifecycleevents;


import org.eclipse.papyrus.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.core.services.ServicesRegistry;


/**
 * Event sent whith a Save or SaveAs.
 * 
 * @author cedric dumoulin
 * 
 */
public class DoSaveEvent {

	final protected ServicesRegistry serviceRegistry;
	final protected IMultiDiagramEditor multiDiagramEditor;
	
	/**
	 * Create an Event that is sent with a Save or SaveAs.
	 * The same event can be reused.
	 * Constructor.
	 *
	 * @param serviceRegistry
	 * @param multiDiagramEditor
	 */
	public DoSaveEvent(ServicesRegistry serviceRegistry, IMultiDiagramEditor multiDiagramEditor) {
		this.serviceRegistry = serviceRegistry;
		this.multiDiagramEditor = multiDiagramEditor;
	}

	/**
	 * @return the serviceRegistry
	 */
	public ServicesRegistry getServiceRegistry() {
		return serviceRegistry;
	}
	
	/**
	 * @return the multiDiagramEditor
	 */
	public IMultiDiagramEditor getMultiDiagramEditor() {
		return multiDiagramEditor;
	}
	
}
