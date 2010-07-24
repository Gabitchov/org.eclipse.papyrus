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
package org.eclipse.papyrus.modelexplorer.actionprovider;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.modelexplorer.actions.CloseAllDiagramsAction;
import org.eclipse.papyrus.modelexplorer.actions.CloseDiagramAction;
import org.eclipse.papyrus.modelexplorer.actions.DeleteDiagramAction;
import org.eclipse.papyrus.modelexplorer.actions.DuplicateDiagramAction;
import org.eclipse.papyrus.modelexplorer.actions.OpenDiagramAction;
import org.eclipse.papyrus.modelexplorer.actions.RenameDiagramAction;
import org.eclipse.papyrus.sasheditor.contentprovider.IPageMngr;

/**
 * Provider used to create actions applicable on diagrams
 * 
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class DiagramActionProvider extends AbstractSubmenuActionProvider {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void fillContextMenu(IMenuManager menu) {
		Object selectedElement = resolveSemanticObject(getFirstSelectedElement());

		if (selectedElement != null && selectedElement instanceof Diagram) {
			Diagram diagram = (Diagram) selectedElement;
			// Get the Editor IPageMngr. It should be Transactional.
			IPageMngr pageMngr = EditorUtils.getIPageMngr();

			// Create Rename Diagram action
			RenameDiagramAction renameDiagramAction = new RenameDiagramAction(
					diagram);
			menu.add(renameDiagramAction);

			// Create Delete Diagram action
			OpenDiagramAction openDiagramAction = new OpenDiagramAction(
					pageMngr, diagram);
			menu.add(openDiagramAction);

			// Create Delete Diagram action
			CloseDiagramAction closeDiagramAction = new CloseDiagramAction(
					pageMngr, diagram);
			menu.add(closeDiagramAction);

			// Create Close all diagrams action
			// fjcano #287948 :: close all diagrams action
			CloseAllDiagramsAction closeAllDiagramsAction = new CloseAllDiagramsAction(
					pageMngr);
			menu.add(closeAllDiagramsAction);

			// Create Delete Diagram action
			DeleteDiagramAction deleteDiagramAction = new DeleteDiagramAction(
					pageMngr, diagram);
			menu.add(deleteDiagramAction);

			// Create Duplicate Diagram action
			DuplicateDiagramAction duplicateDiagramAction = new DuplicateDiagramAction(
					pageMngr, diagram);
			menu.add(duplicateDiagramAction);
		}
	}

}
