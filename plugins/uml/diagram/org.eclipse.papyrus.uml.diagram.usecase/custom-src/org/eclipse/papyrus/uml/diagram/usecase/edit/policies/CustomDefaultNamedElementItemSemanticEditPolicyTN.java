/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.usecase.edit.policies;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramUtils;
import org.eclipse.papyrus.uml.diagram.usecase.edit.commands.AssociationCreateCommand;
import org.eclipse.papyrus.uml.diagram.usecase.edit.commands.GeneralizationCreateCommand;
import org.eclipse.papyrus.uml.diagram.usecase.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Actor;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.UseCase;

/**
 * this class allow creation of association on default named element if this element is a class
 * 
 */
public class CustomDefaultNamedElementItemSemanticEditPolicyTN extends DefaultNamedElementItemSemanticEditPolicyTN {

	@Override
	protected Command getCompleteCreateRelationshipCommand(CreateRelationshipRequest req) {
		EObject eobject = ((GraphicalEditPart)getHost()).resolveSemanticElement();
		if((eobject instanceof Class) || (eobject instanceof Actor) || (eobject instanceof UseCase)) {
			if(UMLElementTypes.Association_4011 == req.getElementType()) {
				return getGEFWrapper(new AssociationCreateCommand(req, req.getSource(), req.getTarget(), DiagramUtils.getDiagramFrom(getHost())));
			}
		}
		if((eobject instanceof Class) || (eobject instanceof Actor) || (eobject instanceof UseCase)) {
			if(UMLElementTypes.Generalization_4010 == req.getElementType()) {
				return getGEFWrapper(new GeneralizationCreateCommand(req, req.getSource(), req.getTarget()));
			}
		}
		return super.getCompleteCreateRelationshipCommand(req);
	}

	@Override
	protected Command getStartCreateRelationshipCommand(CreateRelationshipRequest req) {
		EObject eobject = ((GraphicalEditPart)getHost()).resolveSemanticElement();
		if((eobject instanceof Class) || (eobject instanceof Actor) || (eobject instanceof UseCase)) {
			if(UMLElementTypes.Association_4011 == req.getElementType()) {
				return getGEFWrapper(new AssociationCreateCommand(req, req.getSource(), req.getTarget(), DiagramUtils.getDiagramFrom(getHost())));
			}
		}
		if((eobject instanceof Class) || (eobject instanceof Actor) || (eobject instanceof UseCase)) {
			if(UMLElementTypes.Generalization_4010 == req.getElementType()) {
				return getGEFWrapper(new GeneralizationCreateCommand(req, req.getSource(), req.getTarget()));
			}
		}
		return super.getStartCreateRelationshipCommand(req);
	}
}
