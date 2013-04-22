/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.CombinedFragmentCreationEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.semantic.CustomInteractionInteractionCompartmentItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.util.HighlightUtil;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomInteractionInteractionCompartmentEditPart extends InteractionInteractionCompartmentEditPart {

	/**
	 * Constructor.
	 * 
	 * @param view
	 */
	public CustomInteractionInteractionCompartmentEditPart(View view) {
		super(view);
	}

	/**
	 * @Override
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomInteractionInteractionCompartmentItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CombinedFragmentCreationEditPolicy());
		removeEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE);
	}

	/**
	 * Generated not for send to back CombinedFragment and InteractionUse {@inheritDoc}
	 */
	// TODO Use transparency instead of send to back method
	@Override
	protected void addChildVisual(EditPart childEditPart, int index) {
		if(childEditPart instanceof CombinedFragmentEditPart || childEditPart instanceof ConsiderIgnoreFragmentEditPart || childEditPart instanceof InteractionUseEditPart) {
			index = 0;
		}
		super.addChildVisual(childEditPart, index);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#
	 * showTargetFeedback(org.eclipse.gef.Request)
	 */
	@Override
	public void showTargetFeedback(Request request) {
		if(!isEditModeEnabled() || !isActive()) {
			return;
		}
		// Avoid default drop feedback by setting background, just highlight it
		// with bold border.
		EditPolicyIterator i = getEditPolicyIterator();
		while(i.hasNext()) {
			EditPolicy next = i.next();
			if(REQ_CREATE.equals(request.getType()) && next.getClass().getName().equals("org.eclipse.papyrus.infra.gmfdiag.dnd.policy.CustomizableDropEditPolicy")) {
				HighlightUtil.highlight(this);
			} else {
				next.showTargetFeedback(request);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#
	 * eraseTargetFeedback(org.eclipse.gef.Request)
	 */
	@Override
	public void eraseTargetFeedback(Request request) {
		super.eraseTargetFeedback(request);
		HighlightUtil.unhighlight(this);
	}
}
