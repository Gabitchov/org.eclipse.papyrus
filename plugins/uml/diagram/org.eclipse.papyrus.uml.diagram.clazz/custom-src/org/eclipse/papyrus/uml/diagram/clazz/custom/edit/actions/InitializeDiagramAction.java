/*******************************************************************************
 * Copyright (c) 2008 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.custom.edit.actions;

import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.diagram.ui.requests.ArrangeRequest;
import org.eclipse.gmf.runtime.diagram.ui.services.layout.LayoutType;
import org.eclipse.papyrus.uml.diagram.clazz.custom.edit.commands.InitializeDiagramCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ModelEditPart;
import org.eclipse.papyrus.uml.diagram.common.actions.AbstractAction;

/**
 * Initialize diagram elements from a semantic model.
 * 
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class InitializeDiagramAction extends AbstractAction {

	public static String ID = "papyrus.initializeDiagramAction";

	public InitializeDiagramAction() {
		setId(ID);
		setText("Initialize Diagram");
		setToolTipText("Initialize Diagram");
		// setImageDescriptor(Plugin.getBundledImageDescriptor("icons/*.gif"));
	}

	/**
	 * @return the diagram ID
	 */
	protected String getDiagramNotationID() {
		return ModelEditPart.MODEL_ID;
	}

	/**
	 * @see org.eclipse.jface.action.Action#isEnabled()
	 */
	@Override
	public boolean isEnabled() {
		try {
			return getDiagramNotationID().equals(getCurrentDiagram().getType());
		} catch (NullPointerException e) {
			// thrown by getCurrentDiagram() when no diagram is found.
			return false;
		}
	}

	/**
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		if(false == getHost() instanceof DiagramEditPart) {
			return;
		}
		DiagramEditPart diagramEditPart = (DiagramEditPart)getHost();
		final DiagramCommandStack commandStack = getHost().getDiagramEditDomain().getDiagramCommandStack();
		// Run initialize at first (do not use compoundCommand)
		commandStack.execute(new ICommandProxy(new InitializeDiagramCommand(diagramEditPart)), new NullProgressMonitor());
		// Run ArrangeAll on the newly created graphical elements
		// get the element list to arrange
		List<?> editparts = diagramEditPart.getRoot().getChildren();
		// arrange the elements
		ArrangeRequest arrangeRequest = new ArrangeRequest(ActionIds.ACTION_ARRANGE_ALL, LayoutType.DEFAULT);
		arrangeRequest.setPartsToArrange(editparts);
		Command arrangeCmd = diagramEditPart.getCommand(arrangeRequest);
		commandStack.execute(arrangeCmd, new NullProgressMonitor());
	}
}
