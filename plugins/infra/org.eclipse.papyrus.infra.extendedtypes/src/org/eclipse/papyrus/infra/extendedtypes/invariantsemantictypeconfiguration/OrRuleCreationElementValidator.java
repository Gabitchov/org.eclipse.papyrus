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

import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;


/**
 * @author RS211865
 */
public class OrRuleCreationElementValidator implements IInvariantCreationElementValidator<OrRule> {

	protected List<IInvariantCreationElementValidator<InvariantRuleConfiguration>> composedValidators;

	/**
	 * {@inheritDoc}
	 */
	public boolean canCreate(CreateElementRequest request) {
		for(IInvariantCreationElementValidator<InvariantRuleConfiguration> creationElementValidator : composedValidators) {
			if(creationElementValidator.canCreate(request)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public void init(OrRule configuration) {
		composedValidators = new ArrayList<IInvariantCreationElementValidator<InvariantRuleConfiguration>>();
		for(InvariantRuleConfiguration composedRule : configuration.getComposedRules()) {
			IInvariantCreationElementValidator<InvariantRuleConfiguration> creationElementValidator = RuleConfigurationFactoryRegistry.getInstance().createCreationElementValidator(composedRule);
			if(creationElementValidator != null) {
				composedValidators.add(creationElementValidator);
			}
		}
	}
}
