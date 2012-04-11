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
package org.eclipse.papyrus.uml.diagram.usecase.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.editparts.UMLConnectionNodeEditPart;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.AppliedStereotypeLinkLabelDisplayEditPolicy;
import org.eclipse.papyrus.uml.diagram.usecase.edit.policies.AssociationItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.usecase.figure.AssociationFigure;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;

/**
 * @generated
 */
public class AssociationEditPart extends UMLConnectionNodeEditPart implements ITreeBranchEditPart {

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
		addListenerFilter("AssociationEndListenersSource", this, getSourceProperty());
		addListenerFilter("AssociationEndListenersTarget", this, getTargetProperty());
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
		if(resolveSemanticElement() != null) {
			refreshVisuals();
		}
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new AssociationItemSemanticEditPolicy());
		installEditPolicy(AppliedStereotypeLinkLabelDisplayEditPolicy.STEREOTYPE_LABEL_POLICY, new AppliedStereotypeLinkLabelDisplayEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof AssociationNameEditPart) {
			((AssociationNameEditPart)childEditPart).setLabel(getPrimaryShape().getAssociationNameLabel());
			return true;
		}
		if(childEditPart instanceof AssociationAppliedStereotypeEditPart) {
			((AssociationAppliedStereotypeEditPart)childEditPart).setLabel(getPrimaryShape().getAppliedStereotypeLabel());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if(addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if(childEditPart instanceof AssociationNameEditPart) {
			return true;
		}
		if(childEditPart instanceof AssociationAppliedStereotypeEditPart) {
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if(removeFixedChild(childEditPart)) {
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
		return (AssociationFigure)getFigure();
	}

	/**
	 * @generated NOT
	 */
	protected void refreshVisuals() {
		Property source = getSourceProperty();
		Property target = getTargetProperty();
		int sourceType = 0;
		int targetType = 0;
		// navigable?
		if(source != null && source.isNavigable()) {
			sourceType += AssociationFigure.navigable;
		}
		if(target != null && target.isNavigable()) {
			targetType += AssociationFigure.navigable;
		}
		getPrimaryShape().setEnd(sourceType, targetType);
		super.refreshVisuals();
	}

	/**
	 * @generated NOT
	 */
	protected Property getSourceProperty() {
		IGraphicalEditPart graphicalSource = (IGraphicalEditPart)getSource();
		if(graphicalSource != null) {
			return getRelatedProperty(graphicalSource.resolveSemanticElement());
		}
		return null;
	}

	/**
	 * @generated NOT
	 */
	protected Property getTargetProperty() {
		IGraphicalEditPart graphicalTarget = (IGraphicalEditPart)getTarget();
		if(graphicalTarget != null) {
			return getRelatedProperty(graphicalTarget.resolveSemanticElement());
		}
		return null;
	}

	/**
	 * @generated NOT
	 */
	protected Property getRelatedProperty(EObject obj) {
		if(obj != null && resolveSemanticElement() instanceof Association) {
			EList<Property> ends = ((Association)resolveSemanticElement()).getMemberEnds();
			for(Property end : ends) {
				if(obj.equals(end.getType())) {
					return end;
				}
			}
		}
		return null;
	}
}
