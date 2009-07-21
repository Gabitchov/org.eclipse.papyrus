/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.usecase.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.usecase.edit.policies.AssociationItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.usecase.figure.AssociationFigure;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;

/**
 * @generated
 */
public class AssociationEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4011;

	/**
	 * @generated
	 */
	public AssociationEditPart(View view) {
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

	public void deactivate() {
		removeAssociationEndListeners();
		super.deactivate();
	}

	/**
	 * @generated NOT
	 */
	protected void addAssociationEndListeners() {
		EObject sourceEnd = ((Association) resolveSemanticElement()).getMemberEnds().get(0);
		EObject targetEnd = ((Association) resolveSemanticElement()).getMemberEnds().get(1);
		addListenerFilter("AssociationEndListenersSource", this, sourceEnd);
		addListenerFilter("AssociationEndListenersTarget", this, targetEnd);
	}

	/**
	 * @generated NOT
	 */
	protected void removeAssociationEndListeners() {
		removeListenerFilter("AssociationEndListenersSource");
		removeListenerFilter("AssociationEndListenersTarget");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void handleNotificationEvent(Notification notification) {
		super.handleNotificationEvent(notification);

		// set the good ends for the association figure
		if (resolveSemanticElement() != null) {
			refreshVisuals();
		}
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new AssociationItemSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof AssociationNameEditPart) {
			((AssociationNameEditPart) childEditPart).setLabel(getPrimaryShape().getAssociationNameLabel());
			return true;
		}
		return false;
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
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof AssociationNameEditPart) {
			return true;
		}
		return false;
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
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model so you may safely remove
	 * <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected Connection createConnectionFigure() {
		return new AssociationFigure();
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
	protected void refreshVisuals() {
		Property source = (Property) ((Association) resolveSemanticElement()).getMembers().get(0);
		Property target = (Property) ((Association) resolveSemanticElement()).getMembers().get(1);
		int sourceType = 0;
		int targetType = 0;

		// navigable?
		if (source.isNavigable()) {
			sourceType += AssociationFigure.navigable;
		}
		if (target.isNavigable()) {
			targetType += AssociationFigure.navigable;
		}
		getPrimaryShape().setEnd(sourceType, targetType);
		super.refreshVisuals();
	}

}
