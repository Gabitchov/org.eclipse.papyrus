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
import org.eclipse.papyrus.uml.diagram.component.custom.command.LollipopToRectangleCommand;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceEditPart;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.InterfaceEditPartPCN;
import org.eclipse.papyrus.uml.diagram.component.edit.parts.RectangleInterfaceEditPart;

/**
 * this class is the Handler to change a interface displayed as lollipop to rectnagle
 *
 */
public class LollipopToRectangleHandler extends ChangeShapeHandler implements IHandler {

	protected TransactionalEditingDomain transactionalEditingDomain = null;

	protected org.eclipse.uml2.uml.Element selectedElement = null;


	/**
	 * 
	 * Constructor.
	 *
	 */
	public LollipopToRectangleHandler() {
		super();
		newType=""+RectangleInterfaceEditPart.VISUAL_ID;
	}
	@Override
	public boolean isEnabled() {
		GraphicalEditPart editPart = getSelectedGraphicalEditpart();
		if((editPart instanceof InterfaceEditPart)||(editPart instanceof InterfaceEditPartPCN)) {
			return true;
		}
		return false;
	}
	@Override
	protected AbstractTransactionalCommand getChangeShapeCommand(GraphicalEditPart editPart) {
		LollipopToRectangleCommand command = new LollipopToRectangleCommand(editPart.getEditingDomain(), editPart, new SemanticAdapter(null, null));
		return command;
	}

}