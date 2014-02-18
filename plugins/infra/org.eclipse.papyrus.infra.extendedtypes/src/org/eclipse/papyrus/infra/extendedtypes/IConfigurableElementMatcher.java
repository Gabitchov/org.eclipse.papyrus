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

import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;


/**
 * Interface implemented by all element matchers configured by a {@link MatcherConfiguration}
 */
public interface IConfigurableElementMatcher<T extends MatcherConfiguration> extends IElementMatcher {
	
	/**
	 * Inits the element matcher with the given contribution. Should be called once, after element matcher instantiation
	 * @param configuration the configuration of this {@link IElementMatcher}
	 */ 
	// public void init(T configuration);
}
