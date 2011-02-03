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
import org.eclipse.papyrus.sysml.constraints.ConstraintProperty;
import org.eclipse.papyrus.sysml.service.types.utils.ElementUtil;
import org.eclipse.uml2.uml.Property;

/**
 * Test if current {@link Property} is a {@link ConstraintProperty}
 */
public class ConstraintPropertyMatcher implements IElementMatcher {

	public boolean matches(EObject eObject) {

		boolean isMatch = false;
		if(eObject instanceof Property) {

			Property element = (Property) eObject;
			if(ElementUtil.getStereotypeApplication(element, ConstraintProperty.class) != null) {
				isMatch = true;
			}
		}
		return isMatch;
	}

}
