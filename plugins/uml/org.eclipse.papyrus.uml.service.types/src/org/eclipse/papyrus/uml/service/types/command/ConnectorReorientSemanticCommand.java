/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.command;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientReferenceRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.papyrus.uml.service.types.utils.ConnectorUtils;
import org.eclipse.papyrus.uml.service.types.utils.NamedElementHelper;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StructuredClassifier;

/**
 * 
 * This command manage the connector reorient at the semantic level
 * 
 */
public class ConnectorReorientSemanticCommand extends EditElementCommand {

	/**
	 * the opposite part (which is not retargeted)
	 */
	private EObject oppositeEnd;

	/**
	 * the new part
	 */
	private EObject newEnd;

	/**
	 * the direction for the retarget
	 */
	protected final int reorientDirection;

	/**
	 * the new part with port
	 */
	private Property newPartWithPort;

	/**
	 * the opposite part with port (which is not changed here)
	 */
	private Property oppositePartWithPort;


	/**
	 * Constructor.
	 */
	public ConnectorReorientSemanticCommand(final ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		this.reorientDirection = request.getDirection();
		this.newEnd = request.getNewRelationshipEnd();
		if(getElementToEdit() instanceof Connector) {
			this.oppositeEnd = (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) ? ((Connector)getElementToEdit()).getEnds().get(1).getRole() : ((Connector)getElementToEdit()).getEnds().get(0).getRole();
			this.oppositePartWithPort = (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) ? ((Connector)getElementToEdit()).getEnds().get(1).getPartWithPort() : ((Connector)getElementToEdit()).getEnds().get(0).getPartWithPort();
		} else {
			this.oppositeEnd = null;
			this.oppositePartWithPort = null;
		}
		initFields();
	}

	public ConnectorReorientSemanticCommand(final ReorientReferenceRelationshipRequest request) {
		super(request.getLabel(), null, request);
		this.reorientDirection = request.getDirection();
		this.newEnd = request.getNewRelationshipEnd();

		if(getElementToEdit() instanceof Connector) {
			this.oppositeEnd = (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) ? ((Connector)getElementToEdit()).getEnds().get(1).getRole() : ((Connector)getElementToEdit()).getEnds().get(0).getRole();
			this.oppositePartWithPort = (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) ? ((Connector)getElementToEdit()).getEnds().get(1).getPartWithPort() : ((Connector)getElementToEdit()).getEnds().get(0).getPartWithPort();
		} else {
			this.oppositeEnd = null;
			this.oppositePartWithPort = null;
		}
		initFields();
	}

	/**
	 * This method allows to init the fields which can't be initialized in the constructor
	 */
	protected void initFields() {
		this.newPartWithPort = (Property)getRequest().getParameter(ConnectorUtils.PART_WITH_PORT);
	}

	/**
	 * Get the link to re-orient.
	 * 
	 * @return the edited {@link Connector}
	 */
	protected Connector getLink() {
		return (Connector)getElementToEdit();
	}

	/**
	 * Test if the command can be executed.
	 */
	public boolean canExecute() {
		if(!(getElementToEdit() instanceof Connector)) {
			return false;
		}
		//TODO
		//in fact, in UML ends>2 is allowed, but it is forbidden in SysML
		if(getLink().getEnds().size() != 2) {
			return false;
		}

		return canReorient(newEnd, oppositeEnd);
	}

	/**
	 * 
	 * @param newRole
	 * @param oppositeRole
	 * @return
	 *         <code>true</code> if the newRole can be used as role for connector
	 */
	private boolean canReorient(final EObject newRole, final EObject oppositeRole) {
		if(newRole == null) {
			return true;//we allow to reinitialize the role
		}
		//the new role must be a connectable element
		if(!(newRole instanceof ConnectableElement)) {
			return false;
		}

		if(newRole != null && oppositeRole != null) {
			//the 2 roles must be not be equals
			if(newRole == oppositeRole) {
				return false;
			}


			//UML Standart, p.181 : [3] The ConnectableElements attached as roles to each ConnectorEnd owned by a Connector must be roles
			//of the Classifier, that owned the Connector, or they must be ports of such roles. (p.181)
			//in SysML this rules is not applied, that's why we are testing the context of this action
			if(ConnectorUtils.applyUMLRulesForConnector(getLink())) {
				final StructuredClassifier newContainer = deduceParentConnector(getLink(), (ConnectableElement)oppositeRole, (ConnectableElement)newRole, this.oppositePartWithPort, this.newPartWithPort);
				if(ConnectorUtils.applyUMLRulesForConnector(getLink()) && !ConnectorUtils.getUMLPossibleRoles(newContainer).contains(newRole)) {
					return false;
				}
			}

		}
		return true;
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
	 *      org.eclipse.core.runtime.IAdaptable)
	 * 
	 * @param monitor
	 * @param info
	 * @return
	 * @throws ExecutionException
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if(!canExecute()) {
			throw new ExecutionException("Invalid arguments in reorient link command"); //$NON-NLS-1$
		}

		final ConnectorEnd editedConnectorEnd;
		final ConnectorEnd oppositeEnd;
		if(reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			editedConnectorEnd = getLink().getEnds().get(0);
			oppositeEnd = getLink().getEnds().get(1);
		} else if(reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			editedConnectorEnd = getLink().getEnds().get(1);
			oppositeEnd = getLink().getEnds().get(0);
		} else {
			editedConnectorEnd = null;
			oppositeEnd = null;
		}
		if(editedConnectorEnd != null) {
			reorientEnd(editedConnectorEnd, oppositeEnd, (ConnectableElement)newEnd, newPartWithPort, oppositePartWithPort);
			if(ConnectorUtils.applyUMLRulesForConnector(getLink())) {
				final StructuredClassifier newContainer = deduceParentConnector(getLink(), (ConnectableElement)this.oppositeEnd, (ConnectableElement)this.newEnd, this.oppositePartWithPort, this.newPartWithPort);
				replaceOwner(getLink(), newContainer);
			}
			return CommandResult.newOKCommandResult();
		}
		throw new IllegalStateException();
	}

	/**
	 * 
	 * @param end
	 * @param oppositeEnd
	 *        TODO
	 * @param role
	 * @param partWithPort
	 * @param oppositePartWithPort
	 * @return
	 * @throws ExecutionException
	 */
	protected CommandResult reorientEnd(final ConnectorEnd end, ConnectorEnd oppositeEnd, final ConnectableElement role, final Property partWithPort, final Property oppositePartWithPort) throws ExecutionException {
		end.setRole(role);
		end.setPartWithPort(partWithPort);
		oppositeEnd.setPartWithPort(oppositePartWithPort);
		return CommandResult.newOKCommandResult();
	}



	/**
	 * 
	 * @param newPartWithPort
	 */
	public void setNewPartWithPort(final Property newPartWithPort) {
		this.newPartWithPort = newPartWithPort;
	}

	/**
	 * 
	 * @param connector
	 *        the connector
	 * @param newOwner
	 *        the new owner for the connector
	 */
	protected void replaceOwner(final Connector connector, final StructuredClassifier newOwner) {
		// Change owner and Connector name (possibly already exists in new container)
		if(newOwner != connector.getOwner()) {
			if(newOwner.getOwnedConnector(connector.getName()) != null) {
				String replacementName = NamedElementHelper.getDefaultNameWithIncrementFromBase("connector", newOwner.eContents()); // //$NON-NLS-0$
				connector.setName(replacementName);
			}
			// Replace connector owner
			newOwner.getOwnedConnectors().add(connector);
		}
	}

	/**
	 * 
	 * @param connector
	 *        the edited connector
	 * @param role1
	 *        a role of this connector
	 * @param role2
	 *        the 2nd role for this connector
	 * @param partWithPort1
	 *        the part with port for the first role (could be <code>null</code>
	 * @param partWithPort2
	 *        the part with port for the second role (could be <code>null</code>
	 * @return
	 *         the new parent for the connector
	 */
	protected StructuredClassifier deduceParentConnector(final Connector connector, final ConnectableElement role1, final ConnectableElement role2, final Property partWithPort1, final Property partWithPort2) {
		final Element owner1 = role1.getOwner();
		final Element owner2 = role2.getOwner();
		if(owner1 == owner2 && owner1 instanceof StructuredClassifier) {
			return (StructuredClassifier)owner1;
		}
		if(role1 instanceof Port && role2 instanceof Port) {
			final StructuredClassifier partOwner1 = (StructuredClassifier)partWithPort1.getOwner();
			final StructuredClassifier partOwner2 = (StructuredClassifier)partWithPort2.getOwner();
			if(partOwner2.getOwnedElements().contains(partWithPort1)) {
				return partOwner2;
			}
			return partOwner1;
		}
		return (StructuredClassifier)connector.getOwner();
	}

	/**
	 * Setter for {@link #oppositeEnd}
	 * 
	 * @param oppositeEnd
	 *        the opposite end
	 */
	public final void setOppositeEnd(final EObject oppositeEnd) {
		this.oppositeEnd = oppositeEnd;
	}

	/**
	 * Setter for {@link #newEnd}
	 * 
	 * @param newEnd
	 *        the new end
	 */
	public final void setNewEnd(final EObject newEnd) {
		this.newEnd = newEnd;
	}

	/**
	 * Setter for {@link #oppositePartWithPort}
	 * 
	 * @param oppositePartWithPort
	 *        the opposite part with port
	 */
	public final void setOppositePartWithPort(Property oppositePartWithPort) {
		this.oppositePartWithPort = oppositePartWithPort;
	}

	/**
	 * @return the oppositeEnd
	 */
	public EObject getOppositeEnd() {
		return oppositeEnd;
	}


	/**
	 * @return the newEnd
	 */
	public EObject getNewEnd() {
		return newEnd;
	}


	/**
	 * @return the newPartWithPort
	 */
	protected Property getNewPartWithPort() {
		return newPartWithPort;
	}


	/**
	 * @return the oppositePartWithPort
	 */
	protected Property getOppositePartWithPort() {
		return oppositePartWithPort;
	}
}
