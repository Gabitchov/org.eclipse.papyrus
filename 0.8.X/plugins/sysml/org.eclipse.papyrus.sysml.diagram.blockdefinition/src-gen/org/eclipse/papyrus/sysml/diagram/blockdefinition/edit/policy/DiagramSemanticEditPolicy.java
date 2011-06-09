/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.blockdefinition.edit.policy;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.gmf.diagram.common.edit.policy.DefaultSemanticEditPolicy;
import org.eclipse.papyrus.service.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.service.edit.service.IElementEditService;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.provider.ElementTypes;
import org.eclipse.papyrus.sysml.service.types.element.SysMLElementTypes;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;

public class DiagramSemanticEditPolicy extends DefaultSemanticEditPolicy {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getReorientRelationshipSourceCommand(ReconnectRequest request) {
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getReorientRelationshipTargetCommand(ReconnectRequest request) {
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getReorientRefRelationshipSourceCommand(ReconnectRequest request) {
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getReorientRefRelationshipTargetCommand(ReconnectRequest request) {
		return UnexecutableCommand.INSTANCE;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getCreateCommand(CreateElementRequest req) {

		IElementEditService commandService = ElementEditServiceUtils.getCommandProvider(req.getContainer());
		if(commandService == null) {
			return UnexecutableCommand.INSTANCE;
		}

		// Start of user code custom creation commands
		// End of user code

		if(UMLElementTypes.ACTOR == req.getElementType()) {
			CreateElementRequest createRequest = new CreateElementRequest(req.getContainer(), UMLElementTypes.ACTOR);
			return new ICommandProxy(commandService.getEditCommand(createRequest));
		}
		if(UMLElementTypes.ENUMERATION == req.getElementType()) {
			CreateElementRequest createRequest = new CreateElementRequest(req.getContainer(), UMLElementTypes.ENUMERATION);
			return new ICommandProxy(commandService.getEditCommand(createRequest));
		}
		if(UMLElementTypes.PRIMITIVE_TYPE == req.getElementType()) {
			CreateElementRequest createRequest = new CreateElementRequest(req.getContainer(), UMLElementTypes.PRIMITIVE_TYPE);
			return new ICommandProxy(commandService.getEditCommand(createRequest));
		}
		if(SysMLElementTypes.VALUE_TYPE == req.getElementType()) {
			CreateElementRequest createRequest = new CreateElementRequest(req.getContainer(), SysMLElementTypes.VALUE_TYPE);
			return new ICommandProxy(commandService.getEditCommand(createRequest));
		}
		if(UMLElementTypes.DATA_TYPE == req.getElementType()) {
			CreateElementRequest createRequest = new CreateElementRequest(req.getContainer(), UMLElementTypes.DATA_TYPE);
			return new ICommandProxy(commandService.getEditCommand(createRequest));
		}
		if(SysMLElementTypes.FLOW_SPECIFICATION == req.getElementType()) {
			CreateElementRequest createRequest = new CreateElementRequest(req.getContainer(), SysMLElementTypes.FLOW_SPECIFICATION);
			return new ICommandProxy(commandService.getEditCommand(createRequest));
		}
		if(UMLElementTypes.INTERFACE == req.getElementType()) {
			CreateElementRequest createRequest = new CreateElementRequest(req.getContainer(), UMLElementTypes.INTERFACE);
			return new ICommandProxy(commandService.getEditCommand(createRequest));
		}
		if(UMLElementTypes.SIGNAL == req.getElementType()) {
			CreateElementRequest createRequest = new CreateElementRequest(req.getContainer(), UMLElementTypes.SIGNAL);
			return new ICommandProxy(commandService.getEditCommand(createRequest));
		}
		if(SysMLElementTypes.CONSTRAINT_BLOCK == req.getElementType()) {
			CreateElementRequest createRequest = new CreateElementRequest(req.getContainer(), SysMLElementTypes.CONSTRAINT_BLOCK);
			return new ICommandProxy(commandService.getEditCommand(createRequest));
		}
		if(SysMLElementTypes.BLOCK == req.getElementType()) {
			CreateElementRequest createRequest = new CreateElementRequest(req.getContainer(), SysMLElementTypes.BLOCK);
			return new ICommandProxy(commandService.getEditCommand(createRequest));
		}
		if(SysMLElementTypes.DIMENSION == req.getElementType()) {
			CreateElementRequest createRequest = new CreateElementRequest(req.getContainer(), SysMLElementTypes.DIMENSION);
			return new ICommandProxy(commandService.getEditCommand(createRequest));
		}
		if(SysMLElementTypes.UNIT == req.getElementType()) {
			CreateElementRequest createRequest = new CreateElementRequest(req.getContainer(), SysMLElementTypes.UNIT);
			return new ICommandProxy(commandService.getEditCommand(createRequest));
		}
		if(SysMLElementTypes.FLOW_PORT == req.getElementType()) {
			CreateElementRequest createRequest = new CreateElementRequest(req.getContainer(), SysMLElementTypes.FLOW_PORT);
			return new ICommandProxy(commandService.getEditCommand(createRequest));
		}
		if(UMLElementTypes.PORT == req.getElementType()) {
			CreateElementRequest createRequest = new CreateElementRequest(req.getContainer(), UMLElementTypes.PORT);
			return new ICommandProxy(commandService.getEditCommand(createRequest));
		}
		if(ElementTypes.MODEL == req.getElementType()) {
			CreateElementRequest createRequest = new CreateElementRequest(req.getContainer(), UMLElementTypes.MODEL);
			return new ICommandProxy(commandService.getEditCommand(createRequest));
		}
		if(ElementTypes.PACKAGE == req.getElementType()) {
			CreateElementRequest createRequest = new CreateElementRequest(req.getContainer(), UMLElementTypes.PACKAGE);
			return new ICommandProxy(commandService.getEditCommand(createRequest));
		}
		if(ElementTypes.INSTANCE_SPECIFICATION == req.getElementType()) {
			CreateElementRequest createRequest = new CreateElementRequest(req.getContainer(), UMLElementTypes.INSTANCE_SPECIFICATION);
			return new ICommandProxy(commandService.getEditCommand(createRequest));
		}
		if(ElementTypes.CONSTRAINT == req.getElementType()) {
			CreateElementRequest createRequest = new CreateElementRequest(req.getContainer(), UMLElementTypes.CONSTRAINT);
			return new ICommandProxy(commandService.getEditCommand(createRequest));
		}
		if(ElementTypes.COMMENT == req.getElementType()) {
			CreateElementRequest createRequest = new CreateElementRequest(req.getContainer(), UMLElementTypes.COMMENT);
			return new ICommandProxy(commandService.getEditCommand(createRequest));
		}
		return UnexecutableCommand.INSTANCE;
	}
}
