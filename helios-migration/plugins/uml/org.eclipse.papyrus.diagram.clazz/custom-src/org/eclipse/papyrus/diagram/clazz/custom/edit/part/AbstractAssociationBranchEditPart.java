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
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.clazz.custom.figure.AssociationFigure;
import org.eclipse.papyrus.diagram.clazz.custom.helper.MultiAssociationHelper;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Property;

/**
 * this a abstract editpart use to add listeners
 */
public abstract class AbstractAssociationBranchEditPart extends ConnectionNodeEditPart {

	public AbstractAssociationBranchEditPart(View view) {
		super(view);

	}

	/**
	 * {@inheritDoc}
	 */
	public void activate() {
		super.activate();
		addAssociationEndListeners();
	}

	/**
	 * 
	 * add listener
	 */
	protected void addAssociationEndListeners() {
		if(resolveSemanticElement() instanceof Association) {
			Property targetEnd = MultiAssociationHelper.getPropertyToListen(((Edge)getModel()), (Association)resolveSemanticElement());
			if(targetEnd != null) {
				addListenerFilter("AssociationEndListenersTarget", this, targetEnd); //$NON-NLS-1$

			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public void deactivate() {
		removeAssociationEndListeners();
		super.deactivate();

	}

	/**
	 * @generated
	 */
	public abstract AssociationFigure getPrimaryShape();

	/**
	 * 
	 * {@inheritDoc}
	 */

	protected void handleNotificationEvent(Notification event) {
		super.handleNotificationEvent(event);

		// set the good ends for the association figure
		if(((View)getModel()).isSetElement()) {

			refreshVisuals();
		}
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	protected void refreshVisuals() {
		if(resolveSemanticElement() != null) {
			if(resolveSemanticElement() instanceof Association) {
				Property target = MultiAssociationHelper.getPropertyToListen(((Edge)getModel()), (Association)resolveSemanticElement());
				if(target != null && target.getOwner() != null) {
					int sourceType = 0;
					int targetType = 0;
					// owned?
					if(target.getOwner().equals(resolveSemanticElement())) {
						targetType += AssociationFigure.owned;
					}
					// aggregation?
					if(target.getAggregation() == AggregationKind.SHARED_LITERAL) {
						targetType += AssociationFigure.aggregation;
					}
					// composite?
					if(target.getAggregation() == AggregationKind.COMPOSITE_LITERAL) {
						targetType += AssociationFigure.composition;
					}
					// navigable?
					if(target.isNavigable()) {
						targetType += AssociationFigure.navigable;
					}
					getPrimaryShape().setEnd(sourceType, targetType);
				}
			}
		}
		super.refreshVisuals();
	}

	/**
	 * used to remove listeners at the end
	 */
	protected void removeAssociationEndListeners() {
		removeListenerFilter("AssociationEndListenersTarget");

	}

}
