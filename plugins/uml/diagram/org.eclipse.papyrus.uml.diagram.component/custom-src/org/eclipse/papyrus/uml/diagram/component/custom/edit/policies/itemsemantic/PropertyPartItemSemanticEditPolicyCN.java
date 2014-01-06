/*****************************************************************************
 * Copyright (c) 2009-2011 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.component.custom.edit.policies.itemsemantic;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;

/**
 * <pre>
 * This class provides a custom edit policy used to replace the SEMANTIC_ROLE 
 * generated for the Property element (when used as Composite Part)
 * 
 * TODO : This should probably also manage Port clean removal (semantic deletion causes issues)
 * </pre>
 */
public class PropertyPartItemSemanticEditPolicyCN extends org.eclipse.papyrus.uml.diagram.component.edit.policies.PropertyItemSemanticEditPolicy {

	/**
	 * <pre>
	 * Calls a custom creation command to allow the creation of a Port on a Property. 
	 * The Property has to be typed by a StructuredClassifier. 
	 * 
	 * {@inheritDoc}
	 * </pre>
	 */
	@Override
	protected Command getCreateCommand(CreateElementRequest req) {
		if(org.eclipse.papyrus.uml.diagram.component.providers.UMLElementTypes.Port_3069 == req.getElementType()) {
			return getGEFWrapper(new org.eclipse.papyrus.uml.diagram.component.custom.command.PortCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * <pre>
	 * Forbid direct destruction of Property in case the graphical parent is not
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
