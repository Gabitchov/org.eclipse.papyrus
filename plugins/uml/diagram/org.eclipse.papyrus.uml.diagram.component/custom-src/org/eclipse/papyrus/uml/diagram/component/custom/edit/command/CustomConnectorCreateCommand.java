/*****************************************************************************
 * Copyright (c) 2009-2011 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.component.custom.edit.command;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.papyrus.uml.diagram.component.custom.edit.policies.CustomGraphicalNodeEditPolicy;
import org.eclipse.papyrus.uml.diagram.component.providers.ElementInitializers;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuredClassifier;
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
public class CustomConnectorCreateCommand extends org.eclipse.papyrus.uml.diagram.component.edit.commands.ConnectorCreateCommand {
	/** Graphical parent of Source **/
	protected Property sourcePartWithPort = null;
	/** Graphical parent of Target **/
	protected Property targetPartWithPort = null;
	/** Graphical EditPart of Source **/
	protected GraphicalEditPart sourceGraphicalEditPart = null;
	/** Graphical EditPart of Target **/
	protected GraphicalEditPart targetGraphicalEditPart = null;

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
	public CustomConnectorCreateCommand(CreateRelationshipRequest req, EObject source, EObject target) {
		super(req, source, target);
		// Resolve graphical parents of source and target store in request as Parameters
		// These parameters are added in request by (custom) GraphicalNodeEditPolicy
		if (req.getParameter(CustomGraphicalNodeEditPolicy.CONNECTOR_CREATE_REQUEST_SOURCE_PARENT) instanceof Property) {
			sourcePartWithPort = (Property) req.getParameter(CustomGraphicalNodeEditPolicy.CONNECTOR_CREATE_REQUEST_SOURCE_PARENT);
		}
		if (req.getParameter(CustomGraphicalNodeEditPolicy.CONNECTOR_CREATE_REQUEST_TARGET_PARENT) instanceof Property) {
			targetPartWithPort = (Property) req.getParameter(CustomGraphicalNodeEditPolicy.CONNECTOR_CREATE_REQUEST_TARGET_PARENT);
		}
		if (req.getParameter(CustomGraphicalNodeEditPolicy.CONNECTOR_CREATE_REQUEST_SOURCE_GRAPHICAL) instanceof GraphicalEditPart) {
			sourceGraphicalEditPart = (GraphicalEditPart) req.getParameter(CustomGraphicalNodeEditPolicy.CONNECTOR_CREATE_REQUEST_SOURCE_GRAPHICAL);
		}
		if (req.getParameter(CustomGraphicalNodeEditPolicy.CONNECTOR_CREATE_REQUEST_TARGET_GRAPHICAL) instanceof GraphicalEditPart) {
			targetGraphicalEditPart = (GraphicalEditPart) req.getParameter(CustomGraphicalNodeEditPolicy.CONNECTOR_CREATE_REQUEST_TARGET_GRAPHICAL);
		}
		container = deduceContainer(_getSource(), _getTarget());
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
		if ((source == null) && (target == null)) {
			return false;
		}
		if ((source != null) && !(source instanceof ConnectableElement)) {
			return false;
		}
		if ((target != null) && !(target instanceof ConnectableElement)) {
			return false;
		}
		if (source == null) {
			return true; // link creation is in progress; source is not defined yet
		}
		if ((target != null) && (getContainer() == null)) {
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
			throw new ExecutionException("Invalid arguments in create link command");
		}
		Connector newElement = UMLFactory.eINSTANCE.createConnector();
		getContainer().getOwnedConnectors().add(newElement);
		ConnectorEnd end0 = UMLFactory.eINSTANCE.createConnectorEnd();
		end0.setLower(1);
		end0.setUpper(1);
		if (_getSource() instanceof Port) {
			end0.setRole((Port) _getSource());
			end0.setPartWithPort(sourcePartWithPort);
		} else if (_getSource() instanceof ConnectableElement) {
			end0.setRole((ConnectableElement) _getSource());
		} else {
			throw new ExecutionException("Invalid source in create Connector command");
		}
		ConnectorEnd end1 = UMLFactory.eINSTANCE.createConnectorEnd();
		end1.setLower(1);
		end1.setUpper(1);
		if (_getTarget() instanceof Port) {
			end1.setRole((Port) _getTarget());
			end1.setPartWithPort(targetPartWithPort);
		} else if (_getTarget() instanceof ConnectableElement) {
			end1.setRole((ConnectableElement) _getTarget());
		} else {
			throw new ExecutionException("Invalid target in create Connector command");
		}
		newElement.getEnds().add(end0);
		newElement.getEnds().add(end1);
		ElementInitializers.getInstance().init_Connector_4019(newElement);
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
	protected void doConfigure(Connector newElement, IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
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

	/**
	 * 
	 * Tries to find a common StructuredClassifier container to add the new Connector.
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.CustomConnectorCreateCommand.edit.commands.ConnectorCreateCommand#deduceContainer(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EObject)
	 * 
	 * @param source
	 *            the source object
	 * @param target
	 *            the target object
	 * @return a common StructuredClassifier container (graphical search)
	 */
	@Override
	protected StructuredClassifier deduceContainer(EObject source, EObject target) {
		if (sourceGraphicalEditPart != null && targetGraphicalEditPart != null) {
			StructuredClassifier containerProposedBySource = proposedContainer(sourceGraphicalEditPart);
			StructuredClassifier containerProposedByTarget = proposedContainer(targetGraphicalEditPart);
			if ((containerProposedBySource != null) && (containerProposedByTarget != null)) {
				if (containerProposedBySource == containerProposedByTarget) {
					return containerProposedBySource;
				}
			}
		}
		return null;
	}

	/**
	 * Parse graphical parent of the graphicalEditPart until a StructureClassifier is found.
	 * 
	 * @param graphicalEditPart
	 *            the graphical edit part
	 * @return null or a StructuredClassifier that graphically contains the graphicalEditPart
	 */
	private StructuredClassifier proposedContainer(GraphicalEditPart graphicalEditPart) {
		for (EditPart ep = graphicalEditPart; ep != null; ep = ep.getParent()) {
			if (ep instanceof GraphicalEditPart) {
				GraphicalEditPart parent = (GraphicalEditPart) ep;
				EObject semanticParent = parent.resolveSemanticElement();
				if (semanticParent instanceof StructuredClassifier) {
					return (StructuredClassifier) semanticParent;
				}
			}
		}
		return null;
	}
}
