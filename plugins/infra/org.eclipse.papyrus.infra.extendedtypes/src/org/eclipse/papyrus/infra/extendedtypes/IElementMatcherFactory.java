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
import org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration.IConfigurableElementMatcher;


/**
 * interface for factories that instantiate {@link IConfigurableElementMatcher} with their given configuration
 */
public interface IElementMatcherFactory<T extends MatcherConfiguration> {
	
	/**
	 * Creates an element matcher with the specified configuration
	 * @param configuration the configuration of the {@link IElementMatcher}
	 * @return the created element matcher or <code>null</code> if none was created
	 */
	public IElementMatcher createElementMatcher(T configuration); 
}
