/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.extendedtypes;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;


/**
 * @author RS211865
 */
public class ComposedElementMatcher implements IElementMatcher {

	private final List<IElementMatcher> matchers;
	
	public ComposedElementMatcher(List<IElementMatcher> matchers) {
		this.matchers = matchers;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public boolean matches(EObject eObject) {
		for(IElementMatcher matcher : getMatchers()) {
			if(!matcher.matches(eObject)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @return the matchers
	 */
	protected List<IElementMatcher> getMatchers() {
		return matchers;
	}
}
