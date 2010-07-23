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
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - customization for CollaborationUse
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.composite.custom.helper;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.diagram.common.helper.ElementHelper;
import org.eclipse.papyrus.diagram.composite.custom.edit.command.SetTypeWithDialogCommand;
import org.eclipse.uml2.uml.CollaborationUse;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UMLPackage;

public class CollaborationUseHelper extends ElementHelper {

	public CollaborationUseHelper(TransactionalEditingDomain editDomain) {
		this.editDomain = editDomain;
	}

	public CompoundCommand dropCollaborationOnCollaborationUse(GraphicalEditPart graphicalTarget, Type semanticElement, Point location) {
		CompoundCommand cc = new CompoundCommand("DropCollaborationOnCollaborationUse");

		EObject graphicalParentObject = graphicalTarget.resolveSemanticElement();
		if(graphicalParentObject instanceof CollaborationUse) {
			SetRequest req = new SetRequest(graphicalParentObject, UMLPackage.eINSTANCE.getCollaborationUse_Type(), semanticElement);
			SetTypeWithDialogCommand setTypeCommand = new SetTypeWithDialogCommand(req);
			cc.add(new ICommandProxy(setTypeCommand));
		}

		return cc;
	}
}
