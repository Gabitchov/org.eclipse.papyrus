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
package org.eclipse.papyrus.uml.diagram.clazz.custom.edit.part;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.clazz.edit.parts.AssociationSourceNameEditPart;
import org.eclipse.papyrus.uml.diagram.common.helper.AssociationEndSourceLabelHelper;
import org.eclipse.ui.views.properties.IPropertySource;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * The Class AssociationEndTargetEditPart.
 * Ensure the edition of ends in the diagram
 */
public class AssociationEndTargetEditPart extends AssociationSourceNameEditPart {

	/**
	 * Instantiates a new association end target edit part.
	 * 
	 * @param view
	 *            the view
	 */
	public AssociationEndTargetEditPart(View view) {
		super(view);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void handleNotificationEvent(Notification event) {
		if (UMLPackage.Literals.FEATURE__IS_STATIC.equals(event.getFeature())) {
			refreshUnderline();
		}
		super.handleNotificationEvent(event);
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#resolveSemanticElement()
	 * 
	 * @return
	 */
	public EObject resolveSemanticElement() {
		return AssociationEndSourceLabelHelper.getInstance().getUMLElement(this);
	}

	public Object getAdapter(@SuppressWarnings("rawtypes") Class key) {
		if (key == IPropertySource.class) {
			return resolveSemanticElement();
		}
		return super.getAdapter(key);
	}
}
