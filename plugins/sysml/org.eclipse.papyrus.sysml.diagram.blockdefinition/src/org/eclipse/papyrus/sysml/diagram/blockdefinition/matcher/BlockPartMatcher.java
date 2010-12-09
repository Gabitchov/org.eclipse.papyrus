/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdefinition.matcher;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;
import org.eclipse.papyrus.sysml.util.SysmlResource;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

/**
 * Test if current Port is a FlowPort with OUT direction
 */
public class BlockPartMatcher implements IElementMatcher {

	public boolean matches(EObject eObject) {

		if(eObject instanceof Property) {
			Property property = (Property)eObject;	
			if (property.getAggregation() == AggregationKind.COMPOSITE_LITERAL) {
				Type propertyType = property.getType();
				if (propertyType.getAppliedStereotype(SysmlResource.VALUE_TYPE_ID) != null) {
					return false;
				}
				return true;
			}
		}
		return false;
	}
}
