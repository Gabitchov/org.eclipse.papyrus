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

import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;

/**
 * Interface for all {@link IEditHelperAdvice} that are configured by an {@link InvariantRuleConfiguration}.
 */
public interface IConfigurableEditHelperAdvice<T extends InvariantRuleConfiguration> extends IEditHelperAdvice {

	/**
	 * Inits the edit helper advice with its given configuration
	 * 
	 * @param ruleConfiguration the configuration of the edit helper advice
	 */
	void init(T ruleConfiguration);
}
