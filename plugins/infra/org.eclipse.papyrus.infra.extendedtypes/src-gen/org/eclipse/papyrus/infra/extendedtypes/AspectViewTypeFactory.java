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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gmf.runtime.emf.type.core.IContainerDescriptor;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;
import org.eclipse.gmf.runtime.emf.type.core.NullElementMatcher;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.papyrus.infra.extendedtypes.types.IExtendedHintedElementType;


/**
 * @author RS211865
 */
public class AspectViewTypeFactory extends AbstractConfigurableElementTypeFactory<AspectViewTypeConfiguration> {

	/**
	 * Default Constructor
	 */
	public AspectViewTypeFactory() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected IEditHelperAdvice createEditHelperAdvice(AspectViewTypeConfiguration configuration) {
//		List<SemanticActionConfiguration> semanticActionConfigurations = configuration.getActionConfiguration();
//		List<IEditHelperAdvice> actionAdvices = new ArrayList<IEditHelperAdvice>(semanticActionConfigurations.size()); 
//		for(SemanticActionConfiguration actionConfiguration : semanticActionConfigurations) {
//			IEditHelperAdvice advice = AspectConfigurationFactoryRegistry.getInstance().createEditHelperAdvice(actionConfiguration);
//			if(advice!=null) {
//				actionAdvices.add(advice);
////			} else {
////				Activator.log.error("Impossible to create an advice for :" + actionConfiguration, null);
//			}
//		}
//		if(actionAdvices!=null && actionAdvices.size() > 0) {
//			return new ComposedEditHelperAdvice(actionAdvices);
//		}
		return new AbstractEditHelperAdvice() {
			
		};
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected IContainerDescriptor createContainerDescriptor(AspectViewTypeConfiguration configuration) {
//		List<SemanticActionConfiguration> semanticActionConfigurations = configuration.getActionConfiguration();
//		List<IContainerDescriptor> containerDescriptors = new ArrayList<IContainerDescriptor>(semanticActionConfigurations.size()); 
//		for(SemanticActionConfiguration actionConfiguration : semanticActionConfigurations) {
//			IContainerDescriptor containerDescriptor = AspectConfigurationFactoryRegistry.getInstance().createContainerDescriptor(actionConfiguration);
//			if(containerDescriptor!=null) {
//				containerDescriptors.add(containerDescriptor);
////			} else {
////				Activator.log.error("Impossible to create a container descriptor for :" + actionConfiguration, null);
//			}
//		}
//		if(containerDescriptors!=null && containerDescriptors.size() > 0) {
//			return new ComposedContainerDescriptor(containerDescriptors);
//		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ICreationElementValidator createElementCreationValidator(AspectViewTypeConfiguration configuration) {
//		List<SemanticActionConfiguration> semanticActionConfigurations = configuration.getActionConfiguration();
//		List<ICreationElementValidator> actionValidators = new ArrayList<ICreationElementValidator>(semanticActionConfigurations.size()); 
//		for(SemanticActionConfiguration actionConfiguration : semanticActionConfigurations) {
//			ICreationElementValidator validator = AspectConfigurationFactoryRegistry.getInstance().createCreationElementValidator(actionConfiguration);
//			if(validator!=null) {
//				actionValidators.add(validator);
////			} else {
////				Activator.log.error("Impossible to create a creation element validator for :" + actionConfiguration, null);
//			}
//		}
//		if(actionValidators!=null && actionValidators.size() > 0) {
//			return new ComposedElementCreationValidator(actionValidators);
//		}
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected IElementMatcher createElementMatcher(AspectViewTypeConfiguration configuration) {
		// these element types are there only for creation => it can not be match at any time
		return new NullElementMatcher();
	}
}
