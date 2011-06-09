/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.component.custom.edit.policies;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;

/**
 * <pre>
 * This class provides a custom edit policy used to replace the SEMANTIC_ROLE 
 * generated for the Port element (when used in CompositeStructure Diagram)
 * </pre>
 */
public class PortItemSemanticEditPolicy extends org.eclipse.papyrus.diagram.component.edit.policies.PortItemSemanticEditPolicy {

	/**
	 * <pre>
	 * Forbid direct destruction of Port in case the graphical parent is not
	 * the semantic parent.  
	 * 
	 * {@inheritDoc}
	 * </pre>
	 */
	@Override
	protected Command getDestroyElementCommand(DestroyElementRequest req) {

		EObject graphicalParent = ((GraphicalEditPart)getHost().getParent()).resolveSemanticElement();
		EObject semanticParent = req.getElementToDestroy().eContainer();

		if(graphicalParent != semanticParent) {
			return UnexecutableCommand.INSTANCE;
		}

		return super.getDestroyElementCommand(req);
	}

}
