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
 *   Atos - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.usecase.providers.action;

import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.actions.AbstractAction;
import org.eclipse.papyrus.diagram.usecase.command.RestoreRelatedLinksCommand;
import org.eclipse.papyrus.diagram.usecase.edit.parts.UseCaseDiagramEditPart;

/**
 * Restore related links to selected element
 * TODO Refactor to eop.diagram.common : this in a RestoreRelatedLinksAction<T> class in eop.diagram.common
 * @author "Arthur Daussy <a href="mailto:arthur.daussy@atos.net">arthur.daussy@atos.net</a>"
 *
 */
public class RestoreRelatedLinksAction extends AbstractAction {

	public static String ID = "papyrus.restoreRelatedLinksAction";

	public RestoreRelatedLinksAction() {
		setId(ID);
		setText("Restore Related Elements");
		setToolTipText("Restore Related Elements");
		// setImageDescriptor(Plugin.getBundledImageDescriptor("icons/*.gif"));
	}

	/**
	 * @return
	 */
	protected String getDiagramNotationID() {
		return UseCaseDiagramEditPart.MODEL_ID;
	}

	/**
	 * @see org.eclipse.jface.action.Action#isEnabled()
	 */
	@Override
	public boolean isEnabled() {
		Diagram currentDiagram = getCurrentDiagram();
		if(currentDiagram != null) {
			return (!getSelection().isEmpty() && getDiagramNotationID().equals(currentDiagram.getType()));
		}
		return false;
	}

	/**
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		List<View> selection = getSelection();

		if(selection.isEmpty()) {
			return;
		}

		if(false == getHost() instanceof DiagramEditPart) {
			return;
		}
		DiagramEditPart diagramEditPart = (DiagramEditPart)getHost();

		final DiagramCommandStack commandStack = getHost().getDiagramEditDomain().getDiagramCommandStack();
		CompoundCommand cmd = new CompoundCommand("Restore Related Links");
		cmd.add(new ICommandProxy(new RestoreRelatedLinksCommand(diagramEditPart, selection)));
		commandStack.execute(cmd, new NullProgressMonitor());
	}

}
