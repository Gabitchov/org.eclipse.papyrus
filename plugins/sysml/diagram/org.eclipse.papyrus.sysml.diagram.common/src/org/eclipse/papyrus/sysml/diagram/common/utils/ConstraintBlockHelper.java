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
package org.eclipse.papyrus.sysml.diagram.common.utils;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.constraints.ConstraintBlock;
import org.eclipse.papyrus.sysml.constraints.ConstraintProperty;
import org.eclipse.papyrus.uml.diagram.common.helper.ElementHelper;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.util.UMLUtil;

public class ConstraintBlockHelper extends ElementHelper {

	public static boolean couldBeConstraintParameter(EObject possibleContraintParameter, EObject ownerConstraintBlock) {
		if (!(ownerConstraintBlock instanceof org.eclipse.uml2.uml.Class && UMLUtil.getStereotypeApplication((Element)ownerConstraintBlock, ConstraintBlock.class) != null)) {
			return false;
		}
		return UMLUtil.getStereotypeApplication((Element)possibleContraintParameter, ConstraintProperty.class) == null;
	}
	
	public static boolean isConstraintParameter(Element element, View view) {
		if (element instanceof Property) {
			Property constraintProperty = (Property) element;
			Element ownerConstraintBlock = constraintProperty.getOwner();
			if (ownerConstraintBlock instanceof org.eclipse.uml2.uml.Class && UMLUtil.getStereotypeApplication(ownerConstraintBlock, ConstraintBlock.class) != null) {
				// check for graphics : owned by a constraintProperty
				if (view != null) {
					View containerView = ViewUtil.getContainerView(view);
					Element containerElement = (Element)containerView.getElement();
					// Owned by a ConstraintProperty
					if (containerElement instanceof Property 
							&& UMLUtil.getStereotypeApplication(containerElement, ConstraintProperty.class) != null 
							&& ((Property)containerElement).getType() == ownerConstraintBlock) { 
						return true;
					}
					// Owned by a ConstraintBlock
					if (containerElement instanceof org.eclipse.uml2.uml.Class 
							&& UMLUtil.getStereotypeApplication(containerElement, ConstraintBlock.class) != null 
							&& containerElement == ownerConstraintBlock) { 
						return true;
					}
				}
			}
		}
		return false;
	}
	
}
