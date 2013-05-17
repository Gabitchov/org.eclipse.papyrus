/*****************************************************************************
 * Copyright (c) 2011 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.edit.policies;

import java.util.Collection;
import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.uml.diagram.common.editpolicies.PapyrusCreationEditPolicy;

/**
 * Aim to redirect pin and edge creation to parent element
 * WARNING : NOT WORKING FOR NOW
 */
public abstract class PinAndEdgeCreationInCompartmentEditPolicy extends PapyrusCreationEditPolicy {

	@Override
	public EditPart getTargetEditPart(Request request) {
		if(request instanceof CreateUnspecifiedTypeRequest) {
			CreateUnspecifiedTypeRequest createUnspecifiedTypeRequest = (CreateUnspecifiedTypeRequest)request;
			if(understandsRequest(request)) {
				List<?> elementTypes = createUnspecifiedTypeRequest.getElementTypes();
				// Treat the case where only one element type is listed
				// Only take Port or Parameter element type into account
				if((elementTypes.size() == 1) && getElementHandleByParent().contains(((IElementType)(elementTypes.get(0))))) {
					// If the target is a compartment replace by its parent edit part
					if((getHost() instanceof ShapeCompartmentEditPart)) {
						return getHost().getParent();
					}
				}
			}
		}
		return super.getTargetEditPart(request);
	}

	protected abstract Collection<IElementType> getElementHandleByParent();
}
