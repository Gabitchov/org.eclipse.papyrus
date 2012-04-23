/*****************************************************************************
 * Copyright (c) 2011 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *	 Arthur Daussy - arthur.daussy@atos.net - Bug 374809 - [SysML Internal Block Diagram] Provide "refresh block" - "restore connection" feature to ease IBD creation from existing model
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.internalblock.edit.actions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramCommandStack;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.sysml.diagram.internalblock.provider.ElementTypes;
import org.eclipse.papyrus.uml.diagram.common.actions.AbstractAction;
import org.eclipse.papyrus.uml.diagram.common.requests.ArrangeAffixedNodeRequest;
import org.eclipse.ui.PlatformUI;

/**
 * Arrange port action
 * 
 * @author adaussy
 * 
 */
public class ArrangePortsAction extends AbstractAction {

	public static String ID = Messages.ArrangePortsAction_ARRANGE_PORT_ACTION_ID;

	public ArrangePortsAction() {
		setId(ID);
		setText(Messages.ArrangePortsAction_ARRANGE_PORT_ACTION_LABEL);
		setToolTipText(Messages.ArrangePortsAction_ARRANGE_PORT_ACTION_TOOLTIP);
	}

	/**
	 * @return
	 */
	protected String getDiagramNotationID() {
		return ElementTypes.DIAGRAM_ID;
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
		List<IGraphicalEditPart> selection = getIGraphicalPartSelection();
		if(selection.isEmpty()) {
			return;
		}
		if(false == getHost() instanceof DiagramEditPart) {
			return;
		}
		final DiagramCommandStack commandStack = getHost().getDiagramEditDomain().getDiagramCommandStack();
		CompoundCommand cmd = new CompoundCommand("Arrange ports");////$NON-NLS-1$
		for(IGraphicalEditPart selectedPart : getIGraphicalPartSelection()) {
			Command arrangeCommand = selectedPart.getCommand(new ArrangeAffixedNodeRequest());
			if(arrangeCommand != null && arrangeCommand.canExecute()) {
				cmd.add(arrangeCommand);
			}
		}
		if(cmd.canExecute()) {
			commandStack.execute(cmd, new NullProgressMonitor());
		}
	}

	/**
	 * @return a list of selected objects view
	 */
	protected List<IGraphicalEditPart> getIGraphicalPartSelection() {
		List<IGraphicalEditPart> viewSelected = new ArrayList<IGraphicalEditPart>();
		ISelection selection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
		if(false == selection instanceof IStructuredSelection) {
			return Collections.emptyList();
		}
		for(Object object : ((IStructuredSelection)selection).toList()) {
			if(false == object instanceof IGraphicalEditPart) {
				continue;
			}
			if(object instanceof DiagramEditPart) {
				continue;
			}
			viewSelected.add((IGraphicalEditPart)object);
		}
		return viewSelected;
	}
}
