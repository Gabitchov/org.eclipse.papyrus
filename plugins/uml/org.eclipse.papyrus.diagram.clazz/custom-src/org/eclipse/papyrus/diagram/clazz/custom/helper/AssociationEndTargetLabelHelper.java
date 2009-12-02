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
package org.eclipse.papyrus.diagram.clazz.custom.helper;

import java.util.Iterator;

import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.common.helper.PropertyLabelHelper;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Property;

/**
 * Helper for labels displaying {@link Property}
 */
public class AssociationEndTargetLabelHelper extends PropertyLabelHelper {

	private static AssociationEndTargetLabelHelper labelHelper;

	public static AssociationEndTargetLabelHelper getInstance() {
		if (labelHelper == null) {
			labelHelper = new AssociationEndTargetLabelHelper();
		}
		return labelHelper;
	}

	/**
	 * {@inheritDoc}
	 */
	public Property getUMLElement(GraphicalEditPart editPart) {
		if ((View) editPart.getModel() != null && ((View) editPart.getModel()).eContainer() != null) {
			Classifier target = (Classifier) ((Edge) ((View) editPart.getModel()).eContainer()).getTarget()
					.getElement();
			Property propertyToDisplay = null;
			if (((View) editPart.getModel()) != null
					&& (((View) editPart.getModel()).getElement() instanceof Association)) {
				// look for the property that is typed by the classifier

				Iterator<Property> propertiesIterator = ((Association) ((View) editPart.getModel()).getElement())
						.getMemberEnds().iterator();

				//find the last
				while (propertiesIterator.hasNext()) {
					Property currentProperty = (Property) propertiesIterator.next();
					if (currentProperty.getType().equals(target)) {
						propertyToDisplay = currentProperty;
					}
				}

			}
			return propertyToDisplay;
		}
		return null;
	}
}
