/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
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
package org.eclipse.papyrus.uml.service.types.helper.advice;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;
import org.eclipse.uml2.uml.Connector;

/**
 * <pre>
 * This HelperAdvice completes {@link StructuredClassifier} edit commands with:
 * 		- forbidding Connector to be moved to another {@link StructuredClassifier}, 
 *        the owner is used to know whether the Connector is valid or not (upon creation).
 * </pre>
 */
public class StructuredClassifierHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * <pre>
	 * {@inheritDoc}
	 * 
	 * Forbid move command of a {@link Connector} to a {@link StructuredClassifier}.
	 * </pre>
	 */
	@Override
	protected ICommand getBeforeMoveCommand(MoveRequest request) {

		ICommand gmfCommand = super.getBeforeMoveCommand(request);

		// Parse moved objects and detect connector moves
		for(Object movedObject : request.getElementsToMove().keySet()) {
			if(movedObject instanceof Connector) {
				// Replace default command.
				gmfCommand = UnexecutableCommand.INSTANCE;
				break;
			}
		}

		return gmfCommand;
	}
}
