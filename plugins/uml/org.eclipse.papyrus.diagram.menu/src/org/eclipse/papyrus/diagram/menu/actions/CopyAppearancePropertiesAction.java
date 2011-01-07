/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.diagram.menu.actions;

import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.requests.ApplyAppearancePropertiesRequest;
import org.eclipse.gmf.runtime.notation.View;


/**
 * The Class CopyAppearancePropertiesAction.
 */
@SuppressWarnings("restriction")
public class CopyAppearancePropertiesAction {

	/** The selected elements. */
	private List<IGraphicalEditPart> selectedElements;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param selectedElements
	 *        the selected elements
	 */
	public CopyAppearancePropertiesAction(List<IGraphicalEditPart> selectedElements) {
		this.selectedElements = selectedElements;
	}

	/**
	 * Returns the command to apply the same appearance for each element
	 * 
	 * @return
	 *         the command to apply the same appearance for each element
	 */
	@SuppressWarnings("restriction")
	public Command getCommand() {
		ApplyAppearancePropertiesRequest request = new ApplyAppearancePropertiesRequest();
		if(!selectedElements.isEmpty()) {
			//the behavior provided by GMF for this action is to copy the appearance provided by the FIRST selected element
			// for all other GMF action, the behavior used the last selected element
			int reference = 0;

			//we choose to apply the same behavior for each action!
			reference = selectedElements.size() - 1;
			View notationView = selectedElements.get(reference).getNotationView();
			request.setViewToCopyFrom(notationView);
		}

		CompoundCommand cmd = new CompoundCommand(""); //$NON-NLS-1$
		for(IGraphicalEditPart current : selectedElements) {
			Command tmp = current.getCommand(request);
			if(tmp != null && tmp.canExecute()) {
				cmd.add(tmp);
			}

		}
		return cmd.isEmpty() ? null : cmd;
	}

}
