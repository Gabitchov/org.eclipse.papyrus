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
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.command;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.papyrus.uml.service.types.utils.RequestParameterConstants;
import org.eclipse.uml2.uml.ConnectableElement;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;

/**
 * <pre>
 * Re-orient command for binary {@link Connector}.
 * </pre>
 */
public class ConnectorReorientCommand extends EditElementCommand {

	private final int reorientDirection;

	private final EObject oldEnd;

	private final EObject newEnd;

	private final EObject newEndParent;
	
	/**
	 * Constructor.
	 */
	public ConnectorReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
		newEndParent = (EObject)request.getParameter(RequestParameterConstants.CONNECTOR_REORIENT_REQUEST_TARGET_PARENT);
	}

	/**
	 * Test if the command can be executed.
	 */
	public boolean canExecute() {
		if(false == getElementToEdit() instanceof Connector) {
			return false;
		}
		
		if(getLink().getEnds().size() != 2) {
			return false;
		}
		
		if (getNewEndParent() != null) {
			if (getNewEndParent() instanceof Port) {
				return false;
			}
			if (!(getNewEndParent() instanceof Property)) {
				return false;
			}
		}
		
		if(reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return canReorientSource();
		}
		
		if(reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return canReorientTarget();
		}
		
		return false;
	}

	/**
	 * <pre>
	 * This method test if the {@link Connector} can be re-oriented to a new source.
	 * </pre>
	 * 
	 * @return true if the link end can be re-oriented to a new source
	 */
	protected boolean canReorientSource() {
		// Verify possible type of new source
		if(!(getNewSource() instanceof ConnectableElement)) {
			return false;
		}
		
		ConnectorEnd sourceEnd = getLink().getEnds().get(0);
		if ((sourceEnd.getPartWithPort() == null) && (getNewPartWithPort() == null)) {
			return false;
		}

		return true;
	}

	/**
	 * <pre>
	 * This method test if the {@link Connector} can be re-oriented to a new target.
	 * </pre>
	 * 
	 * @return true if the link end can be re-oriented to a new source
	 */
	protected boolean canReorientTarget() {
		// Verify possible type of new target
		if(!(getNewSource() instanceof ConnectableElement)) {
			return false;
		}

		ConnectorEnd targetEnd = getLink().getEnds().get(1);
		if ((targetEnd.getPartWithPort() == null) && (getNewPartWithPort() == null)) {
			return false;
		}

		return true;
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if(!canExecute()) {
			throw new ExecutionException("Invalid arguments in reorient link command"); //$NON-NLS-1$
		}
		if(reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return reorientSource();
		}
		if(reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return reorientTarget();
		}
		throw new IllegalStateException();
	}

	protected CommandResult reorientSource() throws ExecutionException {
		// Nothing to do here on the connector itself, the connector end remains
		// the same but related to new Port or PartWithPort.
		ConnectorEnd reorientedEnd = getLink().getEnds().get(0);
		return reorientEnd(reorientedEnd, (ConnectableElement)getNewSource(), getNewPartWithPort());
	}

	protected CommandResult reorientTarget() throws ExecutionException {
		// Nothing to do here on the connector itself, the connector end remains
		// the same but related to new Port or PartWithPort.		
		ConnectorEnd reorientedEnd = getLink().getEnds().get(1);
		return reorientEnd(reorientedEnd, (ConnectableElement)getNewTarget(), getNewPartWithPort());
	}
	
	private CommandResult reorientEnd(ConnectorEnd end, ConnectableElement role, Property partWithPort) throws ExecutionException {		
		end.setRole(role);
		end.setPartWithPort(partWithPort);
		return CommandResult.newOKCommandResult();
	}

	/**
	 * Get the link to re-orient.
	 * @return the edited {@link Connector}
	 */
	protected Connector getLink() {
		return (Connector)getElementToEdit();
	}

	/**
	 * Get the old {@link Connector} source.
	 * @return the previous {@link Connector} source.
	 */
	protected Element getOldSource() {
		return (Element)oldEnd;
	}

	/**
	 * Get the new {@link Connector} source.
	 * @return the new {@link Connector} source.
	 */
	protected Element getNewSource() {
		return (Element)newEnd;
	}

	/**
	 * Get the old {@link Connector} target.
	 * @return the previous {@link Connector} target.
	 */
	protected Element getOldTarget() {
		return (Element)oldEnd;
	}

	/**
	 * Get the new {@link Connector} target.
	 * @return the new {@link Connector} target.
	 */
	protected Element getNewTarget() {
		return (Element)newEnd;
	}
	
	/**
	 * Get the new {@link Connector} end graphical parent.
	 * @return the new {@link Connector} end graphical parent.
	 */
	protected Element getNewEndParent() {
		return (Element)newEndParent;
	}
	
	/**
	 * Get the new {@link Connector} end graphical parent.
	 * @return the new {@link Connector} end graphical parent.
	 */
	private Property getNewPartWithPort() {
		Property partWithPort = null;
		if ((newEndParent != null) && (newEndParent instanceof Property) && !(newEndParent instanceof Port)) {
			partWithPort = (Property) newEndParent;
		}
		return partWithPort;
	}
}
