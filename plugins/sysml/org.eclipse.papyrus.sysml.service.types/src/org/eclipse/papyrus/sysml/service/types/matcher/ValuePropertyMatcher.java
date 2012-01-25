/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.service.types.matcher;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;
import org.eclipse.papyrus.sysml.blocks.ValueType;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Test if current {@link Property} is a value.
 */
public class ValuePropertyMatcher implements IElementMatcher {

	/**
	 * {@inheritDoc}
	 */
	public boolean matches(EObject eObject) {

		boolean isMatch = false;
		if((eObject instanceof Property) && !(eObject instanceof Port)) {

			Property element = (Property)eObject;
			
			// The property is necessary a composition and has a type
			if ((element.getType() != null) && (element.getAggregation() == AggregationKind.COMPOSITE_LITERAL)) {
				
				// Moreover its type has either to be a DataType or a ValueType
				if(UMLUtil.getStereotypeApplication(element.getType(), ValueType.class) != null) {
					isMatch = true;
				}
				if(element.getType() instanceof DataType) {
					isMatch = true;
				}
			}
		}
		return isMatch;
	}

}
