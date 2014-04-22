/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Adapted code from the class diagram
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.profile.custom.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeConnectionRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.papyrus.uml.diagram.profile.custom.helper.MultiAssociationHelper;
import org.eclipse.papyrus.uml.diagram.profile.custom.helper.MultiDependencyHelper;
import org.eclipse.papyrus.uml.diagram.profile.providers.UMLElementTypes;

/**
 * This class is used to launch command to create associationClass
 *
 * @author Patrick Tessier
 */
public class CustomGraphicalNodeEditPolicy extends GraphicalNodeEditPolicy {

	/**
	 * The ID for the additional parameter SOURCE_PARENT used in creation request
	 */
	public static final String CONNECTOR_CREATE_REQUEST_SOURCE_PARENT = "SOURCE_PARENT"; //$NON-NLS-1$

	/**
	 * The ID for the additional parameter TARGET_PARENT used in creation request
	 */
	public static final String CONNECTOR_CREATE_REQUEST_TARGET_PARENT = "TARGET_PARENT"; //$NON-NLS-1$

	/**
	 *
	 * {@inheritDoc}
	 */
	@Override
	public Command getCommand(Request request) {
		// we have to distinguish the case where this is an association class
		if(REQ_CONNECTION_END.equals(request.getType())) {
			if(request instanceof CreateConnectionViewAndElementRequest) {
				// default behavior
				Command c = getConnectionAndRelationshipCompleteCommand((CreateConnectionViewAndElementRequest)request);
				// case of associationClass
				CreateElementRequestAdapter requestAdapter = ((CreateConnectionViewAndElementRequest)request).getConnectionViewAndElementDescriptor().getCreateElementRequestAdapter();
				CreateRelationshipRequest createElementRequest = (CreateRelationshipRequest)requestAdapter.getAdapter(CreateRelationshipRequest.class);
				if(UMLElementTypes.Dependency_4018.equals(createElementRequest.getElementType())) {
					MultiDependencyHelper multiDependencyHelper = new MultiDependencyHelper(getEditingDomain());
					return multiDependencyHelper.getCommand(((CreateConnectionViewAndElementRequest)request), c);
				} else if(UMLElementTypes.Association_4019.equals(createElementRequest.getElementType())) {
					MultiAssociationHelper multiAssociationHelper = new MultiAssociationHelper(getEditingDomain());
					return multiAssociationHelper.getCommand(((CreateConnectionViewAndElementRequest)request), c);
				} else {
					return c;
				}
			}
			if(request instanceof CreateUnspecifiedTypeConnectionRequest) {
				return getUnspecifiedConnectionCompleteCommand((CreateUnspecifiedTypeConnectionRequest)request);
			}
		}
		return super.getCommand(request);
	}

	/**
	 * used to obtain the transactional edit domain
	 *
	 * @return the current transactional edit domain
	 */
	private TransactionalEditingDomain getEditingDomain() {
		return ((IGraphicalEditPart)getHost()).getEditingDomain();
	}

	@Override
	protected Command getReconnectSourceCommand(ReconnectRequest request) {
		return super.getReconnectSourceCommand(request);
	}

	@Override
	protected Command getReconnectTargetCommand(ReconnectRequest request) {
		Command command = super.getReconnectTargetCommand(request);
		return command;
	}
}
