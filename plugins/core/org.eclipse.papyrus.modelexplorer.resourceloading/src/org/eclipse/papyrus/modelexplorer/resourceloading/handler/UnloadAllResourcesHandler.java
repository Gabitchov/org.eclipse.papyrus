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
package org.eclipse.papyrus.modelexplorer.resourceloading.handler;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.papyrus.core.resourceloading.util.LoadingUtils;
import org.eclipse.papyrus.modelexplorer.handler.AbstractCommandHandler;
import org.eclipse.papyrus.resource.ModelSet;
import org.eclipse.papyrus.resource.notation.NotationUtils;
import org.eclipse.swt.widgets.Display;

/**
 * Handler for the load resource action.
 * This actions load a resource in the model set, which is not yet loaded (due to resource loading strategy).
 */
public class UnloadAllResourcesHandler extends AbstractCommandHandler {

	/**
	 * @see org.eclipse.papyrus.modelexplorer.handler.AbstractCommandHandler#getCommand()
	 * @return the command
	 */
	@Override
	protected Command getCommand() {
		TransactionalEditingDomain editingDomain = getEditingDomain();
		List<EObject> selection = getSelectedElements();
		if(editingDomain != null && editingDomain.getResourceSet() instanceof ModelSet && !selection.isEmpty()) {
			final ModelSet modelSet = (ModelSet)editingDomain.getResourceSet();
			CompoundCommand command = new CompoundCommand();
			List<URI> handledURI = new ArrayList<URI>();
			// ensure main URI is never unloaded
			URI mainURI = NotationUtils.getNotationModel(modelSet).getResourceURI().trimFileExtension();
			handledURI.add(mainURI);
			for(EObject sel : selection) {
				if(!sel.eIsProxy()) {
					final URI uri = sel.eResource().getURI();
					final URI trimmedURI = uri.trimFileExtension();
					if(!handledURI.contains(trimmedURI)) {
						handledURI.add(trimmedURI);
						Command cmd = new AbstractCommand() {

							public void redo() {
								ProgressMonitorDialog dialog = new ProgressMonitorDialog(Display.getCurrent().getActiveShell());
								dialog.open();
								IProgressMonitor monitor = dialog.getProgressMonitor();

								LoadingUtils.unloadWithAssociatedResources(uri, modelSet, true, monitor);

								monitor.done();
								dialog.close();
							}

							public void execute() {
								redo();
							}

							@Override
							public boolean canUndo() {
								return false;
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
