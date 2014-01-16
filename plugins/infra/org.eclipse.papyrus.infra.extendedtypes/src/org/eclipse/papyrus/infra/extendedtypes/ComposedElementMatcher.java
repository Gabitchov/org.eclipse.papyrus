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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;


/**
 * @author RS211865
 */
public class ComposedElementMatcher implements IElementMatcher {

	protected final IElementMatcher mainMatcher;
	protected final IElementMatcher composedElementMatcher;
	
	public ComposedElementMatcher(IElementMatcher mainMatcher, IElementMatcher composedElementMatcher) {
		this.composedElementMatcher = composedElementMatcher;
		this.mainMatcher = mainMatcher;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void init(MatcherConfiguration configuration) {
		throw new RuntimeException("Not Expected to be called");
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean matches(EObject eObject) {
		// matches if both matcher matches
		if(mainMatcher!=null) {
			if(!mainMatcher.matches(eObject)) {
				return false;
			}
		}
		if(composedElementMatcher!=null) {
			if(!composedElementMatcher.matches(eObject)) {
				return false;
			}
		}
		return true;
	}
}
