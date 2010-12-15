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
import org.eclipse.papyrus.sysml.constraints.ConstraintBlock;
import org.eclipse.papyrus.sysml.service.types.utils.ElementUtil;

/**
 * Test if current Class is a ConstraintBlock
 */
public class ConstraintBlockMatcher implements IElementMatcher {

	public boolean matches(EObject eObject) {

		boolean isMatch = false;
		if(eObject instanceof org.eclipse.uml2.uml.Class) {

			org.eclipse.uml2.uml.Class element = (org.eclipse.uml2.uml.Class)eObject;
			if(ElementUtil.getStereotypeApplication(element, ConstraintBlock.class) != null) {
				isMatch = true;
			}
		}
		return isMatch;
	}

}
