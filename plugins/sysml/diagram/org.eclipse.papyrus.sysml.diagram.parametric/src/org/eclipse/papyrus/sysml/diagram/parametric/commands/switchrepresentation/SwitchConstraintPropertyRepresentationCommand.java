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

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.StringValueStyle;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.common.edit.part.ConstraintBlockPropertyCompositeEditPart;
import org.eclipse.papyrus.sysml.diagram.common.figure.ConstraintBlockPropertyCompositeFigure;
import org.eclipse.papyrus.sysml.diagram.common.utils.SysMLGraphicalTypes;
import org.eclipse.papyrus.sysml.diagram.parametric.edit.part.CustomConstraintBlockPropertyCompositeEditPart;

/**
 * This command allow to switch ConstraintProperty representation to rounded corner one to square one with structure compartment
 */
public class SwitchConstraintPropertyRepresentationCommand extends Command {

	private final GraphicalEditPart editPartToSwitch;

	public SwitchConstraintPropertyRepresentationCommand(final GraphicalEditPart editPartToRefresh) {
		this.editPartToSwitch = editPartToRefresh;
	}

	public GraphicalEditPart getEditPartToSwitch() {
		return this.editPartToSwitch;
	}

	
	@Override
	public void execute() {
		if (this.getEditPartToSwitch() instanceof CustomConstraintBlockPropertyCompositeEditPart) {
			CustomConstraintBlockPropertyCompositeEditPart constraintBlockPropertyCompositeEditPart = (CustomConstraintBlockPropertyCompositeEditPart)this.getEditPartToSwitch();
			ConstraintBlockPropertyCompositeFigure figure = constraintBlockPropertyCompositeEditPart.getPrimaryShape();
			if (figure instanceof ConstraintBlockPropertyCompositeFigure) {
				if (figure.getCorner() != 0) {
					switchToSquareRepresentationWithStructure(constraintBlockPropertyCompositeEditPart, figure);
				}
				else {
					switchToRoundedRepresentationWithoutStructure(constraintBlockPropertyCompositeEditPart, figure);
				}
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	private void switchToSquareRepresentationWithStructure(CustomConstraintBlockPropertyCompositeEditPart editPart, IFigure figure) {
		
		// Set corner as square
		int newCorner = 0;
		((ConstraintBlockPropertyCompositeFigure) figure).setCorner(newCorner);

		// add structure compartment (create if does not exist, set visible if exist)
		View structureCompartment = editPart.getChildViewBySemanticHint(SysMLGraphicalTypes.COMPARTMENT_SYSML_BLOCKPROPERTY_STRUCTURE_ID);
		if (structureCompartment != null) {
			structureCompartment.setVisible(true);
		}
		else {
			structureCompartment = ViewService.createNode((View)editPart.getModel(), SysMLGraphicalTypes.COMPARTMENT_SYSML_BLOCKPROPERTY_STRUCTURE_ID, new PreferencesHint("org.eclipse.papyrus.sysml.diagram.parametric"));
			if (structureCompartment != null) {
				structureCompartment.setElement(editPart.resolveSemanticElement());
			}
		}
		
		// add the << constraint >> tag
		editPart.getPrimaryShape().setTagLabel(String.valueOf("\u00AB") + "constraint" + String.valueOf("\u00BB"));
		
		// set the style to persist representation
		StringValueStyle style = (StringValueStyle)((View)editPart.getModel()).getStyle(NotationPackage.eINSTANCE.getStringValueStyle());
		if (style == null) {
			((View)editPart.getModel()).getStyles().add(NotationFactory.eINSTANCE.createStringValueStyle());
		}
		style = (StringValueStyle)((View)editPart.getModel()).getStyle(NotationPackage.eINSTANCE.getStringValueStyle());
		style.setName(CustomConstraintBlockPropertyCompositeEditPart.REPRESENTATION_MODE_STYLE);
		style.setStringValue(CustomConstraintBlockPropertyCompositeEditPart.SQUARE_REPRESENTATION_WITH_STRUCTURE);
		
		// set the default style for new elements 
		ConstraintBlockPropertyCompositeEditPart.setLastRepresentation(CustomConstraintBlockPropertyCompositeEditPart.SQUARE_REPRESENTATION_WITH_STRUCTURE);
		editPart.setCornerLocators(newCorner);
	}

	@SuppressWarnings("unchecked")
	private void switchToRoundedRepresentationWithoutStructure(CustomConstraintBlockPropertyCompositeEditPart editPart, IFigure figure) {
		// rounded corner
		int newCorner = 50;
		((ConstraintBlockPropertyCompositeFigure) figure).setCorner(newCorner);


		// hide structure compartment if exist
		View structureCompartmentFigure = editPart.getChildViewBySemanticHint(SysMLGraphicalTypes.COMPARTMENT_SYSML_BLOCKPROPERTY_STRUCTURE_ID);
		if (structureCompartmentFigure != null) {
			structureCompartmentFigure.setVisible(false);
		}

		// remove the << constraint >> tag
		editPart.getPrimaryShape().setTagLabel("");
		
		// set the style to persist representation		
		StringValueStyle style = (StringValueStyle)((View)editPart.getModel()).getStyle(NotationPackage.eINSTANCE.getStringValueStyle());
		if (style == null) {
			((View)editPart.getModel()).getStyles().add(NotationFactory.eINSTANCE.createStringValueStyle());
		}
		style = (StringValueStyle)((View)editPart.getModel()).getStyle(NotationPackage.eINSTANCE.getStringValueStyle());
		style.setName(CustomConstraintBlockPropertyCompositeEditPart.REPRESENTATION_MODE_STYLE);
		style.setStringValue(CustomConstraintBlockPropertyCompositeEditPart.ROUNDED_REPRESENTATION);

		// set the default style for new elements 
		ConstraintBlockPropertyCompositeEditPart.setLastRepresentation(CustomConstraintBlockPropertyCompositeEditPart.ROUNDED_REPRESENTATION);
		editPart.setCornerLocators(newCorner);
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
