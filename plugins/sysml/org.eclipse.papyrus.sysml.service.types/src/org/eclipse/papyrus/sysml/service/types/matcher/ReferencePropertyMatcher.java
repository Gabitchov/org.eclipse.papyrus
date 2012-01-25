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
import org.eclipse.papyrus.sysml.blocks.Block;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Test if current {@link Property} is a {@link Block} Reference
 */
public class ReferencePropertyMatcher implements IElementMatcher {

	/**
	 * {@inheritDoc}
	 */
	public boolean matches(EObject eObject) {

		boolean isMatch = false;
		if((eObject instanceof Property) && !(eObject instanceof Port)) {

			Property element = (Property)eObject;
			
			// The property is not a composition and has a type
			if ((element.getType() != null) && (element.getAggregation() != AggregationKind.COMPOSITE_LITERAL)) {
				
				// Moreover its type has to be a Block
				if(UMLUtil.getStereotypeApplication(element.getType(), Block.class) != null) {
					isMatch = true;
				}
			}
		}
		return isMatch;
	}

}
