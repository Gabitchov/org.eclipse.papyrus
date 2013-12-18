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

import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;

public class AndRuleEditHelperAdvice extends AbstractEditHelperAdvice implements IConfigurableEditHelperAdvice<AndRule> {

	protected List<IConfigurableEditHelperAdvice<InvariantRuleConfiguration>> composedEditHelperAdvices;

	public AndRuleEditHelperAdvice() {
	}

	/**
	 * {@inheritDoc}
	 */
	public void init(AndRule ruleConfiguration) {
		// configuration should be a AndRule as declared in the extension point
		composedEditHelperAdvices = new ArrayList<IConfigurableEditHelperAdvice<InvariantRuleConfiguration>>();
		for(InvariantRuleConfiguration composedRule : ruleConfiguration.getComposedRules()) {
			IConfigurableEditHelperAdvice<InvariantRuleConfiguration> editHelperAdvice = RuleConfigurationFactoryRegistry.getInstance().createEditHelperAdvice(composedRule);
			if(editHelperAdvice != null) {
				composedEditHelperAdvices.add(editHelperAdvice);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean approveRequest(IEditCommandRequest request) {
		// to approve the request, all the composed edit helper advices should approve it
		for(IEditHelperAdvice advice : composedEditHelperAdvices) {
			if(!advice.approveRequest(request)) {
				return false;
			}
		}
		return true;
	}
}
