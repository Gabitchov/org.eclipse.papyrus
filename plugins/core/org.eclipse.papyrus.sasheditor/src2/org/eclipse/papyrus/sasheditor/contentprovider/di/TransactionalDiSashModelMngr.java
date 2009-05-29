/**
 * 
 */
package org.eclipse.papyrus.sasheditor.contentprovider.di;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.sasheditor.contentprovider.di.internal.TransactionalDiContentProvider;


/**
 * DiSashModelMngr providing transactional commands to modify SashModel.
 * @author dumoulin
 *
 */
public class TransactionalDiSashModelMngr extends DiSashModelMngr {

	private TransactionalDiContentProvider transDiContentProvider;
	
	/**
	 * 
	 * Constructor.
	 * @param pageModelFactory
	 * @param diResource
	 */
	public TransactionalDiSashModelMngr(IPageModelFactory pageModelFactory, final Resource diResource, TransactionalEditingDomain editingDomain) {
		super(pageModelFactory, false);
		
		
		// Set the 
		transDiContentProvider = new TransactionalDiContentProvider(getDiContentProvider(), editingDomain);
		
		// lookup the SashModel
		sashWindowMngr = lookupSashWindowMngr(diResource);
		if(sashWindowMngr == null)
		{
			RecordingCommand command = new RecordingCommand(editingDomain){
			
				@Override
				protected void doExecute() {
					// Create a default model and attach it to resource.
					sashWindowMngr = createDefaultSashModel();
					diResource.getContents().add(sashWindowMngr);
				}
			};
			
			editingDomain.getCommandStack().execute(command);
		}
	}

}
