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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.custom.figure.AssociationFigure;
import org.eclipse.papyrus.diagram.clazz.custom.helper.MultiAssociationHelper;
import org.eclipse.papyrus.diagram.clazz.edit.policies.AssociationBranchItemSemanticEditPolicy;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;

/**
 * @generated
 */
public class AssociationBranchEditPart extends ConnectionNodeEditPart implements
		ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4019;

	/**
	 * @generated
	 */
	public AssociationBranchEditPart(View view) {
		super(view);
	}

	/**
	 * @generated NOT
	 */
	public void activate() {
		super.activate();
		addAssociationEndListeners();
	}

	/**
	 * @generated NOT
	 */
	protected void addAssociationEndListeners() {
		if (resolveSemanticElement() instanceof Association) {
			Property targetEnd = MultiAssociationHelper
					.getPropertyToListen(((Edge) getModel()),
							(Association) resolveSemanticElement());
			if (targetEnd != null) {
				addListenerFilter(
						"AssociationEndListenersTarget", this, targetEnd); //$NON-NLS-1$

			}
		}
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof AssociationBranchRoleEditPart) {
			((AssociationBranchRoleEditPart) childEditPart)
					.setLabel(getPrimaryShape().getRoleSourceLabel());
			return true;
		}
		if (childEditPart instanceof AssociationBranchMultEditPart) {
			((AssociationBranchMultEditPart) childEditPart)
					.setLabel(getPrimaryShape().getMultiplicitySourceLabel());
			return true;
		}
		return false;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model so
	 * you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */

	protected Connection createConnectionFigure() {
		return new AssociationFigure();
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new AssociationBranchItemSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	public AssociationFigure getPrimaryShape() {
		return (AssociationFigure) getFigure();
	}

	/**
	 * @generated NOT
	 */

	protected void handleNotificationEvent(Notification event) {
		super.handleNotificationEvent(event);

		// set the good ends for the association figure
		if (((View) getModel()).isSetElement()) {

			refreshVisuals();
		}
	}

	/**
	 * @generated NOT
	 */
	protected void refreshVisuals() {
		if (resolveSemanticElement() instanceof Association) {
			Property target = MultiAssociationHelper
					.getPropertyToListen(((Edge) getModel()),
							(Association) resolveSemanticElement());
			if (target != null && target.getOwner() != null) {
				int sourceType = 0;
				int targetType = 0;
				// owned?
				if (target.getOwner().equals(resolveSemanticElement())) {
					targetType += AssociationFigure.owned;
				}
				// aggregation?
				if (target.getAggregation() == AggregationKind.SHARED_LITERAL) {
					targetType += AssociationFigure.aggregation;
				}
				// composite?
				if (target.getAggregation() == AggregationKind.COMPOSITE_LITERAL) {
					targetType += AssociationFigure.composition;
				}
				// navigable?
				if (target.isNavigable()) {
					targetType += AssociationFigure.navigable;
				}
				getPrimaryShape().setEnd(sourceType, targetType);
			}
		}
		super.refreshVisuals();
	}

	/**
	 * @generated NOT
	 */
	protected void removeAssociationEndListeners() {
		removeListenerFilter("AssociationEndListenersTarget");

	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof AssociationBranchRoleEditPart) {
			return true;
		}
		if (childEditPart instanceof AssociationBranchMultEditPart) {
			return true;
		}
		return false;
	}

}
