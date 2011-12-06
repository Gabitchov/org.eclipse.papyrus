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
package org.eclipse.papyrus.sysml.diagram.common.edit.part;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.Graphics;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.gmf.diagram.common.edit.policy.DefaultSemanticEditPolicy;
import org.eclipse.papyrus.sysml.diagram.common.figure.AssociationFigure;
import org.eclipse.papyrus.uml.diagram.common.edit.part.AbstractElementLinkEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.AssociationLinkLabelSourceMultiplicityEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.AssociationLinkLabelSourceRoleEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.AssociationLinkLabelTargetMultiplicityEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.AssociationLinkLabelTargetRoleEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.NamedElementLinkLabelNameEditPart;
import org.eclipse.papyrus.uml.diagram.common.figure.EdgeDecorationType;
import org.eclipse.papyrus.uml.diagram.common.utils.AssociationViewUtils;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;

/**
 * Edit Part for SysML {@link Association}
 */
public class AssociationEditPart extends AbstractElementLinkEditPart {

	protected static final String ASSOCIATION_END_LISTENERS_SOURCE = "AssociationEndListenersSource";

	protected static final String ASSOCIATION_END_LISTENERS_TARGET = "AssociationEndListenersTarget";

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void activate() {
		super.activate();
		addAssociationEndListeners();
	}

	/**
	 * this methods add listeners on targets and sources
	 */
	protected void addAssociationEndListeners() {
		EObject semanticElement = resolveSemanticElement();
		if(semanticElement instanceof Association) {

			Association association = (Association)semanticElement;

			if(association.getMemberEnds().size() >= 2) {

				EObject sourceEnd = AssociationViewUtils.getSourceSemanticEnd(getNotationView());
				EObject targetEnd = AssociationViewUtils.getTargetSemanticEnd(getNotationView());

				addListenerFilter(ASSOCIATION_END_LISTENERS_SOURCE, this, sourceEnd); //$NON-NLS-1$
				addListenerFilter(ASSOCIATION_END_LISTENERS_TARGET, this, targetEnd); //$NON-NLS-1$

			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deactivate() {
		removeAssociationEndListeners();
		super.deactivate();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void handleNotificationEvent(Notification event) {
		super.handleNotificationEvent(event);

		// Set association ends appearance (aggregation diamond, navigable arrow, etc...)
		if(resolveSemanticElement() != null) {
			refreshVisuals();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();

		if(resolveSemanticElement() != null) {
			if(getSource() == null || getTarget() == null) {
				return;
			}
			if(((GraphicalEditPart)getSource()).resolveSemanticElement() == null || ((GraphicalEditPart)getTarget()).resolveSemanticElement() == null) {
				return;
			}

			Property source = AssociationViewUtils.getSourceSemanticEnd(getNotationView());
			Property target = AssociationViewUtils.getTargetSemanticEnd(getNotationView());
			if(source == null || target == null) {
				return;
			}
			
			// Get the association
			Element umlElement = getUMLElement();
			if(umlElement instanceof Association) {
				Association association = (Association)getUMLElement();

				// Show navigable arrow if either source or target is navigable
				// not when both are navigable.
				if(isNavigable(association, source) && isNavigable(association, target)) {

					// No navigable mark shown on figure.
					if(source.getAggregation() == AggregationKind.NONE_LITERAL) {
						setArrowSource(getArrowDecoration(EdgeDecorationType.NONE));
					}
					if(target.getAggregation() == AggregationKind.NONE_LITERAL) {
						setArrowTarget(getArrowDecoration(EdgeDecorationType.NONE));
					}

				} else {

					if(isNavigable(association, source)) {
						setArrowTarget(getArrowDecoration(EdgeDecorationType.OPEN_ARROW));
						if(source.getAggregation() == AggregationKind.NONE_LITERAL) {
							setArrowSource(getArrowDecoration(EdgeDecorationType.NONE));
						}					}

					if(isNavigable(association, target)) {
						setArrowSource(getArrowDecoration(EdgeDecorationType.OPEN_ARROW));
						if(target.getAggregation() == AggregationKind.NONE_LITERAL) {
							setArrowTarget(getArrowDecoration(EdgeDecorationType.NONE));
						}					}

				}
				
				if(source.getAggregation() == AggregationKind.SHARED_LITERAL) {
					setArrowSource(getArrowDecoration(EdgeDecorationType.SOLID_DIAMOND_EMPTY));
				}
				if(target.getAggregation() == AggregationKind.SHARED_LITERAL) {
					setArrowTarget(getArrowDecoration(EdgeDecorationType.SOLID_DIAMOND_EMPTY));
				}

				if(source.getAggregation() == AggregationKind.COMPOSITE_LITERAL) {
					setArrowSource(getArrowDecoration(EdgeDecorationType.SOLID_DIAMOND_FILLED));
				}
				if(target.getAggregation() == AggregationKind.COMPOSITE_LITERAL) {
					setArrowTarget(getArrowDecoration(EdgeDecorationType.SOLID_DIAMOND_FILLED));
				}

			}
		}
	}

	/**
	 * SysML implementation for isNavigable.
	 * 
	 * @param end
	 * @return
	 */
	private boolean isNavigable(Association association, Property end) {
		boolean isNavigable = false;

		if(association.getOwnedEnds().contains(end)) {
			isNavigable = false;
		} else {
			isNavigable = true;
		}

		return isNavigable;
	}

	/**
	 * this method is used to remove listener on ends
	 */
	protected void removeAssociationEndListeners() {
		removeListenerFilter(ASSOCIATION_END_LISTENERS_SOURCE);
		removeListenerFilter(ASSOCIATION_END_LISTENERS_TARGET);
	}

	/**
	 * Constructor.
	 */
	public AssociationEditPart(View view) {
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
		if(childEditPart instanceof NamedElementLinkLabelNameEditPart) {
			((NamedElementLinkLabelNameEditPart)childEditPart).setLabel(getPrimaryShape().getNameLabel());
			return true;
		}
		if(childEditPart instanceof AssociationLinkLabelSourceRoleEditPart) {
			((AssociationLinkLabelSourceRoleEditPart)childEditPart).setLabel(getPrimaryShape().getSourceRoleLabel());
			return true;
		}
		if(childEditPart instanceof AssociationLinkLabelSourceMultiplicityEditPart) {
			((AssociationLinkLabelSourceMultiplicityEditPart)childEditPart).setLabel(getPrimaryShape().getSourceMultiplicityLabel());
			return true;
		}
		if(childEditPart instanceof AssociationLinkLabelTargetRoleEditPart) {
			((AssociationLinkLabelTargetRoleEditPart)childEditPart).setLabel(getPrimaryShape().getTargetRoleLabel());
			return true;
		}
		if(childEditPart instanceof AssociationLinkLabelTargetMultiplicityEditPart) {
			((AssociationLinkLabelTargetMultiplicityEditPart)childEditPart).setLabel(getPrimaryShape().getTargetMultiplicityLabel());
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
		if(childEditPart instanceof AssociationLinkLabelSourceRoleEditPart) {
			return true;
		}
		if(childEditPart instanceof AssociationLinkLabelSourceMultiplicityEditPart) {
			return true;
		}
		if(childEditPart instanceof AssociationLinkLabelTargetRoleEditPart) {
			return true;
		}
		if(childEditPart instanceof AssociationLinkLabelTargetMultiplicityEditPart) {
			return true;
		}
		return super.removeFixedChild(childEditPart);
	}

	/**
	 * Creates figure for this edit part.
	 */
	protected Connection createConnectionFigure() {
		return new AssociationFigure();
	}

	/**
	 * Creates primary shape for this edit part.
	 */
	public AssociationFigure getPrimaryShape() {
		return (AssociationFigure)getFigure();
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
		// Not implemented, refreshVisuals currently implements this.
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void refreshArrowTarget() {
		// Not implemented, refreshVisuals currently implements this.
	}
}
