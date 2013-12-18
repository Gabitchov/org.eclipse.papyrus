/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.extendedtypes;

import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.GetEditContextRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.papyrus.infra.extendedtypes.providers.ExtendedElementTypeActionService;
import org.eclipse.papyrus.infra.extendedtypes.providers.ProviderNotFoundException;
import org.eclipse.papyrus.infra.extendedtypes.types.IExtendedHintedElementType;

/**
 * Edit helper Advice for extended element types. This allows modification of the configure request executed right after the creation of the element
 */
public class ExtendedEditHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * Constructor.
	 * 
	 */
	public ExtendedEditHelperAdvice() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean approveRequest(IEditCommandRequest request) {
		return super.approveRequest(request);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getBeforeEditContextCommand(GetEditContextRequest request) {
		return super.getBeforeEditContextCommand(request);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getBeforeCreateCommand(CreateElementRequest request) {
		return super.getBeforeCreateCommand(request);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getAfterConfigureCommand(ConfigureRequest request) {
		// for the list of post actions, returns a list of commands.
		// there should be a factory that delivers commands from the model

		CompositeCommand compositeCommand = new CompositeCommand("AfterConfigureCommand");
		IElementType type = request.getTypeToConfigure();
		if(type instanceof IExtendedHintedElementType) {
			IExtendedHintedElementType extendedHintedElementType = (IExtendedHintedElementType)type;
			ExtendedElementTypeConfiguration configuration = extendedHintedElementType.getConfiguration();
			for(PostActionConfiguration postActionConfiguration : configuration.getPostAction()) {
				ICommand command = null;
				try {
					command = ExtendedElementTypeActionService.getInstance().getICommand(request.getElementsToEdit(), postActionConfiguration);
				} catch (ProviderNotFoundException e) {
					Activator.log.error(e);
				}
				if(command != null) {
					compositeCommand.add(command);
				}
			}

			// return the composite command only if it is not empty
			if(!compositeCommand.isEmpty()) {
				return compositeCommand;
			}
		}


		// post-action. Here, this is null.
		return super.getAfterConfigureCommand(request);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getAfterCreateCommand(CreateElementRequest request) {
		return super.getAfterCreateCommand(request);
	}


}
