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
package org.eclipse.papyrus.uml.diagram.composite.custom.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.diagram.composite.edit.policies.CollaborationRoleItemSemanticEditPolicyCN;
import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * <pre>
 * This class provides a custom edit policy used to replace the SEMANTIC_ROLE 
 * generated for the CollaborationUse element (when used in CompositeStructure Diagram)
 * </pre>
 */
public class CollaborationRoleItemSemanticEditPolicy extends CollaborationRoleItemSemanticEditPolicyCN {

	/**
	 * <pre>
	 * This method retrieves a Destroy Reference command instead of Destroy Element.
	 * </pre>
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.composite.edit.policies.CollaborationRoleItemSemanticEditPolicyCN#getDestroyElementCommand(org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest)
	 * 
	 * @param req
	 *        the destroy element request
	 * @return the destroy element command
	 */
	@Override
	protected Command getDestroyElementCommand(DestroyElementRequest req) {

		GraphicalEditPart graphicalParent = (GraphicalEditPart)getHost().getParent();
		Collaboration collaboration = (Collaboration)graphicalParent.resolveSemanticElement();

		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(collaboration);
		if(provider != null) {

			// Retrieve delete command from the Element Edit service
			DestroyReferenceRequest setRequest = new DestroyReferenceRequest(collaboration, UMLPackage.eINSTANCE.getCollaboration_CollaborationRole(), req.getElementToDestroy(), false);

			ICommand setCommand = provider.getEditCommand(setRequest);

			if(setCommand != null) {
				return new ICommandProxy(setCommand.reduce());
			}
		}
		return UnexecutableCommand.INSTANCE;
	}
}
