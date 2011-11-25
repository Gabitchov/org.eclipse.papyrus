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
package org.eclipse.papyrus.uml.diagram.common.editpolicies;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.commands.ShowHideElementsRequest;

/**
 * 
 * This EditPolicy provides the same commands that {@link PropertyHandlerEditPolicy}, more the command to Show/Hide a given
 * compartment
 * 
 */
public class ShowHideClassifierContentsEditPolicy extends AbstractEditPolicy {

	/** key for this EditPolicy */
	public static final String SHOW_HIDE_CLASSIFIER_CONTENTS_POLICY = "Show/Hide Classifier Contents Policy"; //$NON-NLS-1$

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.PropertyHandlerEditPolicy#getCommand(org.eclipse.gef.Request)
	 * 
	 * @param request
	 * @return
	 */
	@Override
	public Command getCommand(Request request) {
		if(request.getType().equals(ShowHideElementsRequest.SHOW_HIDE_ELEMENTS)) {
			ShowHideElementsRequest req = (ShowHideElementsRequest)request;
			if(req.getHidedEditPart() != null) {
				return getDestroyViewCommand(req.getHidedEditPart());
			} else if(req.getContainer() != null && req.getSemanticElement() != null) {
				return getCreateViewCommand(req.getContainer(), req.getSemanticElement(), req.getLocation());
			}
		}
		return null;
	}

	/**
	 * Return the command to create the view
	 * 
	 * @param container
	 *        the container for the element
	 * @param semanticElement
	 * @return The command to create the view
	 */
	protected Command getCreateViewCommand(View container, EObject semanticElement, Point location) {

		// creation of the node
		ViewDescriptor viewDescriptor = new ViewDescriptor(new EObjectAdapter(semanticElement), Node.class, null, ViewUtil.APPEND, true, ((IGraphicalEditPart)this.getHost()).getDiagramPreferencesHint());
		CompoundCommand compositeCmd = new CompoundCommand("Create View");//$NON-NLS-1$
		CreateCommand cmd = new CreateCommand(getEditingDomain(), viewDescriptor, container);
		if(cmd.canExecute()) {
			compositeCmd.add(new ICommandProxy(cmd));
		}
		// set the location
		if(location != null) {
			SetBoundsCommand setBoundsCommand = new SetBoundsCommand(getEditingDomain(), "move", (IAdaptable)cmd.getCommandResult().getReturnValue(), location); //$NON-NLS-1$
			if(setBoundsCommand.canExecute()) {
				compositeCmd.add(new ICommandProxy(setBoundsCommand));
			}
		}

		return compositeCmd;
	}

	/**
	 * Return the command to the EditPart
	 * 
	 * @param hidedEditPart
	 *        the EditPart to hide
	 * @return the command to the EditPart
	 */
	protected Command getDestroyViewCommand(EditPart hidedEditPart) {
		DeleteCommand cmd = new DeleteCommand(getEditingDomain(), (View)hidedEditPart.getModel());
		return new ICommandProxy(cmd);
	}

	/**
	 * Return the current {@link EditingDomain}
	 * 
	 * @return the current {@link EditingDomain}
	 */
	protected TransactionalEditingDomain getEditingDomain() {
		return ((IGraphicalEditPart)getHost()).getEditingDomain();
	}
}
