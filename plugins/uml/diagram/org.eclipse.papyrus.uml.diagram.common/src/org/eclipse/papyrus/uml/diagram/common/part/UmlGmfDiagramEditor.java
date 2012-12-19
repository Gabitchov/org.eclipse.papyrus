/**
 * 
 */
package org.eclipse.papyrus.uml.diagram.common.part;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.gef.KeyHandler;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.papyrus.infra.core.lifecycleevents.ISaveAndDirtyService;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.gmfdiag.common.SynchronizableGmfDiagramEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.contexts.IContextService;

/**
 * Common ancestor of GMF based editors for UML. This class allows to declare
 * stuff commons to all this kind of editors.
 * 
 * @author cedric dumoulin
 * 
 */
public class UmlGmfDiagramEditor extends SynchronizableGmfDiagramEditor {

	/**
	 * The associated Diagram.
	 */
	private Diagram diagram;

	/**
	 * Object used to synchronize the name of the editor with the name of the
	 * diagram.
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
		this.servicesRegistry = servicesRegistry;
		// Install synchronizer
		partNameSynchronizer = new PartNameSynchronizer(diagram);

		// Register this part to the ISaveAndDirtyService.
		// This will allows to be notified of saveAs events, and the isDirty
		// flag will be taken into
		// account.
		ISaveAndDirtyService saveAndDirtyService = servicesRegistry.getService(ISaveAndDirtyService.class);
		saveAndDirtyService.registerIsaveablePart(this);

		// TODO: unregister when editor is disposed !
	}

	/**
	 * Dispose services used in this part.
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor#dispose()
	 * 
	 */
	@Override
	public void dispose() {
		super.dispose();

		ISaveAndDirtyService saveAndDirtyService;
		try {
			saveAndDirtyService = servicesRegistry.getService(ISaveAndDirtyService.class);
			saveAndDirtyService.removeIsaveablePart(this);

		} catch (ServiceException e) {
			// the service can't be found. Maybe it is already disposed.
			// Do nothing
		}

		partNameSynchronizer = null;
		diagram = null;
		servicesRegistry = null;
	}

	/**
	 * 
	 * @return the backbone service registry. it cannot return null.
	 */
	public ServicesRegistry getServicesRegistry() {
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
	@Override
	public Diagram getDiagram() {
		return diagram;
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor#getKeyHandler()
	 * 
	 * @return
	 */
	@Override
	protected KeyHandler getKeyHandler() {
		// we remove all keybinding provided by GMF
		KeyHandler keyHandler = new KeyHandler();
		return keyHandler;
	}

	/**
	 * A class taking in charge the synchronization of the partName and the
	 * diagram name. When diagram name change, the other is automatically
	 * updated.
	 * 
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
				if(notification.getFeatureID(Diagram.class) == NotationPackage.DIAGRAM__NAME && notification.getNotifier() == diagram) {
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
		PartNameSynchronizer(Diagram diagram) {
			setDiagram(diagram);
		}

		/**
		 * Change the associated diagram.
		 * 
		 * @param diagram
		 */
		public void setDiagram(Diagram diagram) {
			// Remove from old diagram, if any
			if(this.diagram != null) {
				diagram.eAdapters().remove(diagramNameListener);
			}

			// Set new Diagram
			this.diagram = diagram;
			// Set editor name
			setPartName(diagram.getName());
			// Listen to name change
			diagram.eAdapters().add(diagramNameListener);
		}
	}

	@Override
	public void createPartControl(Composite parent) {
		IContextService contextService = (IContextService)getSite().getService(IContextService.class);
		//FIXME : before Eclipse Juno, this line was not necessary
		//see bug 367816 and bug 382218
		contextService.activateContext("org.eclipse.gmf.runtime.diagram.ui.diagramContext"); //$NON-NLS-1$
		super.createPartControl(parent);

	}
}
