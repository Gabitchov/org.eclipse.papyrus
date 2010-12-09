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
 *  Ansgar Radermacher (CEA LIST) ansgar.radermacher@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.modelexplorer.handler;

import org.eclipse.emf.common.command.Command;
import org.eclipse.papyrus.modelexplorer.commands.ValidateModelCommand;

/**
 * Action used for pasting either a model element or a shape (i.e. the model element represented
 * by the shape). Delegates to PasteShapeOrElementCommand
 * 
 * @author Ansgar Radermacher (CEA LIST)
 */
public class ValidateModelHandler extends AbstractCommandHandler
{	
	@Override
	protected Command getCommand() {
		// not useful to cache command, since selected element may change
		return new GMFtoEMFCommandWrapper(new ValidateModelCommand(getSelectedElement()));
	}	
}
