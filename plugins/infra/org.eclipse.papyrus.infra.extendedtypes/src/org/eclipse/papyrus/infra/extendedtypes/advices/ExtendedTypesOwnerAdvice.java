/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.extendedtypes.advices;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.infra.extendedtypes.Activator;
import org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.PostActionConfiguration;
import org.eclipse.papyrus.infra.extendedtypes.providers.ExtendedElementTypeActionService;
import org.eclipse.papyrus.infra.extendedtypes.providers.ProviderNotFoundException;
import org.eclipse.papyrus.infra.extendedtypes.types.IExtendedHintedElementType;
import org.eclipse.papyrus.infra.queries.core.configuration.QueryConfiguration;
import org.eclipse.papyrus.infra.queries.core.modisco.QueryUtil;


/**
 * Advice for potential owners of Extended Element Types. This advice will help to the pre/post validation for the creation of child element which is
 * describe by the extended type
 */
public class ExtendedTypesOwnerAdvice extends AbstractEditHelperAdvice {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getBeforeCreateCommand(CreateElementRequest request) {
		// test if the type element to be created is an extended one. If yes, test the validation queries. 
		// if they are valid, return identity command, which does nothing
		// else, if not valid, return a not executable command
		IElementType typeToCreate = request.getElementType();
		if(typeToCreate instanceof IExtendedHintedElementType) {
			ExtendedElementTypeConfiguration configuration = ((IExtendedHintedElementType)typeToCreate).getConfiguration();
			List<QueryConfiguration> queryConfigurations = configuration.getPreValidation();
			if(queryConfigurations == null || queryConfigurations.isEmpty()) {
				return super.getBeforeCreateCommand(request);
			}

			// check all validation rules given by the configuration
//			for(Object objectToEdit : request.getElementsToEdit()) {
//				// there are queries to test
//				for(QueryConfiguration queryConfiguration : queryConfigurations) {
//					try {
//					//	boolean result = QueryUtil.evaluateBooleanQuery((EObject)objectToEdit, queryConfiguration);
//					//	if(!result) {
//							// return an unexecutable command, so the create command will not be executable
//							return UnexecutableCommand.INSTANCE;
//						}
//					} catch (Exception e) {
//						Activator.log.error(e);
//					}
//				}
//			}

			// Check all pre and post action validation rules. They are given by the provider of the action
			CompositeCommand compositeCommand = new CompositeCommand("PreValidationPostAction");
			for(PostActionConfiguration postActionConfiguration : configuration.getPostAction()) {
				ICommand command = null;
				try {
					command = ExtendedElementTypeActionService.getInstance().getPreValidationCommand(request.getElementsToEdit(), postActionConfiguration);
				} catch (ProviderNotFoundException e) {
					Activator.log.error(e);
				}
				if(command != null) {
					compositeCommand.add(command);
				}
			}
			// get the super command
			ICommand superCommand = super.getBeforeCreateCommand(request);

			// if not null, adds it to the result
			if(superCommand != null) {
				compositeCommand.compose(superCommand);
			}

			// if result not null, returns the composite command
			if(!compositeCommand.isEmpty()) {
				return compositeCommand;
			}
			return super.getBeforeCreateCommand(request);
		}
		return super.getBeforeCreateCommand(request);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getBeforeConfigureCommand(ConfigureRequest request) {
		return super.getBeforeConfigureCommand(request);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getAfterConfigureCommand(ConfigureRequest request) {
		//		IElementType type = request.getTypeToConfigure();
		//		if(type instanceof IExtendedHintedElementType) {
		//			CompositeCommand compositeCommand = new CompositeCommand("AfterConfigureCommand");
		//			IExtendedHintedElementType extendedHintedElementType = (IExtendedHintedElementType)type;
		//			ExtendedElementTypeConfiguration configuration = extendedHintedElementType.getConfiguration();
		//			for(PostActionConfiguration postActionConfiguration : configuration.getPostAction()) {
		//				ICommand command = null;
		//				try {
		//					command = ExtendedElementTypeActionService.getInstance().getICommand(request.getElementsToEdit(), postActionConfiguration);
		//				} catch (ProviderNotFoundException e) {
		//					Activator.log.error(e);
		//				}
		//				if(command != null) {
		//					compositeCommand.add(command);
		//				}
		//			}
		//			// return the composite command only if it is not empty
		//			if(!compositeCommand.isEmpty()) {
		//				return compositeCommand;
		//			}
		//		}
		return super.getAfterConfigureCommand(request);
	}
}
