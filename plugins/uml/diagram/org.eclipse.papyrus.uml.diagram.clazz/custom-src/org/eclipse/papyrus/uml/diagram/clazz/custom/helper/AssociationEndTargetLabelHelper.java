/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.custom.helper;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.helper.PropertyLabelHelper;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Property;

/**
 * Helper for labels displaying {@link Property}
 */
public class AssociationEndTargetLabelHelper extends PropertyLabelHelper {

	private static AssociationEndTargetLabelHelper labelHelper;

	public static AssociationEndTargetLabelHelper getInstance() {
		if(labelHelper == null) {
			labelHelper = new AssociationEndTargetLabelHelper();
		}
		return labelHelper;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Property getUMLElement(GraphicalEditPart editPart) {
		if((View)editPart.getModel() != null && ((View)editPart.getModel()).eContainer() != null) {
			EObject container = ((View)editPart.getModel()).eContainer();
			if(!(container instanceof Edge)) {
				return null; //Happens e.g. when redoing the suppression of an association's end. The association is contained in a ChangeDescription
			}
			if(((Edge)((View)editPart.getModel()).eContainer()).getTarget() == null) {
				return null;
			}
			Classifier target = (Classifier)((Edge)((View)editPart.getModel()).eContainer()).getTarget().getElement();
			Property propertyToDisplay = null;
			if(((View)editPart.getModel()) != null && (((View)editPart.getModel()).getElement() instanceof Association)) {
				// look for the property that is typed by the classifier
				Iterator<Property> propertiesIterator = ((Association)((View)editPart.getModel()).getElement()).getMemberEnds().iterator();
				//find the last
				while(propertiesIterator.hasNext()) {
					Property currentProperty = propertiesIterator.next();
					if(EcoreUtil.equals(currentProperty.getType(), target)) {
						propertyToDisplay = currentProperty;
					}
				}
			}
			if(propertyToDisplay != null) {
				return propertyToDisplay;
			}
			///in the case of reorient the property must be not found,
			// so we have to find the property that is different from the source.
			Classifier source = (Classifier)((Edge)((View)editPart.getModel()).eContainer()).getSource().getElement();
			if(((View)editPart.getModel()) != null && (((View)editPart.getModel()).getElement() instanceof Association)) {
				// look for the property that is typed by the classifier
				Iterator<Property> propertiesIterator = ((Association)((View)editPart.getModel()).getElement()).getMemberEnds().iterator();
				//find the last
				while(propertiesIterator.hasNext()) {
					Property currentProperty = propertiesIterator.next();
					if(!EcoreUtil.equals(currentProperty.getType(), source)) {
						propertyToDisplay = currentProperty;
					}
				}
			}
			return propertyToDisplay;
		}
		return null;
	}
}
