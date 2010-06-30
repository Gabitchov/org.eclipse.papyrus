/**
 * 
 */
package org.eclipse.papyrus.diagram.common.part;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;


/**
 * Common ancestor of GMF based editors for UML.
 * This class allows to declare stuff commons to all this kind of editors.
 * 
 * @author cedric dumoulin
 *
 */
public class UmlGmfDiagramEditor extends DiagramDocumentEditor {


	/**
	 * The associated Diagram.
	 */
	private Diagram diagram;
	
	/**
	 * Object used to synchronize the name of the editor with the name of the diagram.
	 */
	private PartNameSynchronizer partNameSynchronizer;

	/**
	 * service registry of the backbone
	 */
	private ServicesRegistry servicesRegistry;

	/**
	 * Constructor.
	 *
	 * @param servicesRegistry
	 * @param diagram
	 * @throws ServiceException
	 */
	public UmlGmfDiagramEditor(ServicesRegistry servicesRegistry, Diagram diagram) throws ServiceException {
		super(true);
		this.diagram = diagram;
		this.servicesRegistry=servicesRegistry;
		// Install synchronizer
		partNameSynchronizer = new PartNameSynchronizer(diagram);
	}

	/**
	 * 
	 * @return  the backbone service registry. it cannot return null. 
	 */
	public ServicesRegistry getServicesRegistry(){
		return servicesRegistry;
	}
	/**
	 * Set the associated Diagram.
	 */
	public void setDiagram(Diagram diagram) {
		this.diagram = diagram;
		partNameSynchronizer.setDiagram(diagram);
	}

	/**
	 * Get the associated Diagram
	 */
	public Diagram getDiagram() {
		return diagram;
	}

	/**
	 * A class taking in charge the synchronization of the partName and the diagram name.
	 * When diagram name change, the other is automatically updated.
	 * @author cedric dumoulin
	 *
	 */
	public class PartNameSynchronizer {
		
		Diagram diagram;
		
		/**
		 * Listener on diagram name change.
		 */
		private Adapter diagramNameListener = new Adapter() {
	
			public void notifyChanged(Notification notification) {
				if( notification.getFeatureID(Diagram.class) == NotationPackage.DIAGRAM__NAME && notification.getNotifier() == diagram) {
					setPartName(diagram.getName());
				}
				
			}
	
			public Notifier getTarget() {
				return null;
			}
	
			public void setTarget(Notifier newTarget) {
			}
	
			public boolean isAdapterForType(Object type) {
				return false;
			}
			
		};
		/**
		 * 
		 * Constructor.
		 *
		 * @param diagram
		 */
		PartNameSynchronizer( Diagram diagram ) {
			setDiagram(diagram);
		}
		
		/**
		 * Change the associated diagram.
		 * @param diagram
		 */
		public void setDiagram( Diagram diagram) {
			// Remove from old diagram, if any
			if(this.diagram != null)
				diagram.eAdapters().remove(diagramNameListener);
			
			// Set new Diagram
			this.diagram = diagram;
			// Set editor name
			setPartName(diagram.getName());
			// Listen to name change
			diagram.eAdapters().add(diagramNameListener);
		}
	}
}
