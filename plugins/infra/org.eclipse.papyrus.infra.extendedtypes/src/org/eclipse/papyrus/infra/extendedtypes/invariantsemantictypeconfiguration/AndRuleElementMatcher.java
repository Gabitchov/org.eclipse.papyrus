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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;

/**
 * {@link IElementMatcher} for the {@link AndRule}
 */
public class AndRuleElementMatcher implements IConfigurableElementMatcher<AndRule> {

	protected List<IElementMatcher> composedMatchers;

	/**
	 * 
	 */
	public AndRuleElementMatcher() {
		// Nothing here
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean matches(EObject eObject) {
		// deactivate if list of rules is empty 
		if(composedMatchers == null || composedMatchers.isEmpty()) {
			return false;
		}
		for(IElementMatcher matcher : composedMatchers) {
			if(!matcher.matches(eObject)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	public void init(AndRule configuration) {
		// for each children configuraton, generates the matcher class and then, the 'matches' method of this matcher will delegate to the matches of the sub rules, and will add all results together
		// configuration should be a AndRule as declared in the extension point
		composedMatchers = new ArrayList<IElementMatcher>();
		for(InvariantRuleConfiguration composedRule : configuration.getComposedRules()) {
			IElementMatcher matcher = RuleConfigurationFactoryRegistry.getInstance().createMatcher(composedRule);
			if(matcher != null) {
				composedMatchers.add(matcher);
			}
		}
	}
}
