/*****************************************************************************
 * Copyright (c) 2012 ATOS.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Olivier Mélois (ATOS) - Initial API and implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.sysml.diagram.requirement.edit.part;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.requirement.edit.policy.CustomRequirementInfoLabelUpdateEditPolicy;
import org.eclipse.papyrus.sysml.requirements.Requirement;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeLabelDisplayEditPolicy;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Element;

public abstract class CustomAbstractRequirementInformationLabelEditPart extends LabelEditPart {

	Requirement requirement;

	public CustomAbstractRequirementInformationLabelEditPart(View view) {
		super(view);
	}

	@Override
	protected void createDefaultEditPolicies() {

		/*
		 * edit policy used to refresh the labels when the stereotype application "Requirement" is updated.
		 */
		installEditPolicy(AppliedStereotypeLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY, new CustomRequirementInfoLabelUpdateEditPolicy());
		super.createDefaultEditPolicies();
		//Removing useless edit policies installed by superclasses.
		removeEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
		removeEditPolicy(EditPolicy.COMPONENT_ROLE);
	}

	@Override
	protected IFigure createFigure() {
		IFigure figure = new WrappingLabel();
		((WrappingLabel)figure).setTextWrap(true);
		figure.setFont(Display.getDefault().getSystemFont());
		return figure;
	}

	@Override
	public IFigure getFigure() {
		IFigure figure = super.getFigure();
		refreshLabelText();
		return figure;
	}

	public abstract void refreshLabelText();

	/**
	 * Refreshes the text of the label.
	 */
	@Override
	public void refresh() {
		this.refreshLabelText();
		super.refresh();
	}

	/**
	 * Gets the requirement associated to this edit part.
	 */
	protected Requirement getRequirement() {
		EditPart compartment = this.getParent();
		EditPart classEditPart = compartment.getParent();
		//Getting the class out of the edit part.
		Element clazz = (Element)((View)classEditPart.getModel()).getElement();
		//Getting the requirement out of the class.
		if(clazz != null) {
			for(EObject appliedStereotype : clazz.getStereotypeApplications()) {
				if(appliedStereotype instanceof Requirement) {
					return ((Requirement)appliedStereotype);
				}
			}
		}
		return null;
	}

}
