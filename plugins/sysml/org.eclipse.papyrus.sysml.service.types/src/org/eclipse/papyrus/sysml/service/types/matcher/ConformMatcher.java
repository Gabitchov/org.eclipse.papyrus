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
import org.eclipse.papyrus.sysml.modelelements.Conform;
import org.eclipse.papyrus.sysml.service.types.utils.ElementUtil;
import org.eclipse.uml2.uml.Dependency;

/**
 * Test if current {@link Dependency} is a {@link Conform}
 */
public class ConformMatcher implements IElementMatcher {

	public boolean matches(EObject eObject) {

		boolean isMatch = false;
		if(eObject instanceof Dependency) {

			Dependency element = (Dependency)eObject;
			if(ElementUtil.getStereotypeApplication(element, Conform.class) != null) {
				isMatch = true;
			}
		}
		return isMatch;
	}

}
