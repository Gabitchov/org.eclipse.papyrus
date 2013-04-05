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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.service.validation.handler;

import org.eclipse.emf.common.command.Command;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.services.validation.commands.ValidateModelCommand;
import org.eclipse.papyrus.infra.services.validation.handler.AbstractCommandHandler;
import org.eclipse.papyrus.uml.service.validation.UMLDiagnostician;

/**
 * Action used for pasting either a model element or a shape (i.e. the model element represented
 * by the shape). Delegates to PasteShapeOrElementCommand
 * 
 */
public class ValidateModelHandler extends AbstractCommandHandler {

	@Override
	protected Command getCommand() {
		// not useful to cache command, since selected element may change
		return new GMFtoEMFCommandWrapper(new ValidateModelCommand(getSelectedElement(), new UMLDiagnostician()));
	}
}
