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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.type.core.commands.MoveElementsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.papyrus.gmf.diagram.common.edit.policy.DefaultSemanticEditPolicy;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
/**
 * this editpolicy allow the move command between semantic element
 *
 */

public class PackageSemanticEditPolicy extends DefaultSemanticEditPolicy {
	
	/**
	 * allow the move command between elements
	 */
		protected Command getMoveCommand(MoveRequest req) {
			EObject targetCEObject = req.getTargetContainer();
			if(targetCEObject != null) {
				IElementEditService provider = ElementEditServiceUtils.getCommandProvider(targetCEObject);
				if(provider != null) {
					ICommand moveCommand = provider.getEditCommand(req);
					if(moveCommand != null) {
						return new ICommandProxy(moveCommand);
					}
				}
				return UnexecutableCommand.INSTANCE;
			} else {
				return getGEFWrapper(new MoveElementsCommand(req));
			}
		}
}
