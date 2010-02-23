/*****************************************************************************
 * Copyright (c) 2010 ATOS ORIGIN.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tristan FAURE (ATOS ORIGIN) tristan.faure@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.internalblock.edit.policies;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.composite.edit.policies.ClassCompositeCompartmentItemSemanticEditPolicy;
import org.eclipse.papyrus.sysml.diagram.internalblock.edit.commands.FlowPortCreateCommand;
import org.eclipse.papyrus.sysml.diagram.internalblock.providers.SysmlElementTypes;

public class ClassItemSemanticEditPolicy extends ClassCompositeCompartmentItemSemanticEditPolicy {

	public ClassItemSemanticEditPolicy(IElementType elementType) {
		super();
	}

	@Override
	public Command getCommand(Request request) {
		if (request instanceof EditCommandRequestWrapper) {
			EditCommandRequestWrapper req = (EditCommandRequestWrapper) request;
			return super.getCommand(req);
		}
		return null;
	}

	@Override
	public boolean understandsRequest(Request request) {
		if (request instanceof CreateUnspecifiedTypeRequest) {
			CreateUnspecifiedTypeRequest typeRequest = (CreateUnspecifiedTypeRequest) request;
			return typeRequest.getElementTypes().contains(SysmlElementTypes.FlowPort_2001);
		}
		return false;
	}

	public Command getCreateCommand(CreateElementRequest req) {
		if (SysmlElementTypes.FlowPort_2001 == req.getElementType()) {
			return getGEFWrapper(new FlowPortCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
