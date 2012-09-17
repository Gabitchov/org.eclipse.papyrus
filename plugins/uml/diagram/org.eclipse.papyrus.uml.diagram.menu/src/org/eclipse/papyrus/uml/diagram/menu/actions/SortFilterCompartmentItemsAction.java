/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.menu.actions;

import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ListCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.requests.SortFilterContentRequest;
import org.eclipse.gmf.runtime.notation.View;


/**
 * 
 * The sort Filter Action.
 * This code comes from {@link SortFilterAction}
 * 
 */
@SuppressWarnings("restriction")
public class SortFilterCompartmentItemsAction {

	/** The selected elements. */
	private List<IGraphicalEditPart> selectedElements;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param selectedElements
	 *        the selected elements
	 */
	public SortFilterCompartmentItemsAction(List<IGraphicalEditPart> selectedElements) {
		this.selectedElements = selectedElements;
	}

	/**
	 * Returns the command for this action
	 * 
	 * @return
	 *         the command for this action
	 */
	public Command getCommand() {
		CompoundCommand command = new CompoundCommand("SortFilterCompartmentsItems"); //$NON-NLS-1$
		for(IGraphicalEditPart current : selectedElements) {
			Object model = current.getModel();
			if((model instanceof View) || ViewUtil.resolveSemanticElement((View)model) != null) {
				List<?> children = current.getChildren();
				for(int i = 0; i < children.size(); i++) {
					if(children.get(i) instanceof ListCompartmentEditPart) {
						ListCompartmentEditPart editPart = (ListCompartmentEditPart)children.get(i);
						List<?> childContributions = editPart.getChildren();
						SortFilterContentRequest contentRequest = new SortFilterContentRequest(childContributions);

						Command cmdTmp = editPart.getCommand(contentRequest);
						if(cmdTmp != null && cmdTmp.canExecute()) {
							command.add(cmdTmp);
						}
					}
				}
			}
		}
		return command.isEmpty() ? UnexecutableCommand.INSTANCE : command;
	}
}
