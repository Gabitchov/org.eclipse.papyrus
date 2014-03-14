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
package org.eclipse.papyrus.sysml.diagram.common.factory; 

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.gmf.diagram.common.factory.ShapeViewFactory;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.sysml.constraints.ConstraintBlock;
import org.eclipse.papyrus.sysml.constraints.ConstraintProperty;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.ConstraintBlockPropertyCompositeEditPart;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.papyrus.uml.diagram.common.utils.UMLGraphicalTypes;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Constraint;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.util.UMLUtil;

public class ConstraintBlockPropertyCompositeClassifierViewFactory extends ShapeViewFactory {

	/**
	 * Creates ConstraintBlockPropertyComposite view and add Label and Compartment nodes
	 */
	@Override
	protected void decorateView(View containerView, View view, IAdaptable element, String semanticHint, int index, boolean persisted) {

		getViewService().createNode(element, view, UMLGraphicalTypes.LABEL_UML_PROPERTY_LABEL_ID, ViewUtil.APPEND, persisted, getPreferencesHint());		
		if (ConstraintBlockPropertyCompositeEditPart.lastRepresentationIsSquareWithStructure()) {
			getViewService().createNode(element, view, SysMLGraphicalTypes.COMPARTMENT_SYSML_BLOCKPROPERTY_STRUCTURE_ID, ViewUtil.APPEND, persisted, getPreferencesHint());
		}

		if (element != null) {
			 EObject newElement = EMFHelper.getEObject(element);
			 if (newElement instanceof Property && UMLUtil.getStereotypeApplication((Property)newElement, ConstraintProperty.class) != null) {
				Property constraintProperty = (Property) newElement;	
				ViewService.createNode(view, getConstraint(constraintProperty), UMLGraphicalTypes.SHAPE_UML_CONSTRAINT_AS_LABEL_ID, getPreferencesHint());
			 }
		}
		
		// this action needs to be done after the compartments creation
		super.decorateView(containerView, view, element, semanticHint, index, persisted);
	}
	
	private Constraint getConstraint(Property constraintProperty) {
		Type type = constraintProperty.getType();
		if (type instanceof Class && UMLUtil.getStereotypeApplication(type, ConstraintBlock.class) != null) { // instanceof ensure type is not null
			Class constraintBlock = (Class)type;
			EList<Constraint> ownedRules = constraintBlock.getOwnedRules();
			for (Constraint constraint : ownedRules) {
				return constraint;
			}
		}
		return null;
	}

	// Start of user code preferences	
	// End of user code
}
