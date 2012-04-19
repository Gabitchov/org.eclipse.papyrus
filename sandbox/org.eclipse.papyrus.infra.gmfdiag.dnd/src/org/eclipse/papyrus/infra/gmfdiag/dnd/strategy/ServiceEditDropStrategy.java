/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.dnd.strategy;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.papyrus.infra.emf.Activator;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;

/**
 * An abstract DropStrategy relying on the ServiceEdit. This strategy should
 * only be used for semantic drops.
 * 
 * @author Camille Letavernier
 */
public abstract class ServiceEditDropStrategy extends TransactionalDropStrategy {

	@Override
	public final Command doGetCommand(Request request, EditPart targetEditPart) {
		try {
			EObject targetElement = getTargetSemanticElement(targetEditPart);

			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(targetElement);

			if(provider != null) {
				IEditCommandRequest editRequest = getEditRequest(request, targetEditPart);
				if(editRequest == null) {
					return null;
				}

				ICommand createGMFCommand = provider.getEditCommand(editRequest);

				if(createGMFCommand == null) {
					return null;
				}

				Command command = new ICommandProxy(createGMFCommand);

				return command;
			}
		} catch (Exception ex) {
			Activator.log.error(ex);
		}

		return null;
	}

	public abstract IEditCommandRequest getEditRequest(Request request, EditPart targetEditPart);

}
