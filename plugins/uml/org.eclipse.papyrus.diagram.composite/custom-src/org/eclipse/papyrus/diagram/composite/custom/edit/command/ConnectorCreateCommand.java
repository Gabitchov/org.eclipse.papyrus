/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.composite.custom.edit.command;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.papyrus.diagram.composite.custom.edit.policies.GraphicalNodeEditPolicy;
import org.eclipse.papyrus.diagram.composite.custom.messages.Messages;
import org.eclipse.papyrus.diagram.composite.providers.UMLElementTypes;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * <pre>
 * This class is a custom creation command for Connector.
 * 
 * Difficulties for Connector creation:
 * - differences between semantic (ConnectableEnd) graphical (ConnectableElement) ends of Connector 
 * - requires to know not only the graphical end (Port, Property) but also the graphical parent in case of Port.
 * 
 * The Connector source and target are declared as ConnectorEnd in the GMFGEN model to ensure correct validation,
 * but the real source and target are ConnectableElement.
 * 
 * </pre>
 */
public class ConnectorCreateCommand extends org.eclipse.papyrus.diagram.composite.edit.commands.ConnectorCreateCommand {

	/** Source of Connector (cannot use original due to private visibility) **/
	private final EObject source;

	/** Target of Connector (cannot use original due to private visibility) **/
	private final EObject target;

	/** Graphical parent of Source **/
	protected Property sourcePartWithPort = null;

	/** Graphical parent of Target **/
	protected Property targetPartWithPort = null;

	/**
	 * Constructor of Connector custom creation command
	 * 
	 * @param req
	 *            the creation request
	 * @param source
	 *            the connector source element
	 * @param target
	 *            the connector target element
	 */
	public ConnectorCreateCommand(CreateRelationshipRequest req, EObject source, EObject target) {

		super(req, source, target);
		this.source = source;
		this.target = target;

		// Resolve graphical parents of source and target store in request as Parameters
		// These parameters are added in request by (custom) GraphicalNodeEditPolicy
		if (req.getParameter(GraphicalNodeEditPolicy.CONNECTOR_CREATE_REQUEST_SOURCE_PARENT) instanceof Property) {
			sourcePartWithPort = (Property) req
					.getParameter(GraphicalNodeEditPolicy.CONNECTOR_CREATE_REQUEST_SOURCE_PARENT);
		}
		if (req.getParameter(GraphicalNodeEditPolicy.CONNECTOR_CREATE_REQUEST_TARGET_PARENT) instanceof Property) {
			targetPartWithPort = (Property) req
					.getParameter(GraphicalNodeEditPolicy.CONNECTOR_CREATE_REQUEST_TARGET_PARENT);
		}
	}

	/**
	 * Replaces the original getter which is cast as ConnectorEnd (expected end of Connector)
	 * 
	 * @return the element that is graphically connected to Connector as source
	 */
	protected ConnectableElement _getSource() {
		return (ConnectableElement) source;
	}

	/**
	 * Replaces the original getter which is cast as ConnectorEnd (expected end of Connector)
	 * 
	 * @return the element that is graphically connected to Connector as target
	 */
	protected ConnectableElement _getTarget() {
		return (ConnectableElement) target;
	}

	/**
	 * <pre>
	 * Checks if the Connector can be created or not.
	 * 
	 * {@inheritDoc}
	 * </pre>
	 */
	@Override
	public boolean canExecute() {
		if (source == null && target == null) {
			return false;
		}
		if (source != null && false == source instanceof ConnectableElement) {
			return false;
		}
		if (target != null && false == target instanceof ConnectableElement) {
			return false;
		}
		if (_getSource() == null) {
			return true; // link creation is in progress; source is not defined yet
		}
		// target may be null here but it's possible to check constraint
		if (getContainer() == null) {
			return false;
		}
		// return
		// UMLBaseItemSemanticEditPolicy.LinkConstraints.canCreateConnector_4013(getContainer(),
		// _getSource(),
		// _getTarget());
		// this returns true anyway...
		return true;
	}

	/**
	 * <pre>
	 * Creates the new Connector.
	 * 
	 * {@inheritDoc}
	 * </pre>
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException(Messages.ConnectorCreateCommand_INVALID_ARGS_MSG);
		}
		Connector newElement = UMLFactory.eINSTANCE.createConnector();
		getContainer().getOwnedConnectors().add(newElement);

		ConnectorEnd end0 = UMLFactory.eINSTANCE.createConnectorEnd();
		if (_getSource() instanceof Port) {
			end0.setRole((Port) _getSource());
			end0.setPartWithPort(sourcePartWithPort);

		} else if (_getSource() instanceof ConnectableElement) {
			end0.setRole((ConnectableElement) _getSource());

		} else {
			throw new ExecutionException(Messages.ConnectorCreateCommand_INVALID_SOURCE_MSG);
		}

		ConnectorEnd end1 = UMLFactory.eINSTANCE.createConnectorEnd();
		if (_getTarget() instanceof Port) {
			end1.setRole((Port) _getTarget());
			end1.setPartWithPort(targetPartWithPort);

		} else if (_getTarget() instanceof ConnectableElement) {
			end1.setRole((ConnectableElement) _getTarget());

		} else {
			throw new ExecutionException(Messages.ConnectorCreateCommand_INVALID_TARGET_MSG);
		}

		newElement.getEnds().add(end0);
		newElement.getEnds().add(end1);

		UMLElementTypes.init_Connector_4013(newElement);

		doConfigure(newElement, monitor, info);
		((CreateElementRequest) getRequest()).setNewElement(newElement);

		return CommandResult.newOKCommandResult(newElement);
	}

	/**
	 * <pre>
	 * This method is the exact copy of the inherited method, except that it uses the local getters
	 * (_getSource(), _getTarget()). 
	 * 
	 * {@inheritDoc}
	 * </pre>
	 */
	@Override
	protected void doConfigure(Connector newElement, IProgressMonitor monitor, IAdaptable info)
			throws ExecutionException {
		IElementType elementType = ((CreateElementRequest) getRequest()).getElementType();
		ConfigureRequest configureRequest = new ConfigureRequest(getEditingDomain(), newElement, elementType);
		configureRequest.setClientContext(((CreateElementRequest) getRequest()).getClientContext());
		configureRequest.addParameters(getRequest().getParameters());
		configureRequest.setParameter(CreateRelationshipRequest.SOURCE, _getSource());
		configureRequest.setParameter(CreateRelationshipRequest.TARGET, _getTarget());
		ICommand configureCommand = elementType.getEditCommand(configureRequest);
		if (configureCommand != null && configureCommand.canExecute()) {
			configureCommand.execute(monitor, info);
		}
	}
}
