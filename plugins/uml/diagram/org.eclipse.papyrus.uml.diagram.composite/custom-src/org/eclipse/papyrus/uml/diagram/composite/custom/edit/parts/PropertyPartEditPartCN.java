/*****************************************************************************
 * Copyright (c) 2009-2011 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.composite.custom.edit.parts;

import org.eclipse.draw2d.Graphics;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.editparts.NamedElementEditPart;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * <pre>
 * This class will be inherited by the GMF generated {@link org.eclipse.papyrus.uml.diagram.composite.edit.parts.PropertyPartEditPartCN}
 * in order to refresh the related figure when when the Property::aggregation eAttribute value 
 * changes.
 * </pre>
 */
public abstract class PropertyPartEditPartCN extends NamedElementEditPart {

	/**
	 * Constructor
	 * 
	 * @param view
	 */
	public PropertyPartEditPartCN(View view) {
		super(view);
	}

	/**
	 * <pre>
	 * Calls the figure refresh when a change event is detected on 
	 * UMLPackage.eINSTANCE.getProperty_Aggregation().
	 * 
	 * {@inheritDoc}
	 * </pre>
	 */
	@Override
	protected void handleNotificationEvent(Notification event) {

		if((resolveSemanticElement() != null) && (resolveSemanticElement().equals(event.getNotifier()))) {
			if(UMLPackage.eINSTANCE.getProperty_Aggregation().equals(event.getFeature())) {
				refreshVisuals();
			}
		}
		super.handleNotificationEvent(event);
	}
	

	/**
	 * <pre>
	 * Refresh the figure with dashed border when Property aggregation value is SHARED.
	 * Else set the border style to solid line.
	 * 
	 * {@inheritDoc}
	 * </pre>
	 */
	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		if((resolveSemanticElement() != null) && (resolveSemanticElement() instanceof Property)) {
			if(((Property)resolveSemanticElement()).getAggregation().equals(AggregationKind.SHARED_LITERAL)) {
				getPrimaryShape().setLineStyle(Graphics.LINE_CUSTOM);
			} else {
				getPrimaryShape().setLineStyle(Graphics.LINE_SOLID);
			}
		}
	}
}
