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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.infra.gmfdiag.common.editpart.IPapyrusEditPart;
import org.eclipse.papyrus.uml.appearance.helper.AppliedStereotypeHelper;
import org.eclipse.papyrus.uml.appearance.helper.UMLVisualInformationPapyrusConstant;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AbstractAppliedStereotypeDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomDurationConstraintAppliedStereotypeEditPart extends DurationConstraintAppliedStereotypeEditPart implements IPapyrusEditPart {

	/**
	 * Constructor.
	 * 
	 * @param view
	 */
	public CustomDurationConstraintAppliedStereotypeEditPart(View view) {
		super(view);
	}

	/**
	 * @Override
	 */
	public IFigure getPrimaryShape() {
		return getFigure();
	}

	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		View view = getNotationView();
		View parentView = null;
		EObject parent = view.eContainer();
		if(parent instanceof View) {
			parentView = (View)parent;
		}
		String stereotypespresentationLocation = AppliedStereotypeHelper.getAppliedStereotypesPropertiesLocalization(parentView);
		if(UMLVisualInformationPapyrusConstant.STEREOTYPE_BRACE_LOCATION.equals(stereotypespresentationLocation)) {
			EditPolicy editPolicy = getEditPolicy(AppliedStereotypeLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY);
			if(editPolicy instanceof AbstractAppliedStereotypeDisplayEditPolicy) {
				((AbstractAppliedStereotypeDisplayEditPolicy)editPolicy).refreshDisplay();
			}
		}
	}
}
