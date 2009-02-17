/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.navigator.actions;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.papyrus.di.Diagram;
import org.eclipse.papyrus.navigator.internal.utils.NavigatorUtils;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

/**
 * Action used to delete the given diagram
 * 
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class DeleteDiagramAction extends Action {

	Diagram diagram;

	public DeleteDiagramAction(Diagram diagram) {
		this.diagram = diagram;
		ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
		setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
		setText("Delete");
		setEnabled(true);
	}

	/**
	 * Delete the given diagram
	 * 
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		TransactionalEditingDomain editingDomain = NavigatorUtils.getTransactionalEditingDomain();
		if (editingDomain != null) {
			EList<EObject> diagrams = diagram.eResource().getContents();
			//TODO : synchronize with Cedric
			Command command = new RemoveCommand(editingDomain, diagrams, diagram);
			editingDomain.getCommandStack().execute(command);
		}
	}
}
