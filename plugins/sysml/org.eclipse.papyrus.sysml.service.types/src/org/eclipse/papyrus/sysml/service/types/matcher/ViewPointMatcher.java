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
import org.eclipse.papyrus.sysml.modelelements.ViewPoint;
import org.eclipse.papyrus.sysml.service.types.utils.ElementUtil;
import org.eclipse.uml2.uml.Class;

/**
 * Test if current {@link org.eclipse.uml2.uml.Class} is a {@link ViewPoint}
 */
public class ViewPointMatcher implements IElementMatcher {

	public boolean matches(EObject eObject) {

		boolean isMatch = false;
		if(eObject instanceof Class) {

			Class element = (Class)eObject;
			if(ElementUtil.getStereotypeApplication(element, ViewPoint.class) != null) {
				isMatch = true;
			}
		}
		return isMatch;
	}

}
