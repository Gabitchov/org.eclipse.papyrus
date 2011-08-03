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
import org.eclipse.papyrus.uml.diagram.common.figure.EdgeDecorationType;
import org.eclipse.papyrus.uml.diagram.common.figure.GeneralizationFigure;

public class GeneralizationEditPart extends AbstractElementLinkEditPart {

	/**
	 * Constructor.
	 */
	public GeneralizationEditPart(View view) {
		super(view);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new DefaultSemanticEditPolicy());
		// Start of user code custom policies	
		// End of user code
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean addFixedChild(EditPart childEditPart) {
		return super.addFixedChild(childEditPart);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean removeFixedChild(EditPart childEditPart) {
		return super.removeFixedChild(childEditPart);
	}

	/**
	 * Creates figure for this edit part.
	 */
	protected Connection createConnectionFigure() {
		return new GeneralizationFigure();
	}

	/**
	 * Creates primary shape for this edit part.
	 */
	public GeneralizationFigure getPrimaryShape() {
		return (GeneralizationFigure)getFigure();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void refreshLineType() {
		setLineType(Graphics.LINE_SOLID);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void refreshArrowSource() {
		setArrowSource(getArrowDecoration(EdgeDecorationType.NONE));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void refreshArrowTarget() {
		setArrowTarget(getArrowDecoration(EdgeDecorationType.SOLID_ARROW_EMPTY));
	}
}
