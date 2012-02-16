package org.eclipse.papyrus.diagram.activity.edit.part;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.diagram.activity.edit.parts.ActivityActivityContentCompartmentEditPart;


public class CustomActivityActivityContentCompartmentEditPart extends ActivityActivityContentCompartmentEditPart {

	public CustomActivityActivityContentCompartmentEditPart(View view) {
		super(view);
	}

	/**
	 * remove the top border
	 */
	@Override
	public IFigure createFigure() {
		ResizableCompartmentFigure result = (ResizableCompartmentFigure)super.createFigure();
		result.setTitleVisibility(false);
		// remove the top border
		result.setBorder(null);
		return result;
	}

	/**
	 * Unselectable compartment
	 */
	@Override
	public boolean isSelectable() {
		return false;
	}


}
