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
package org.eclipse.papyrus.uml.service.types.helper;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.ConfigureElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.papyrus.uml.service.types.command.ConnectorReorientCommand;
import org.eclipse.papyrus.uml.service.types.utils.RequestParameterConstants;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * Edit helper class for binary {@link Connector}
 */
public class ConnectorEditHelper extends ElementEditHelper {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		return new ConnectorReorientCommand(req);
	}

	/**
	 * This method provides the source role provided as {@link ConfigureRequest} parameter.
	 * 
	 * @return the target role
	 */
	private ConnectableElement getSourceRole(ConfigureRequest req) {
		ConnectableElement result = null;
		Object paramObject = req.getParameter(CreateRelationshipRequest.SOURCE);
		if (paramObject instanceof ConnectableElement) {
			result = (ConnectableElement) paramObject;
		}

		return result;
	}
	
	/**
	 * This method provides the target role provided as {@link ConfigureRequest} parameter.
	 * 
	 * @return the target role
	 */
	private ConnectableElement getTargetRole(ConfigureRequest req) {
		ConnectableElement result = null;
		Object paramObject = req.getParameter(CreateRelationshipRequest.TARGET);
		if (paramObject instanceof ConnectableElement) {
			result = (ConnectableElement) paramObject;
		}

		return result;
	}
	
	/**
	 * This method provides the source partWithPort provided as {@link ConfigureRequest} parameter.
	 * 
	 * @return the target partWithPort
	 */
	private Property getSourcePartWithPort(ConfigureRequest req) {
		Property result = null;
		Object paramObject = req.getParameter(RequestParameterConstants.CONNECTOR_CREATE_REQUEST_SOURCE_PARENT);
		if ((paramObject instanceof Property) && !(paramObject instanceof Port)) {
			result = (Property) paramObject;
		}

		return result;
	}
	
	/**
	 * This method provides the target partWithPort provided as {@link ConfigureRequest} parameter.
	 * 
	 * @return the target partWithPort
	 */
	private Property getTargetPartWithPort(ConfigureRequest req) {
		Property result = null;
		Object paramObject = req.getParameter(RequestParameterConstants.CONNECTOR_CREATE_REQUEST_TARGET_PARENT);
		if ((paramObject instanceof Property) && !(paramObject instanceof Port)) {
			result = (Property) paramObject;
		}

		return result;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getConfigureCommand(final ConfigureRequest req) {
		
		final Connector connector = (Connector)req.getElementToConfigure();
		final ConnectableElement sourceRole = getSourceRole(req);
		final ConnectableElement targetRole = getTargetRole(req);
		final Property sourcePartWithPort = getSourcePartWithPort(req);
		final Property targetPartWithPort = getTargetPartWithPort(req);
		
		if ((sourceRole == null) || (targetRole == null)) {
			return UnexecutableCommand.INSTANCE;
		}
		
		if ((sourcePartWithPort == null) && (targetPartWithPort == null)) {
			return UnexecutableCommand.INSTANCE;
		}
		
		ICommand configureCommand = new ConfigureElementCommand(req) {

			protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
					
				// Add source connector end
				ConnectorEnd sourceEnd = UMLFactory.eINSTANCE.createConnectorEnd();
				sourceEnd.setLower(1);
				sourceEnd.setUpper(1);
				sourceEnd.setRole(sourceRole);
				sourceEnd.setPartWithPort(sourcePartWithPort);

				// Add target connector end
				ConnectorEnd targetEnd = UMLFactory.eINSTANCE.createConnectorEnd();
				targetEnd.setLower(1);
				targetEnd.setUpper(1);
				targetEnd.setRole(targetRole);
				targetEnd.setPartWithPort(targetPartWithPort);

				connector.getEnds().add(sourceEnd);
				connector.getEnds().add(targetEnd);
				
				return CommandResult.newOKCommandResult(connector);
			}
		};
		
		return CompositeCommand.compose(configureCommand, super.getConfigureCommand(req));
	}
	
//	/**
//	 * {@inheritDoc}
//	 */
//	@Override
//	protected ICommand getDestroyReferenceCommand(DestroyReferenceRequest req) {
//
//		ICommand command = super.getDestroyReferenceCommand(req);
//
//		Dependency elementToEdit = (Dependency)req.getContainer();
//		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(elementToEdit.eContainer());
//		if(provider == null) {
//			return command;
//		}
//
//		boolean shouldDestroyDependency = false;
//		if(getSourceReference().equals(req.getContainingFeature()) && (elementToEdit.getClients().size() == 1)) {
//			shouldDestroyDependency = true;
//		}
//
//		if(getTargetReference().equals(req.getContainingFeature()) && (elementToEdit.getSuppliers().size() == 1)) {
//			shouldDestroyDependency = true;
//		}
//
//		if(shouldDestroyDependency) {
//			DestroyElementRequest destroyRequest = new DestroyElementRequest(elementToEdit, false);
//			command = provider.getEditCommand(destroyRequest);
//		}
//
//		return command;
//	}

//	/**
//	 * {@inheritDoc}
//	 */
//	@Override
//	protected ICommand getSetCommand(SetRequest req) {
//
//		// If sources or targets are set with an empty list, the dependency 
//		// should be destroyed.
//		if(getSourceReference().equals(req.getFeature()) || getTargetReference().equals(req.getFeature())) {
//
//			Object values = req.getValue();
//			if((values != null) && (values instanceof EList) && ((EList<?>)values).isEmpty()) {
//
//				// Get dependency destroy command from Element Edit Service
//				IElementEditService provider = ElementEditServiceUtils.getCommandProvider(req.getElementToEdit());
//				if(provider != null) {
//					DestroyElementRequest destroyRequest = new DestroyElementRequest(req.getElementToEdit(), false);
//					ICommand destroyCommand = provider.getEditCommand(destroyRequest);
//					return destroyCommand;
//				}
//			}
//		}
//
//		return super.getSetCommand(req);
//	}
}
