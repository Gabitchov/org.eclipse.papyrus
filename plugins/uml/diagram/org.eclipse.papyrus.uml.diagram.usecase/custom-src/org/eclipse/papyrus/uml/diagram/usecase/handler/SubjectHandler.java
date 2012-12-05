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
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.papyrus.uml.diagram.usecase.command.ChangetoDefaultShapeCommand;
import org.eclipse.papyrus.uml.diagram.usecase.edit.parts.SubjectClassifierEditPartTN;
import org.eclipse.uml2.uml.Actor;
import org.eclipse.uml2.uml.UseCase;

/**
 * the goal of this class is to transform a default named element as a subject
 * 
 * 
 */
public class SubjectHandler extends ChangeShapeHandler implements IHandler {

	@Override
	public boolean isEnabled() {
		GraphicalEditPart editPart = getSelectedGraphicalEditpart();

		if(editPart == null) {
			return false;
		}

		if((editPart.resolveSemanticElement() instanceof org.eclipse.uml2.uml.Classifier && (!(editPart.resolveSemanticElement() instanceof Actor)) && (!(editPart.resolveSemanticElement() instanceof UseCase)))) {
			if((editPart instanceof SubjectClassifierEditPartTN)) {
				return false;
			} else {
				return true;
			}
		}
		return false;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.usecase.handler.ChangeShapeHandler#getChangeShapeCommand(org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart)
	 * 
	 * @param editPart
	 * @return
	 */
	@Override
	protected ChangetoDefaultShapeCommand getChangeShapeCommand(final GraphicalEditPart editPart) {
		ChangetoDefaultShapeCommand command = new ChangetoDefaultShapeCommand(editPart.getEditingDomain(), editPart);
		return command;
	}
}
