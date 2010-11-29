/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.helper.advice;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;

/**
 * <pre>
 * This HelperAdvice completes {@link ConnectorEnd} edit commands with the deletion of the
 * related Connector in case this connector only has less than 2 ends left.
 * </pre>
 */
public class ConnectorEndHelperAdvice extends AbstractEditHelperAdvice {

	@Override
	protected ICommand getBeforeDestroyDependentsCommand(DestroyDependentsRequest request) {

		if(request.getElementToDestroy() instanceof ConnectorEnd) {
			ConnectorEnd endToDelete = (ConnectorEnd)request.getElementToDestroy();
			Connector connector = (Connector)endToDelete.getOwner();

			if(connector.getEnds().size() <= 2) {
				//return the command to destroy the Connector
				return request.getDestroyDependentCommand(connector);
			}
		}

		return null;
	}
}
