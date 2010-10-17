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
 * 
 * 		Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.helper;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.papyrus.uml.service.types.command.GeneralizationReorientCommand;
import org.eclipse.uml2.uml.Generalization;

/**
 * <pre>
 * 
 * This helper provides edit commands for UML {@link Generalization}.
 * 
 * </pre>
 */
public class GeneralizationEditHelper extends DefaultUMLEditHelper {

	@Override
	protected ICommand getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		return new GeneralizationReorientCommand(req);
	}
}
