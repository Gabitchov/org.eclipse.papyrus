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
 *  Nizar GUEDIDI (CEA LIST) - Initial API and implementation
 /*****************************************************************************/
package org.eclipse.papyrus.uml.diagram.component.custom.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeConnectionRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.papyrus.uml.diagram.component.custom.edit.helpers.MultiDependencyHelper;
import org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes;

/**
 * This class is used to launch command to create associationClass
 * 
 * @author Patrick Tessier
 */
public class CustomGraphicalNodeEditPolicy extends GraphicalNodeEditPolicy {

	/**
	 * 
	 * {@inheritDoc}
	 */
	public Command getCommand(Request request) {

		// we have to distinguish the case where this is an association class
		if(REQ_CONNECTION_END.equals(request.getType())) {
			if(request instanceof CreateConnectionViewAndElementRequest) {
				// default behavior
				Command c = getConnectionAndRelationshipCompleteCommand((CreateConnectionViewAndElementRequest)request);

				// case of associationClass
				CreateElementRequestAdapter requestAdapter = ((CreateConnectionViewAndElementRequest)request).getConnectionViewAndElementDescriptor().getCreateElementRequestAdapter();
				CreateRelationshipRequest createElementRequest = (CreateRelationshipRequest)requestAdapter.getAdapter(CreateRelationshipRequest.class);

				if(UMLElementTypes.Dependency_4017.equals(createElementRequest.getElementType())) {
					MultiDependencyHelper multiDependencyHelper = new MultiDependencyHelper(getEditingDomain());
					return multiDependencyHelper.getCommand(((CreateConnectionViewAndElementRequest)request), c);

				} else {
					return c;
				}
			} else if(request instanceof CreateUnspecifiedTypeConnectionRequest) {
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
}
