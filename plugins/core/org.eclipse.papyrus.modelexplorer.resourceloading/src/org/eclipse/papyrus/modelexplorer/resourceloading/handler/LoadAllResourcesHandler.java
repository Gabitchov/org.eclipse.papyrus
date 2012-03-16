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

import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.papyrus.core.resourceloading.util.LoadingUtils;
import org.eclipse.papyrus.resource.ModelSet;
import org.eclipse.swt.widgets.Display;

/**
 * Handler for the load resource action.
 * This actions load a resource in the model set, which is not yet loaded (due to resource loading strategy).
 */
public class LoadAllResourcesHandler extends AbstractResourceHandler {

	@Override
	protected void handleEObject(EObject eObj, final ModelSet modelSet, CompoundCommand cc, Set<URI> handledURI) {
		if(eObj.eIsProxy()) {
			InternalEObject internal = (InternalEObject)eObj;
			final URI proxyURI = internal.eProxyURI().trimFragment();
			final URI trimmedURI = proxyURI.trimFileExtension();
			if(!handledURI.contains(trimmedURI)) {
				handledURI.add(trimmedURI);
				Command cmd = new AbstractCommand() {

					public void redo() {
						ProgressMonitorDialog dialog = new ProgressMonitorDialog(Display.getCurrent().getActiveShell());
						dialog.open();
						IProgressMonitor monitor = dialog.getProgressMonitor();

						LoadingUtils.loadWithAssociatedResources(proxyURI, modelSet, true, monitor);

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
				cc.append(cmd);
			}
		}
	}

}
