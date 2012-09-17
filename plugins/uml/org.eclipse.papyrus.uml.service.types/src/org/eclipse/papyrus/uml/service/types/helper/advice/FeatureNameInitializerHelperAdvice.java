/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 
 * 		Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.helper.advice;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.papyrus.uml.service.types.utils.NamedElementHelper;
import org.eclipse.uml2.uml.Feature;

/**
 * <pre>
 * This is an advice helper used to initialize {@link Feature}.
 * 
 * In particular the name of such elements is initialized in order 
 * to have a unique name for a specific type of element per {@link Namespace}.
 * 
 * Feature name is lower case by default.
 * 
 * </pre>
 */
public class FeatureNameInitializerHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getBeforeConfigureCommand(final ConfigureRequest request) {
		return new ConfigureElementCommand(request) {

			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {

				Feature element = (Feature)request.getElementToConfigure();

				// Initialize the element name based on the created IElementType
				String initializedName = NamedElementHelper.getDefaultNameWithIncrementFromBase(element.eClass().getName().toLowerCase(), element.eContainer().eContents());
				element.setName(initializedName);

				return CommandResult.newOKCommandResult(element);
			}
		};
	}

}
