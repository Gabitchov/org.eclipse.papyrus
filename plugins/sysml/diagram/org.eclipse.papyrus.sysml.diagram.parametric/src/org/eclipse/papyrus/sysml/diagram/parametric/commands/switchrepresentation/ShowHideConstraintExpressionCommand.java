/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Régis CHEVREL: chevrel.regis <at> gmail.com
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.parametric.commands.switchrepresentation;

import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.common.figure.ConstraintBlockPropertyCompositeFigure;
import org.eclipse.papyrus.sysml.diagram.parametric.edit.part.CustomConstraintBlockPropertyCompositeEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.ConstraintNodeLabelEditPart;

/**
 * This command allow to show/hide the Constraint expression of a ConstraintProperty
 */
public class ShowHideConstraintExpressionCommand  extends Command {

	private final GraphicalEditPart editPartToSwitch;

	public GraphicalEditPart getEditPartToSwitch() {
		return editPartToSwitch;
	}

	public ShowHideConstraintExpressionCommand(final GraphicalEditPart editPartToRefresh) {
		this.editPartToSwitch = editPartToRefresh;
	}

	@Override
	public void execute() {
		if (this.getEditPartToSwitch() instanceof CustomConstraintBlockPropertyCompositeEditPart) {
			CustomConstraintBlockPropertyCompositeEditPart constraintBlockPropertyCompositeEditPart = (CustomConstraintBlockPropertyCompositeEditPart)this.getEditPartToSwitch();
			// get the Constraint expression graphical label
			WrappingLabel constraintLabel = ((ConstraintBlockPropertyCompositeFigure)constraintBlockPropertyCompositeEditPart.getPrimaryShape()).getConstraintLabel();
			ConstraintNodeLabelEditPart constraintNodeLabelEditPart = null;
			// get the EditPart which contains this label
			for (Object currentEditPart : constraintBlockPropertyCompositeEditPart.getChildren()) {
				if (currentEditPart instanceof ConstraintNodeLabelEditPart) {
					if (((ConstraintNodeLabelEditPart) currentEditPart).getFigure() == constraintLabel) {
						constraintNodeLabelEditPart = (ConstraintNodeLabelEditPart)currentEditPart;
					}
				}
			}
			
			// switch visibility of this EditPart
			if (constraintNodeLabelEditPart != null) {
				View constraintLabelView = (View)constraintNodeLabelEditPart.getModel();
				constraintLabelView.setVisible(!constraintLabelView.isVisible());
			}
		}
	}

	@Override
	public void undo() {
		execute(); // switch
	}
	
	@Override
	public void redo() {
		execute(); // switch
	}
	
}
