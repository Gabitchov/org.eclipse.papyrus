/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Hemery (Atos) vincent.hemery@atos.net - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer.resourceloading.handler;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.services.resourceloading.util.LoadingUtils;
import org.eclipse.papyrus.views.modelexplorer.handler.AbstractCommandHandler;

/**
 * Handler for the load resource action.
 * This actions load a resource in the model set, which is not yet loaded (due to resource loading strategy).
 */
public class LoadResourceHandler extends AbstractCommandHandler {


	/**
	 * Get the command to load resource of selected model object
	 * 
	 * @see org.eclipse.papyrus.views.modelexplorer.handler.AbstractCommandHandler#getCommand()
	 * @return the command
	 */
	@Override
	protected Command getCommand() {
		TransactionalEditingDomain editingDomain = getEditingDomain();
		List<EObject> selection = getSelectedElements();
		if(editingDomain != null && editingDomain.getResourceSet() instanceof ModelSet && selection.size() > 0) {
			final ModelSet set = (ModelSet)editingDomain.getResourceSet();
			CompoundCommand command = new CompoundCommand();
			List<URI> handledURI = new ArrayList<URI>();
			for(EObject sel : selection) {
				if(sel.eIsProxy()) {
					InternalEObject internal = (InternalEObject)sel;
					URI uriProxy = internal.eProxyURI();
					final URI uriTrim = uriProxy.trimFragment().trimFileExtension();
					if(!handledURI.contains(uriTrim)) {
						handledURI.add(uriTrim);
						Command cmd = new AbstractCommand() {

							public void redo() {
								LoadingUtils.loadResourcesInModelSet(set, uriTrim);
							}

							public void execute() {
								redo();
							}

							@Override
							public boolean canExecute() {
								return true;
							}
						};
						command.append(cmd);
					}
				}
			}
			return command;
		}
		return UnexecutableCommand.INSTANCE;
	}

}
