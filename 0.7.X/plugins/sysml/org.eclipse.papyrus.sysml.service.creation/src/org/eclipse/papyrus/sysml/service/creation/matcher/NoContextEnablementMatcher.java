/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.service.creation.matcher;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;

/**
 * This matcher is used to always disable the context where the semantic
 * creation service are defined.
 * This means the the creation service requires to be called which explicit
 * context specification.
 * 
 */
public class NoContextEnablementMatcher implements IElementMatcher {

	public boolean matches(EObject eObject) {
		return false;
	}

}
