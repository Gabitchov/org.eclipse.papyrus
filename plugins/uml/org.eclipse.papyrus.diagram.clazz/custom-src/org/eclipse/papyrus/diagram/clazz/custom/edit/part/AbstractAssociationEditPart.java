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
package org.eclipse.papyrus.diagram.clazz.custom.edit.part;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.custom.figure.AssociationFigure;
import org.eclipse.papyrus.diagram.common.editparts.UMLConnectionNodeEditPart;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;

/**
 * this a abstract editpart use to add listeners
 */
public abstract class AbstractAssociationEditPart extends UMLConnectionNodeEditPart {

	protected static final String ASSOCIATION_END_LISTENERS_SOURCE = "AssociationEndListenersSource";

	protected static final String ASSOCIATION_END_LISTENERS_TARGET = "AssociationEndListenersTarget";

	public AbstractAssociationEditPart(View view) {
		super(view);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
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
				EObject sourceEnd = association.getMemberEnds().get(0);
				EObject targetEnd = association.getMemberEnds().get(1);

				addListenerFilter(ASSOCIATION_END_LISTENERS_SOURCE, this, sourceEnd); //$NON-NLS-1$
				addListenerFilter(ASSOCIATION_END_LISTENERS_TARGET, this, targetEnd); //$NON-NLS-1$
			}
		}
	}

	/**
	 * 
	 * {@inheritDoc}
	 */

	public void deactivate() {
		removeAssociationEndListeners();
		super.deactivate();
	}

	/**
	 * 
	 * {@inheritDoc}
	 */

	protected void handleNotificationEvent(Notification event) {
		super.handleNotificationEvent(event);

		// set the good ends for the association figure
		if(resolveSemanticElement() != null) {

			refreshVisuals();
		}
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	protected void refreshVisuals() {
		if(resolveSemanticElement() != null) {
			if(getSource() == null || getTarget() == null) {
				return;
			}
			if(((GraphicalEditPart)getSource()).resolveSemanticElement() == null || ((GraphicalEditPart)getTarget()).resolveSemanticElement() == null) {
				return;
			}

			Property source = null;
			Property target = null;

			// Get the association
			Element umlElement = getUMLElement();
			if(umlElement instanceof Association) {
				Association association = (Association)getUMLElement();
				assert (association.getMemberEnds().size() >= 2);
				if(association.getMemberEnds() != null && association.getMemberEnds().size() >= 2) {
					if(((Property)(association.getMemberEnds().get(0))).getType().equals(((GraphicalEditPart)getSource()).resolveSemanticElement())) {
						source = ((Property)(association.getMemberEnds().get(0)));
						target = ((Property)(association.getMemberEnds().get(1)));
					} else {
						source = ((Property)(association.getMemberEnds().get(1)));
						target = ((Property)(association.getMemberEnds().get(0)));
					}
					int sourceType = 0;
					int targetType = 0;
					// to display the dot.
					// owned?
					if(!source.getOwner().equals(resolveSemanticElement())) {
						sourceType += AssociationFigure.owned;
						sourceType += AssociationFigure.navigable;
					}
					if(!target.getOwner().equals(resolveSemanticElement())) {
						targetType += AssociationFigure.owned;
						targetType += AssociationFigure.navigable;
					}
					// aggregation? for it the opposite is changed
					if(source.getAggregation() == AggregationKind.SHARED_LITERAL) {
						targetType += AssociationFigure.aggregation;
					}
					if(target.getAggregation() == AggregationKind.SHARED_LITERAL) {
						sourceType += AssociationFigure.aggregation;
					}
					// composite? for it the opposite is changed
					if(source.getAggregation() == AggregationKind.COMPOSITE_LITERAL) {
						targetType += AssociationFigure.composition;
					}
					if(target.getAggregation() == AggregationKind.COMPOSITE_LITERAL) {
						sourceType += AssociationFigure.composition;
					}
					
					// navigable?
					if(association.getNavigableOwnedEnds().contains(source)) {
						sourceType += AssociationFigure.navigable;
					}
					if(association.getNavigableOwnedEnds().contains(target)) {
						targetType += AssociationFigure.navigable;
					}
					if(getPrimaryShape() instanceof AssociationFigure) {
						((AssociationFigure)getPrimaryShape()).setEnd(sourceType, targetType);
					}
				}

			}

		}
		super.refreshVisuals();
	}

	/**
	 * this method is used to remove listener on ends
	 */
	protected void removeAssociationEndListeners() {
		removeListenerFilter(ASSOCIATION_END_LISTENERS_SOURCE);
		removeListenerFilter(ASSOCIATION_END_LISTENERS_TARGET);

	}
}
