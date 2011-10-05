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
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.gmf.diagram.common.edit.policy.DefaultSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.common.figure.ConnectorEdgeFigure;

public class ConnectorEditPart extends AbstractElementLinkEditPart {

	/**
	 * Constructor.
	 */
	public ConnectorEditPart(View view) {
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
		if(childEditPart instanceof ConnectorLinkLabelEditPart) {
			((ConnectorLinkLabelEditPart)childEditPart).setLabel(getPrimaryShape().getNameLabel());
			return true;
		}
		if(childEditPart instanceof ConnectorLinkLabelSourceMultiplicityEditPart) {
			((ConnectorLinkLabelSourceMultiplicityEditPart)childEditPart).setLabel(getPrimaryShape().getSourceMultiplicityLabel());
			return true;
		}
		if(childEditPart instanceof ConnectorLinkLabelTargetMultiplicityEditPart) {
			((ConnectorLinkLabelTargetMultiplicityEditPart)childEditPart).setLabel(getPrimaryShape().getTargetMultiplicityLabel());
			return true;
		}
		return super.addFixedChild(childEditPart);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected boolean removeFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof ConnectorLinkLabelEditPart) {
			return true;
		}
		if(childEditPart instanceof ConnectorLinkLabelSourceMultiplicityEditPart) {
			return true;
		}
		if(childEditPart instanceof ConnectorLinkLabelTargetMultiplicityEditPart) {
			return true;
		}
		return super.removeFixedChild(childEditPart);
	}

	/**
	 * Creates figure for this edit part.
	 */
	protected Connection createConnectionFigure() {
		return new ConnectorEdgeFigure();
	}

	/**
	 * Creates primary shape for this edit part.
	 */
	public ConnectorEdgeFigure getPrimaryShape() {
		return (ConnectorEdgeFigure)getFigure();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void refreshLineType() {
		// Start of user code custom line type
		super.refreshLineType();
		// End of user code
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void refreshArrowSource() {
		// Start of user code custom source decoration
		super.refreshArrowSource();
		// End of user code
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void refreshArrowTarget() {
		// Start of user code custom target decoration
		super.refreshArrowTarget();
		// End of user code
	}
}
