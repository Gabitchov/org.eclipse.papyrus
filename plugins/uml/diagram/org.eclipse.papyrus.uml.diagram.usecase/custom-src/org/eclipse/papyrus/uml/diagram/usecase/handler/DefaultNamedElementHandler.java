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
package org.eclipse.papyrus.uml.diagram.usecase.handler;

import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.uml.diagram.usecase.command.ElementToDefaultNamedElementShape;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.ActorEditPartTN;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.SubjectClassifierEditPartTN;

/**
 * the goal of this class is to transform a change a Subject as a default named Element
 * 
 */
public class DefaultNamedElementHandler extends ChangeShapeHandler implements IHandler {

	protected TransactionalEditingDomain transactionalEditingDomain = null;

	protected org.eclipse.uml2.uml.Element selectedElement = null;

	@Override
	public boolean isEnabled() {
		GraphicalEditPart editPart = getSelectedGraphicalEditpart();
		if((editPart instanceof SubjectClassifierEditPartTN) || (editPart instanceof ActorEditPartTN)) {
			return true;
		}
		return false;
	}

	@Override
	protected AbstractTransactionalCommand getChangeShapeCommand(GraphicalEditPart editPart) {
		ElementToDefaultNamedElementShape command = new ElementToDefaultNamedElementShape(editPart.getEditingDomain(), editPart);
		return command;
	}
}
