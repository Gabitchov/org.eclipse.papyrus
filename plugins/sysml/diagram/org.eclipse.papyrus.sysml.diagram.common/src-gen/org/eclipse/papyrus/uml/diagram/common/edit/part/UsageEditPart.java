/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.edit.part;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.Graphics;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.gmf.diagram.common.edit.policy.DefaultSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeLinkLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.figure.EdgeDecorationType;
import org.eclipse.papyrus.uml.diagram.common.figure.NamedElementEdgeFigure;

public class UsageEditPart extends AbstractElementLinkEditPart {

	/**
	 * Constructor.
	 */
	public UsageEditPart(View view) {
		super(view);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new DefaultSemanticEditPolicy());
		installEditPolicy(AppliedStereotypeLinkLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY, new AppliedStereotypeLinkLabelDisplayEditPolicy("use"));
		// Start of user code custom policies
		// End of user code
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean addFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof NamedElementLinkLabelNameEditPart) {
			((NamedElementLinkLabelNameEditPart)childEditPart).setLabel(getPrimaryShape().getNameLabel());
			return true;
		}
		return super.addFixedChild(childEditPart);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean removeFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof NamedElementLinkLabelNameEditPart) {
			return true;
		}
		return super.removeFixedChild(childEditPart);
	}

	/**
	 * Creates figure for this edit part.
	 */
	protected Connection createConnectionFigure() {
		return new NamedElementEdgeFigure();
	}

	/**
	 * Creates primary shape for this edit part.
	 */
	public NamedElementEdgeFigure getPrimaryShape() {
		return (NamedElementEdgeFigure)getFigure();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void refreshLineType() {
		// Start of user code custom line type
		setLineType(Graphics.LINE_CUSTOM);
		// End of user code
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void refreshArrowSource() {
		// Start of user code custom source decoration
		setArrowSource(getArrowDecoration(EdgeDecorationType.NONE));
		// End of user code
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void refreshArrowTarget() {
		// Start of user code custom target decoration
		setArrowTarget(getArrowDecoration(EdgeDecorationType.OPEN_ARROW));
		// End of user code
	}
}
