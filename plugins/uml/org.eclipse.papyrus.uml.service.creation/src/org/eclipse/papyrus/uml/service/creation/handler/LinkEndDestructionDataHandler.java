/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.creation.handler;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.common.command.Command;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.uml.service.creation.handler.UMLHandler;
import org.eclipse.papyrus.diagram.common.command.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.uml.service.creation.element.UMLElementTypes;
import org.eclipse.papyrus.uml.service.creation.element.UMLTypeContext;

/**
 ** The Class ReplyActionCreateCommand in charge to create a element Reply
 **/
public class LinkEndDestructionDataHandler extends UMLHandler implements IHandler {

	/**
	 ** The Class ReplyActionCreateCommand in charge to create a element Reply
	 **/
	protected Command getCommand() throws ExecutionException {
		CreateElementRequest request = new CreateElementRequest(UMLElementTypes.LINKENDDESTRUCTIONDATA);
		request.setContainer(getSelectedElement());
		IClientContext context;
		try {
			context = UMLTypeContext.getContext();
		} catch (Exception e) {
			throw new ExecutionException(e.getMessage());
		}
		IElementType type = ElementTypeRegistry.getInstance().getElementType(getSelectedElement(), context);
		if(type == null) {
			throw new ExecutionException("Could not retrieve IElementType for : " + getSelectedElement());
		}
		ICommand gmfCommand = type.getEditCommand(request);
		if(gmfCommand == null) {
			throw new ExecutionException("Could not retrieve EditCommand for : " + type.getDisplayName());
		}
		Command emfCommand = new GMFtoEMFCommandWrapper(gmfCommand);
		return emfCommand;
	}
}
