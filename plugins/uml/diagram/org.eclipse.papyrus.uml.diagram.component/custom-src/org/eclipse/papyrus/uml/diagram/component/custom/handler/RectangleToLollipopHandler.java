/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.component.custom.handler;

import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.uml.diagram.common.commands.SemanticAdapter;
import org.eclipse.papyrus.uml.diagram.component.custom.command.RectangleToLollipopCommand;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.RectangleInterfaceEditPart;

/**
 * this handler is used to change the display of an interface as rectangle to lollipop
 *
 */
public class RectangleToLollipopHandler extends ChangeShapeHandler implements IHandler {

	protected TransactionalEditingDomain transactionalEditingDomain = null;

	protected org.eclipse.uml2.uml.Element selectedElement = null;


	/**
	 * 
	 * Constructor.
	 *
	 */
	public RectangleToLollipopHandler() {
		newType=""+InterfaceEditPart.VISUAL_ID;
	}
	@Override
	public boolean isEnabled() {
		GraphicalEditPart editPart = getSelectedGraphicalEditpart();
		if((editPart instanceof RectangleInterfaceEditPart) ) {
			return true;
		}
		return false;
	}
	@Override
	protected AbstractTransactionalCommand getChangeShapeCommand(GraphicalEditPart editPart) {
		RectangleToLollipopCommand command = new RectangleToLollipopCommand(editPart.getEditingDomain(), editPart, new SemanticAdapter(null, null));
		return command;
	}
}