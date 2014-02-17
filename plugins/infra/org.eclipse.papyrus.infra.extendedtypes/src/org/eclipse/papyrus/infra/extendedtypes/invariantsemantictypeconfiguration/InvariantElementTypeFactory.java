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

import java.util.Arrays;
import java.util.Collections;

import org.eclipse.gmf.runtime.emf.type.core.IContainerDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.papyrus.infra.extendedtypes.AbstractConfigurableElementTypeFactory;
import org.eclipse.papyrus.infra.extendedtypes.ComposedElementMatcher;
import org.eclipse.papyrus.infra.extendedtypes.ICreationElementValidator;

/**
 * Factory used to create ElementType from a {@link InvariantSemanticTypeConfiguration}.
 */
public class InvariantElementTypeFactory extends AbstractConfigurableElementTypeFactory<InvariantSemanticTypeConfiguration> {

	/**
	 * {@inheritDoc}
	 */
	public ICreationElementValidator createElementCreationValidator(InvariantSemanticTypeConfiguration configuration) {
		return RuleConfigurationFactoryRegistry.getInstance().createCreationElementValidator(configuration.getInvariantRuleConfiguration());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String getSemanticHint(InvariantSemanticTypeConfiguration configuration) {
		return configuration.getHint();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected IEditHelperAdvice createEditHelperAdvice(InvariantSemanticTypeConfiguration configuration) {
		return RuleConfigurationFactoryRegistry.getInstance().createEditHelperAdvice(configuration.getInvariantRuleConfiguration());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected IContainerDescriptor createContainerDescriptor(InvariantSemanticTypeConfiguration configuration) {
		return  RuleConfigurationFactoryRegistry.getInstance().createContainerDescriptor(configuration.getInvariantRuleConfiguration());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected IElementMatcher createElementMatcher(InvariantSemanticTypeConfiguration configuration) {
		IElementMatcher superMatcher = super.createElementMatcher(configuration);
		if(superMatcher !=null)  {
			// create a composed matcher to have the matcher described by the model configuration element type and the one for the specific invariants
			IElementMatcher invariantMatcher = RuleConfigurationFactoryRegistry.getInstance().createMatcher(configuration.getInvariantRuleConfiguration());
			if(invariantMatcher!=null) {
				ComposedElementMatcher composedMatcher = new ComposedElementMatcher(Arrays.asList(superMatcher, invariantMatcher));
				return composedMatcher;	
			}
			return superMatcher;
		}
		// no configured matcher. Return the invariant one
		return RuleConfigurationFactoryRegistry.getInstance().createMatcher(configuration.getInvariantRuleConfiguration());
	}
	
}
