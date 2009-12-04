/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.composite.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.composite.edit.policies.InformationFlowItemSemanticEditPolicy;

/**
 * @generated
 */
public class InformationFlowEditPart extends ConnectionNodeEditPart

implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4016;

	/**
	 * @generated
	 */
	public InformationFlowEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new InformationFlowItemSemanticEditPolicy());
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model so you may safely remove
	 * <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */

	protected Connection createConnectionFigure() {
		return new DirectedRelationshipDescriptor();
	}

	/**
	 * @generated
	 */
	public DirectedRelationshipDescriptor getPrimaryShape() {
		return (DirectedRelationshipDescriptor)getFigure();
	}

	/**
	 * @generated
	 */
	public class DirectedRelationshipDescriptor extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fDirectedRelationshipAppliedStereotypeLabel;

		/**
		 * @generated
		 */
		public DirectedRelationshipDescriptor() {
			this.setLineWidth(1);

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fDirectedRelationshipAppliedStereotypeLabel = new WrappingLabel();
			fDirectedRelationshipAppliedStereotypeLabel.setText("");

			this.add(fDirectedRelationshipAppliedStereotypeLabel);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getDirectedRelationshipAppliedStereotypeLabel() {
			return fDirectedRelationshipAppliedStereotypeLabel;
		}

	}

}
