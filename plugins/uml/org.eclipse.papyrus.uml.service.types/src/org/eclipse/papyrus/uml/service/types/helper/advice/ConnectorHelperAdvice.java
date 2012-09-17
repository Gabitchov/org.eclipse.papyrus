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
import org.eclipse.uml2.uml.ConnectorEnd;

/**
 * <pre>
 * This HelperAdvice completes {@link Connector} edit commands with:
 * 		- forbidding {@link ConnectorEnd} to be moved to another {@link Connector}
 * </pre>
 */
public class ConnectorHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * <pre>
	 * {@inheritDoc}
	 * 
	 * Forbid move command of a {@link ConnectorEnd} to a {@link Connector}.
	 * </pre>
	 */
	@Override
	protected ICommand getBeforeMoveCommand(MoveRequest request) {

		ICommand gmfCommand = super.getBeforeMoveCommand(request);

		// Parse moved objects and detect ConnectorEnd moves
		for(Object movedObject : request.getElementsToMove().keySet()) {
			if(movedObject instanceof ConnectorEnd) {
				// Replace default command.
				gmfCommand = UnexecutableCommand.INSTANCE;
				break;
			}
		}

		return gmfCommand;
	}
}
