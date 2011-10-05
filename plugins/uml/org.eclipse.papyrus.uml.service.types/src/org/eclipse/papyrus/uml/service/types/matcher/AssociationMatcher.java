/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.matcher;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.eclipse.papyrus.uml.service.types.utils.ElementUtil;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Element;

/**
 * <pre>
 * Test if current {@link Association} has the UML nature.
 * This nature is used to:
 * - distinguish between UML and SysML expected behavior for {@link Association}.
 * - decide whether and {@link Association} can be dropped and used in a specific diagram.
 * - select the property view to use.
 * 
 * Existing Associations (created in previous Papyrus version and which have no nature set)
 * are treated as UML Associations.
 * </pre>
 */
public class AssociationMatcher implements IElementMatcher {

	public boolean matches(EObject eObject) {

		boolean isMatch = false;

		if (eObject instanceof Association) {
		
			Association association = (Association) eObject;
			if (hasValidNature(association) || hasNoNature(association)) {
				isMatch = true;
			}
		}
		
		return isMatch;
	}
	
	private boolean hasValidNature(Element element) {
		return ElementUtil.hasNature(element, UMLElementTypes.UML_NATURE);
	}
	
	private boolean hasNoNature(Element element) {
		return (ElementUtil.getNature(element) == null);
	}
}
