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
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.clazz.custom.edit.commands.RestoreRelatedLinksCommand;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.ModelEditPart;
import org.eclipse.papyrus.uml.diagram.common.actions.AbstractAction;

/**
 * Restore related links to selected element
 * 
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
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
		return ModelEditPart.MODEL_ID;
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
