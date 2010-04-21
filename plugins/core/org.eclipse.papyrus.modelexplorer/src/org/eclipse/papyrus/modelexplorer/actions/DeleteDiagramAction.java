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
package org.eclipse.papyrus.modelexplorer.actions;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.action.Action;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.sasheditor.contentprovider.di.IPageMngr;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

/**
 * Action used to delete the given diagram
 * 
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 * @author cedric dumoulin
 */
public class DeleteDiagramAction extends Action {

	Diagram diagram;

	IPageMngr pageMngr;

	public DeleteDiagramAction(IPageMngr pageMngr, Diagram diagram) {
		this.diagram = diagram;
		this.pageMngr = pageMngr;

		ISharedImages sharedImages = PlatformUI.getWorkbench()
				.getSharedImages();
		setImageDescriptor(sharedImages
				.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
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
		TransactionalEditingDomain editingDomain = EditorUtils
				.getTransactionalEditingDomain();
		if (editingDomain != null) {

			// Create a compound command containing removing of the sash and
			// removing from GMF
			// resource.
			CompoundCommand command = new CompoundCommand();
			Command sashRemoveComd = new RecordingCommand(editingDomain) {

				@Override
				protected void doExecute() {
					pageMngr.removePage(diagram);
				}
			};

			EList<EObject> diagrams = diagram.eResource().getContents();
			// TODO : synchronize with Cedric
			command.append(sashRemoveComd);
			command.append(new RemoveCommand(editingDomain, diagrams, diagram));
			editingDomain.getCommandStack().execute(command);
		}
	}
}
