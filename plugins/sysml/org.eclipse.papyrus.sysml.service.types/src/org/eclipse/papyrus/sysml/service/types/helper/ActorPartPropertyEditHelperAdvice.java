/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.service.types.helper;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementMatcher;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.GetEditContextRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.papyrus.sysml.blocks.Block;
import org.eclipse.papyrus.sysml.service.types.matcher.BlockMatcher;
import org.eclipse.papyrus.uml.service.types.utils.NamedElementHelper;
import org.eclipse.uml2.uml.AggregationKind;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Property;

/** SysML Property ActorPart edit helper advice */
public class ActorPartPropertyEditHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * Check if the creation context is a {@link Block}.
	 * 
	 * @see org.eclipse.papyrus.sysml.service.types.helper.AbstractStereotypedElementEditHelperAdvice#approveRequest(org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest)
	 * 
	 * @param request
	 * @return true if the request is approved
	 */
	@Override
	public boolean approveRequest(IEditCommandRequest request) {
		boolean isApproved = super.approveRequest(request);

		if((request != null) && (request instanceof GetEditContextRequest)) {

			// Retrieve the edit context from request
			GetEditContextRequest editContextRequest = (GetEditContextRequest)request;

			// Test if the edit context is a Block
			if(editContextRequest.getEditContext() instanceof Element) {
				Element contextElement = (Element)editContextRequest.getEditContext();

				IElementMatcher matcher = new BlockMatcher();
				if(!matcher.matches(contextElement)) {
					isApproved = false;
				}
			}
		}

		return isApproved;
	}

	/** Complete creation process by setting name and default aggregation */
	@Override
	protected ICommand getBeforeConfigureCommand(final ConfigureRequest request) {

		return new ConfigureElementCommand(request) {

			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
				Property element = (Property)request.getElementToConfigure();
				if(element != null) {

					// Set default name
					String initializedName = NamedElementHelper.getDefaultNameWithIncrementFromBase("actorPart", element.eContainer().eContents()); //$NON-NLS-1$
					element.setName(initializedName);
					// Initialize the aggregation to composite.
					element.setAggregation(AggregationKind.COMPOSITE_LITERAL);
				}
				return CommandResult.newOKCommandResult(element);
			}
		};
	}
}
