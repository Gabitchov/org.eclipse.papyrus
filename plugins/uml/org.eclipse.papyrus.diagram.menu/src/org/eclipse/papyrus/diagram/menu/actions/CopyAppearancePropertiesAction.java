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
public class CopyAppearancePropertiesAction extends AbstractGraphicalParametricAction {

	/**
	 * 
	 * Constructor.
	 * 
	 * @param selectedElements
	 *        the selected elements
	 */
	public CopyAppearancePropertiesAction(List<IGraphicalEditPart> selectedElements) {
		super(null, selectedElements);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.diagram.menu.actions.AbstractGraphicalParametricAction#getBuildedCommand()
	 * 
	 * @return
	 */
	@Override
	protected Command getBuildedCommand() {
		ApplyAppearancePropertiesRequest request = new ApplyAppearancePropertiesRequest();
		if(!getSelection().isEmpty()) {
			//the behavior provided by GMF for this action is to copy the appearance provided by the FIRST selected element
			// for all other GMF action, the behavior used the last selected element
			int reference = 0;

			//we choose to apply the same behavior for each action!
			reference = getSelection().size() - 1;
			View notationView = getSelection().get(reference).getNotationView();
			request.setViewToCopyFrom(notationView);
		}

		CompoundCommand cmd = new CompoundCommand(""); //$NON-NLS-1$
		for(IGraphicalEditPart current : getSelection()) {
			Command tmp = current.getCommand(request);
			if(tmp != null && tmp.canExecute()) {
				cmd.add(tmp);
			}

		}
		return cmd.isEmpty() ? null : cmd;
	}

}
