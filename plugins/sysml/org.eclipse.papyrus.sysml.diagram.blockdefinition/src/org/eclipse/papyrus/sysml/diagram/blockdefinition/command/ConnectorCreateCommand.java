/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Mathieu Velten (Atos Origin) mathieu.velten@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdefinition.command;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.papyrus.diagram.common.helper.NamedElementHelper;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.policy.GraphicalNodeEditPolicy;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuredClassifier;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

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
public class ConnectorCreateCommand extends EditElementCommand {

	protected EObject source;

	protected EObject target;

	protected StructuredClassifier container;
	
	/** Graphical parent of Source **/
	protected Property sourcePartWithPort = null;

	/** Graphical parent of Target **/
	protected Property targetPartWithPort = null;

	/**
	 * Constructor of Connector custom creation command
	 * 
	 * @param req
	 *        the creation request
	 * @param source
	 *        the connector source element
	 * @param target
	 *        the connector target element
	 */
	public ConnectorCreateCommand(CreateRelationshipRequest req, EObject source, EObject target) {
		super(req.getLabel(), null, req);
		this.source = source;
		this.target = target;
		
		container = deduceContainer(source, target);

		// Resolve graphical parents of source and target store in request as Parameters
		// These parameters are added in request by (custom) GraphicalNodeEditPolicy
		if(req.getParameter(GraphicalNodeEditPolicy.CONNECTOR_CREATE_REQUEST_SOURCE_PARENT) instanceof Property) {
			sourcePartWithPort = (Property)req.getParameter(GraphicalNodeEditPolicy.CONNECTOR_CREATE_REQUEST_SOURCE_PARENT);
		}
		if(req.getParameter(GraphicalNodeEditPolicy.CONNECTOR_CREATE_REQUEST_TARGET_PARENT) instanceof Property) {
			targetPartWithPort = (Property)req.getParameter(GraphicalNodeEditPolicy.CONNECTOR_CREATE_REQUEST_TARGET_PARENT);
		}
	}

	/**
	 * Replaces the original getter which is cast as ConnectorEnd (expected end of Connector)
	 * 
	 * @return the element that is graphically connected to Connector as source
	 */
	protected ConnectableElement getSource() {
		return (ConnectableElement)source;
	}

	/**
	 * Replaces the original getter which is cast as ConnectorEnd (expected end of Connector)
	 * 
	 * @return the element that is graphically connected to Connector as target
	 */
	protected ConnectableElement getTarget() {
		return (ConnectableElement)target;
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
		if(source == null && target == null) {
			return false;
		}
		if(source != null && false == source instanceof ConnectableElement) {
			return false;
		}
		if(target != null && false == target instanceof ConnectableElement) {
			return false;
		}
		if(getSource() == null) {
			return true; // link creation is in progress; source is not defined yet
		}
		// target may be null here but it's possible to check constraint
		if(getContainer() == null) {
			return false;
		}

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
		if(!canExecute()) {
			throw new ExecutionException("Invalid arguments in create link command");
		}
		Connector newElement = UMLFactory.eINSTANCE.createConnector();
		getContainer().getOwnedConnectors().add(newElement);

		ConnectorEnd end0 = UMLFactory.eINSTANCE.createConnectorEnd();
		if(getSource() instanceof Port) {
			end0.setRole((Port)getSource());
			end0.setPartWithPort(sourcePartWithPort);

		} else if(getSource() instanceof ConnectableElement) {
			end0.setRole((ConnectableElement)getSource());

		} else {
			throw new ExecutionException("Invalid source in create Connector command");
		}

		ConnectorEnd end1 = UMLFactory.eINSTANCE.createConnectorEnd();
		if(getTarget() instanceof Port) {
			end1.setRole((Port)getTarget());
			end1.setPartWithPort(targetPartWithPort);

		} else if(getTarget() instanceof ConnectableElement) {
			end1.setRole((ConnectableElement)getTarget());

		} else {
			throw new ExecutionException("Invalid target in create Connector command");
		}

		newElement.getEnds().add(end0);
		newElement.getEnds().add(end1);

		String newElementName = NamedElementHelper.EINSTANCE.getNewUMLElementName(newElement.getOwner(), UMLPackage.eINSTANCE.getConnector());
		newElement.setName(newElementName);

		doConfigure(newElement, monitor, info);
		((CreateElementRequest)getRequest()).setNewElement(newElement);

		return CommandResult.newOKCommandResult(newElement);
	}

	protected void doConfigure(Connector newElement, IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		IElementType elementType = ((CreateElementRequest)getRequest()).getElementType();
		ConfigureRequest configureRequest = new ConfigureRequest(getEditingDomain(), newElement, elementType);
		configureRequest.setClientContext(((CreateElementRequest)getRequest()).getClientContext());
		configureRequest.addParameters(getRequest().getParameters());
		configureRequest.setParameter(CreateRelationshipRequest.SOURCE, getSource());
		configureRequest.setParameter(CreateRelationshipRequest.TARGET, getTarget());
		ICommand configureCommand = elementType.getEditCommand(configureRequest);
		if(configureCommand != null && configureCommand.canExecute()) {
			configureCommand.execute(monitor, info);
		}
	}
	
	/**
	 * @generated
	 */
	public StructuredClassifier getContainer() {
		return container;
	}

	/**
	 * Default approach is to traverse ancestors of the source to find instance of container.
	 * Modify with appropriate logic.
	 * 
	 * @generated
	 */
	private static StructuredClassifier deduceContainer(EObject source, EObject target) {
		// Find container element for the new link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null; element = element.eContainer()) {
			if(element instanceof StructuredClassifier) {
				return (StructuredClassifier)element;
			}
		}
		return null;
	}
}
