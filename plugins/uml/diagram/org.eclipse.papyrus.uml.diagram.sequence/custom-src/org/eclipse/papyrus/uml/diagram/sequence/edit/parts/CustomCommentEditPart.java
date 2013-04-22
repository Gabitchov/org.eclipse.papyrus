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

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.FillStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.semantic.CustomCommentItemSemanticEditPolicy;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomCommentEditPart extends CommentEditPart {

	/**
	 * Constructor.
	 * 
	 * @param view
	 */
	public CustomCommentEditPart(View view) {
		super(view);
	}

	/**
	 * @Override
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new CustomCommentItemSemanticEditPolicy());
	}

	@Override
	protected void setLineWidth(int width) {
		if(primaryShape instanceof NodeFigure) {
			((NodeFigure)primaryShape).setLineWidth(width);
		}
		super.setLineWidth(width);
	}

	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshTransparency();
	}

	@Override
	protected void refreshTransparency() {
		FillStyle style = (FillStyle)getPrimaryView().getStyle(NotationPackage.Literals.FILL_STYLE);
		if(style != null) {
			setTransparency(style.getTransparency());
		}
	}
}
