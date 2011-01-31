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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
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
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.GetEditContextRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.papyrus.sysml.portandflows.PortandflowsPackage;
import org.eclipse.papyrus.sysml.service.types.matcher.BlockMatcher;
import org.eclipse.papyrus.sysml.service.types.utils.NamedElementHelper;
import org.eclipse.papyrus.sysml.util.SysmlResource;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Stereotype;

/** SysML FlowPort#InOut edit helper advice */
public class FlowPortEditHelperAdvice extends AbstractStereotypedElementEditHelperAdvice {

	/** Default constructor */
	public FlowPortEditHelperAdvice() {
		requiredProfileIDs.add(SysmlResource.PORT_AND_FLOWS_ID);
	}

	/**
	 * Check if the creation context is a Block.
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

	/** Complete creation process by applying the expected stereotype */
	@Override
	protected ICommand getAfterConfigureCommand(final ConfigureRequest request) {

		return new ConfigureElementCommand(request) {

			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {

				Port port = (Port)request.getElementToConfigure();
				if(port != null) {

					// Apply FlowPort stereotype
					Stereotype flowPortStereotype = port.getApplicableStereotype(SysmlResource.FLOW_PORT_ID);

					if(flowPortStereotype != null) {
						port.applyStereotype(flowPortStereotype);
					}

					// Set default name
					// Initialize the element name based on the created IElementType
					String initializedName = NamedElementHelper.EINSTANCE.getNewUMLElementName(port.getOwner(), PortandflowsPackage.eINSTANCE.getFlowPort());
					port.setName(initializedName);
				}

				return CommandResult.newOKCommandResult(port);
			}
		};
	}
}
