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

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.IPapyrusEditPart;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.AppliedStereotypeExternalNodeLabelEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.UMLTextSelectionEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.figures.AppliedStereotypeLabelFigure;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomDurationObservationAppliedStereotypeEditPart extends DurationObservationAppliedStereotypeEditPart implements IPapyrusEditPart {

	/**
	 * Constructor.
	 * 
	 * @param view
	 */
	public CustomDurationObservationAppliedStereotypeEditPart(View view) {
		super(view);
	}

	/**
	 * @Override
	 */
	public IFigure getPrimaryShape() {
		return getFigure();
	}

	protected void refreshLabel() {
		//We do NOT want to update label with the Parser.
		Object pdEditPolicy = getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
		if(pdEditPolicy instanceof UMLTextSelectionEditPolicy) {
			((UMLTextSelectionEditPolicy)pdEditPolicy).refreshFeedback();
		}
		Object sfEditPolicy = getEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE);
		if(sfEditPolicy instanceof UMLTextSelectionEditPolicy) {
			((UMLTextSelectionEditPolicy)sfEditPolicy).refreshFeedback();
		}
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		removeEditPolicy(AppliedStereotypeLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY);
		View view = getPrimaryView();
		View stereotypeChangedView = view;
		if(view != null) {
			//			stereotypeChangedView = ViewUtil.getChildBySemanticHint(view, UMLVisualIDRegistry.getType(DurationObservationLabelEditPart.VISUAL_ID));
		}
		installEditPolicy(AppliedStereotypeLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY, new AppliedStereotypeExternalNodeLabelEditPolicy(stereotypeChangedView));
	}

	@Override
	protected IFigure createFigurePrim() {
		return new AppliedStereotypeLabelFigure();
	}
}
