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
package org.eclipse.papyrus.infra.extendedtypes.invariantsemantictypeconfiguration;

import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;


/**
 * Interface that all {@link IElementMatcher} that can be configured at runtime using a model should implement
 */
public interface IConfigurableElementMatcher<T extends InvariantRuleConfiguration> extends IElementMatcher {
	
	/**
	 * Initialize the element matcher with the given configuration
	 * @param configuration the runtime configuration of the matcher 
	 */
	void init(T configuration);
}
