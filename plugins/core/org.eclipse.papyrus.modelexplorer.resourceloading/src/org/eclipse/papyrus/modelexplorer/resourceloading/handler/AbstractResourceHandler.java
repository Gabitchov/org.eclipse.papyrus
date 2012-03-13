package org.eclipse.papyrus.modelexplorer.resourceloading.handler;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.modelexplorer.handler.AbstractCommandHandler;
import org.eclipse.papyrus.resource.ModelSet;


public abstract class AbstractResourceHandler extends AbstractCommandHandler {

	@Override
	protected Command getCommand() {
		TransactionalEditingDomain editingDomain = getEditingDomain();
		List<EObject> selection = getSelectedElements();
		if(editingDomain != null && editingDomain.getResourceSet() instanceof ModelSet && !selection.isEmpty()) {
			ModelSet modelSet = (ModelSet)editingDomain.getResourceSet();

			CompoundCommand cc = new CompoundCommand();
			Set<URI> handledURI = new HashSet<URI>();
			
			for(EObject sel : selection) {
				handleEObject(sel, modelSet, cc, handledURI);
			}

			return cc;
		}

		return UnexecutableCommand.INSTANCE;
	}
	
	protected abstract void handleEObject(EObject eObj, ModelSet modelSet, CompoundCommand cc, Set<URI> handledURI);
}
