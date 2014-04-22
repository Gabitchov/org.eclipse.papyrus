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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Adapted code from Class Diagram
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.profile.custom.edit.parts;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.profile.custom.helper.AssociationEndTargetLabelHelper;
import org.eclipse.papyrus.uml.diagram.profile.edit.parts.AssociationRoleSourceEditPart;
import org.eclipse.ui.views.properties.IPropertySource;


/**
 * The Class AssociationEndSourceEditPart.
 * Ensure the edition of ends in the diagram
 */
public class AssociationEndSourceEditPart extends AssociationRoleSourceEditPart {

	/**
	 * Instantiates a new association end source edit part.
	 * 
	 * @param view
	 *        the view
	 */
	public AssociationEndSourceEditPart(View view) {
		super(view);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart#resolveSemanticElement()
	 * 
	 * @return
	 */

	@Override
	public EObject resolveSemanticElement() {
		return AssociationEndTargetLabelHelper.getInstance().getUMLElement(this);
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart#getAdapter(java.lang.Class)
	 * 
	 * @param key
	 * @return
	 */
	
	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Class key) {
		if(key == IPropertySource.class) {
			return resolveSemanticElement();
		}
		return super.getAdapter(key);
	}
}
