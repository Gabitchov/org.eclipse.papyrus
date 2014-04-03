/**
 * 
 */
package org.eclipse.papyrus.adapters.modisco;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.NotificationFilter;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmt.modisco.infra.browser.editors.EcoreBrowser;
import org.eclipse.papyrus.core.editor.BackboneException;
import org.eclipse.papyrus.core.services.ServiceException;
import org.eclipse.papyrus.core.services.ServicesRegistry;
import org.eclipse.papyrus.core.utils.DiResourceSet;
import org.eclipse.ui.IEditorPart;


/**
 * @author dumoulin
 *
 */
public class ModiscoBrowserEditor extends EcoreBrowser {

	/**
	 * ResourceSet shared by Papyrus.
	 */
	private ResourceSet resourceSet;
	
	private Resource modelResource;
	
	private ServicesRegistry servicesRegistry;
	
	/**
	 * Listen to model changes
	 */
	private final ResourceSetListener resourceSetListener = new ResourceSetListener() {

		public NotificationFilter getFilter() {
			return null;
		}

		public boolean isAggregatePrecommitListener() {
			return false;
		}

		public boolean isPostcommitOnly() {
			return true;
		}

		public boolean isPrecommitOnly() {
			return false;
		}

		public void resourceSetChanged(ResourceSetChangeEvent event) {
			if(event.getTransaction() != null && event.getTransaction().getStatus().isOK()) {
				getSite().getShell().getDisplay().asyncExec(new Runnable() {

					public void run() {
						reloadModel();
						}
										});
			}
		}

		public Command transactionAboutToCommit(ResourceSetChangeEvent event) throws RollbackException {
			return null;
		}

	};


	/**
	 * Constructor.
	 * @param servicesRegistry Service Registry used to retrieve service needed by this editor.
	 *
	 */
	public ModiscoBrowserEditor(ServicesRegistry servicesRegistry) throws ServiceException, BackboneException {
		
	
		this.servicesRegistry = servicesRegistry;
		
		// Share the same editing provider
		TransactionalEditingDomain editingDomain = servicesRegistry.getService(TransactionalEditingDomain.class);

		this.resourceSet = editingDomain.getResourceSet();
		
		// Get the model
		DiResourceSet resourceMngr = servicesRegistry.getService(DiResourceSet.class);
		modelResource = resourceMngr.getModelResource();

		// Let's listen to the resource set change
		editingDomain.addResourceSetListener(resourceSetListener);

	}
	
	/**
	 * @see org.eclipse.gmt.modisco.infra.browser.editors.EcoreBrowser#createModel()
	 *
	 * @return
	 */
	@Override
	protected Resource createModel() {
		
//		return super.createModel();
		return modelResource;
	}
	
	/**
	 * 
	 * @see org.eclipse.gmt.modisco.infra.browser.editors.EcoreBrowser#createResourceSet()
	 *
	 */
	@Override
	protected ResourceSet createResourceSet() {
		return resourceSet;
	}


}
